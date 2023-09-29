//Создание классов и наследования для работы с геометрическими фигурами:
//        	Создайте класс Shape (фигура) и добавьте в него поля и методы, которые общие для всех геометрических фигур (например, методы для вычисления площади и периметра).
//        	Создайте подклассы (например, Circle, Square, Triangle), которые наследуют класс Shape и добавляют свои уникальные поля и методы (например, радиус, стороны, высота).
//        	Создайте объекты для каждого из подклассов и вызовите их методы, чтобы проверить, что наследование работает корректно.

package lr2;

class Shape {
    int chisloUglov;
    boolean is_it_circle;


    //конструктор для класса Shape
    public Shape(int chisloUglov, boolean is_it_circle) {
        this.chisloUglov = chisloUglov;
        this.is_it_circle = is_it_circle;
    }

    public int getChisloUglov() {
        return chisloUglov;
    }
    public String WhatFigureItIs() {
        if (chisloUglov == 0) {
            return "circle";
        }
        if (chisloUglov == 2) {
            return "line";
        }
        if (chisloUglov == 4) {
            return "paralelogram";
        }
        if (chisloUglov == 3) {
            return "triangle";
        } else {
            return "some_starnge";
        }
    }
    public void CommonInfo() {
        System.out.println("\nЧисло углов в фигуре " + getChisloUglov() + "\nСкорее всего это фигура " + WhatFigureItIs());
        }
}

    class Circle2 extends Shape {
        private double radius;

        public Circle2(int chisloUglov,  boolean is_it_circle, double radius) {
            super(chisloUglov, is_it_circle);
            this.radius = radius;
        }

        public void setRadius(double radius) {
            if (radius >= 0) {
                this.radius = radius;
            } else {
                System.out.println("Радиус не может быть отрицательным");
            }
        }

        public double getSquare() {
            return Math.PI * (2 * radius);
        }

        public double getDiametr() {
            return (2 * radius);
        }

    public double getPerimiter() {
        return Math.PI * (2 * radius);
    }
    public void AboutCircle() {
            System.out.println("\nПлощадь круга " + getSquare() + "\nДиаметр " + getDiametr());
        }
}

class Square2 extends Shape {
    private double side;

    public Square2(int chisloUglov,  boolean is_it_circle, double side) {
        super(chisloUglov, is_it_circle);
        this.side = side;
    }
    public void setSide(double side) {
        if (side >= 0) {
            this.side = side;
        } else {
            System.out.println("Сторона не может быть отрицательным");
        }
    }

    public double getSide() {
        return side;
    }

    public double getSquare() {
        return  side * side;
    }

    public double getPerimiter() {
        return side * 4;
    }

    public void AboutSquare() {
        System.out.println("\nПериметр квадрата " + getPerimiter());
    }
}

class Rectangle3  extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Rectangle3(int chisloUglov, boolean is_it_circle, double side1, double side2, double side3) {
        super(chisloUglov, is_it_circle);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getside1() {
        return side1;
    }

    public double getside2() {
        return side2;
    }

    public double getside3() {
        return side3;
    }

    public String AboutRecatngle() {
        if (side1 == side2 | side2 == side3 | side1 == side3) {
            return "Равнобедренный треугольгник";
        }
        if ((side1 == side2) & (side2 == side3)) {
            return "Равносторонний треугольник";
        } else {
            return "Какой-то треугольник";
        }

    }
}


public class ex9 {
    public static void main(String[] args) {
        Circle2 neew1 = new Circle2(0, Boolean.TRUE, 11);
        neew1.AboutCircle();
        neew1.WhatFigureItIs();
        neew1.CommonInfo();
        neew1.getDiametr();
        Square2 neew2 = new Square2(4, Boolean.FALSE, 12);
        neew2.AboutSquare();
        neew2.WhatFigureItIs();
        Rectangle3 neew3 = new Rectangle3(3, Boolean.FALSE, 6, 6, 6);
        System.out.println("Это треугольник " + neew3.AboutRecatngle());
        neew3.CommonInfo();
    }
}
