//3.	Напишите программу «Шифр Цезаря», которая зашифровывает введенный текст.
//        Используете кодовую таблицу символов.
//        При запуске программы в консоль необходимо вывести сообщение: «Введите текст для шифрования»,
//        после ввода текста, появляется сообщение: «Введите ключ».
//        После того как введены все данные, необходимо вывести преобразованную строку с сообщением «Текст после преобразования: ».
//        Далее необходимо задать вопрос пользователю: «Выполнить обратное преобразование? (y/n)»,
//        если пользователь вводит «y», тогда выполнить обратное преобразование. Если пользователь вводит «n»,
//        того программа выводит сообщение «До свидания!».
//        Если пользователь вводит что-то другое, отличное от «y» или «n»,
//        то программа ему выводит сообщение: «Введите корректный ответ».

package lr2;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {

        Scanner id = new Scanner(System.in);
        // Выводим текст: «Введите текст для шифрования»,
        System.out.print("Введите текст для шифрования: ");
        // Записываем текст в переменную
        String text = id.nextLine();
        //Выводим текст  «Введите ключ».
        System.out.print("Введите число, на которое нужно осуществить сдвиг(ключ) ");
        // Пользователю вводит ключ для шифрования(число)
        int keey = id.nextInt();
        // В переменную записываем текст после преобразования, полученный вызовов метода ecrypt класса Caesar
        String encrypted = Caesar.encrypt(text, keey);
        // Выводится преобразованная строка
        System.out.print("Текст после преобразования :" + "\"" + encrypted + "\"");
        // Задаем вопрос пользователю: «Выполнить обратное преобразование? (y/n)»,
        System.out.print("\nВыполнить обратное преобразование? (y/n)"); // пользователю
        boolean anwer_yes = false;
        while (!anwer_yes) {
            String user_answer = id.next();
            // если пользователь вводит «y» - выполняем обратное преобразование
            if (user_answer.equalsIgnoreCase("y")) {
                // В переенную decrypter записываем расшифрованный текст, поулченный с помощью метода decrypt класса Caesar
                String decrypted = Caesar.decrypt(encrypted, keey);
                System.out.println(decrypted);
                anwer_yes = true;
            }
            // Если пользователь вводит «n» -  «До свидания!».
            else if (user_answer.equalsIgnoreCase("n")) {
                System.out.println("До свидания!");
                anwer_yes = true;
            }
            // Пользователь ввел некорретный ответ
            else {
                System.out.println("Ответ не соответствует ни одному из предложенных вариантов");
            }
        }
    }
    private static class Caesar  {
        static String text_encrypt;
        private static String encrypt(String incomeText, int key)
        {
            // Создаем массив из полученной строки
            char[] ArrayText = incomeText.toCharArray();
            // Создаем массив цифр, длиной переданного текста, сохраняем туда ASCII код символа
            int[] CharCode = new int[ArrayText.length];
            // Итерируемся по массиву с текстом
            for (int i = 0; i < ArrayText.length; i++)
            {
                // При конвертации буквы в цифру получаем её код.
                CharCode[i] = ArrayText[i];
                // Прибавляем к коду сдвиг, чтобы "зашифровать сообщение"
                CharCode[i] = CharCode[i] + key;
            }
            for (int i = 0; i < ArrayText.length; i++)
            {
                ArrayText[i] = (char) CharCode[i];
            }
            text_encrypt = new String(ArrayText);
            return text_encrypt;
        }
        // Ниже то же самое, что и в прошлом методе, но в обратном порядке
        private static String decrypt(String enText, int key)
        {
            char[] ArrayText = enText.toCharArray();
            int[] CharCode = new int[ArrayText.length];
            for (int i = 0; i < ArrayText.length; i++)
            {
                CharCode[i] = ArrayText[i];
                CharCode[i] = CharCode[i] - key;
            }
            for (int i = 0; i < ArrayText.length; i++)
            {
                ArrayText[i] = (char) CharCode[i];
            }
            text_encrypt = new String(ArrayText);
            return text_encrypt;
        }
    }

}