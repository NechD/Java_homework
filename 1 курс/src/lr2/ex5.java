//Создание класса "Прямоугольник":
//        	Создайте класс Rectangle, который содержит поля для длины и ширины прямоугольника.
//        	Добавьте методы, которые позволяют установить и получить значения этих полей.
//        	Добавьте методы, которые позволяют вычислить площадь и периметр прямоугольника.
//        	Добавьте конструктор, который позволяет создавать объекты класса Rectangle, используя значения для длины и ширины.


package lr2;

class Rectangle {
    // Длина
    private int length;
    // Ширина
    private int width;


    //конструктор для класса Rectangle
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getSquare() {
        return this.width * this.length;
    }

    public int getPerimeter() {
        return (this.width + this.length) * 2;
    }

    public void printOnDisplay() {
        int square = getSquare();
        int perimetr = getPerimeter();
        System.out.println("Прямоугольник. \n Длина: " + length + ", \n Ширина: " + width + " \n Площадь: " + square + " \nПериметр: " + perimetr);
    }
}


public class ex5 {
    public static void main(String[] args) {
        Rectangle my_rect = new Rectangle(15, 23);
        int lengthh = my_rect.getLength();
        int widthh = my_rect.getWidth();
        int sq = my_rect.getSquare();
        int per = my_rect.getPerimeter();
        System.out.println("Посмотрим информацию, вызвав метод printondisplay");
        my_rect.printOnDisplay();
        System.out.println("А теперь выведем все, полученное через геттеры");
        System.out.println("Тут выодится текст из геттеров \n Длина " + lengthh + ", \n Ширина " + widthh + " \n Площадь " + sq + " \nПериметр " + per);
    }
}

