//6. Создание классов и интерфейсов для работы с фигурами:
//        	Создайте классы для различных геометрических фигур (например, круг, квадрат, треугольник), каждый из которых имеет свои методы и поля.
//        	Создайте интерфейс, который определяет методы, которые должны быть реализованы для каждой фигуры, чтобы вычислить ее площадь и периметр.
//        	Реализуйте методы интерфейса в каждом классе фигуры и создайте объекты для каждой из них, чтобы вычислить их площадь и периметр.

package lr2;


    class Circle implements Geometric_shapes {
        private double radius;

        //конструктор для класса Circle
        public Circle(double radius) {
            this.radius = radius;
        }

        public void setRadius(double radius) {
            if (radius >= 0) {
                this.radius = radius;
            } else {
                System.out.println("Радиус не может быть отрицательным");
            }
        }

        public double getRadius() {
            return radius;
        }

        public double getSquare() {
            System.out.println("Площадь круга равна " + Math.PI * (2 * radius));
            double square = Math.PI * (radius * radius);
            return square;
        }

        public double getPerimiter() {
            System.out.println("Периметр круга равен " + Math.PI * (radius * radius));
            double perimiter = Math.PI * (2 * radius);
            return perimiter;
        }
    }

    class Square implements Geometric_shapes {
        private double side;

        //конструктор для класса Square
        public Square(double side) {
            this.side = side;
        }

        public void setSide(double side) {
            if (side >= 0) {
                this.side = side;
            } else {
                System.out.println("Радиус не может быть отрицательным");
            }
        }

        public double getSide() {
            return side;
        }

        public double getSquare() {
            System.out.println("Площадь квадрата равна " + side * side);
            double square = side * side;
            return square;
        }

        public double getPerimiter() {
            System.out.println("Периметр квадрата равен " + side * 4);
            double perimiter = side * 4;
            return perimiter;
        }
    }

    class Rectangle2 implements Geometric_shapes {
        private double length;
        private double width;

        //конструктор для класса Rectangle
        public Rectangle2(double length, double width) {
            this.length = length;
            this.width = width;
        }


        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public double getSquare() {
            double square = width*length;
            System.out.println("Периметр прямоугольника равен " +square);
            return square;
        }

        public double getPerimiter() {
            double perimiter = width+length*2;
            System.out.println("Периметр прямоугольника равен " + perimiter);
            return perimiter;
        }

    }

    interface Geometric_shapes {
        public double getSquare();

        public double getPerimiter();
    }

public class ex6 {
    public static void main(String[] args) {
        Geometric_shapes info1 = new Circle(12);
        Geometric_shapes info2 = new Rectangle2(5, 15);
        Geometric_shapes info3 = new Square(5);
        info1.getPerimiter();
        info1.getSquare();
        info2.getPerimiter();
        info2.getSquare();
        info3.getPerimiter();
        info3.getSquare();
    }
}