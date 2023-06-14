package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

record TitleNews(String title, String publicDate) {

}

public class Ex4 {
    private static final String filePath = "src/lr8/htmlParser.txt";

    public static void main(String[] args) {
        String title;
        String publicDate;
        String url = "http://fat.urfu.ru/index.html";
        int maxTries = 3;
        int tryCount = 0;
        List<TitleNews> listNewsTitle = new ArrayList<>();
        Document doc = null;

        // Попытка подключения к сайту
        try {
            while (tryCount < maxTries) {
                try {
                    doc = Jsoup.connect(url).get();
                    break;
                } catch (IOException e) {
                    tryCount++;
                    // Если количество попыток подключения превышает максимальное значение, программа завершается
                    if (tryCount == maxTries) {
                        System.out.println("Ошибка при подключение к URL: " + url);
                        System.exit(0);
                    } else {
                        // Иначе программа ждет 5 секунд и повторяет попытку подключения
                        Thread.sleep(5000);
                        System.out.println("Повторное подключение... №" + tryCount);
                    }
                }
            }

            // Парсинг новостей
            assert doc != null;
            Elements newsParent = doc.select(
                    "body > table > tbody > tr > td > div > table > " +
                            "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                            "tr > td:nth-child(1)");

            for (int i = 3; i < 20; i++) {
                if (!(i % 2 == 0)) {
                    List<Node> nodes = newsParent.get(0).childNodes();
                    title = ((Element) nodes.get(i)).getElementsByClass("blocktitle")
                            .get(0).childNodes().get(0).toString();
                    publicDate = ((Element) nodes.get(i)).getElementsByClass("blockdate")
                            .get(0).childNodes().get(0).toString();
                    TitleNews tItleNews = new TitleNews(title, publicDate);
                    listNewsTitle.add(tItleNews);
                }
            }

            // Запись заголовков новостей в файл
            writeData(listNewsTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для записи заголовков новостей в файл
    public static void writeData(List<TitleNews> titleNewsList) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(filePath), StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Запись заголовков новостей в файл
        for (TitleNews news : titleNewsList) {
            try {
                assert bw != null;
                bw.write("Заголовок: " + news.title() + ", Дата публикации: " + news.publicDate());
                bw.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assert bw != null;
        bw.flush();
        bw.close();
    }
}
