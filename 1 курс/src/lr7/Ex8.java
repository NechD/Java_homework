package lr7;

import java.io.*;

// Создаем класс с несколькими полями и реализуем интерфейс Serializable
class MyClass implements Serializable {
    String name;
    int age;
    double weight;

    // Конструктор класса
    public MyClass(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

public class Ex8 {
    public static void main(String[] args) {
        // Создаем объект класса
        MyClass obj = new MyClass("Дмитрий", 25, 176);

        try {
            // Записываем объект в файл в бинарном виде с помощью ObjectOutputStream
            FileOutputStream fileOut = new FileOutputStream("file.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Object has been serialized");

            // Восстанавливаем объект из файла с помощью ObjectInputStream
            FileInputStream fileIn = new FileInputStream("file.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyClass newObj = (MyClass) in.readObject();
            in.close();
            fileIn.close();

            // Выводим значения полей объекта на экран
            System.out.println("Name: " + newObj.name);
            System.out.println("Age: " + newObj.age);
            System.out.println("Weight: " + newObj.weight);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


