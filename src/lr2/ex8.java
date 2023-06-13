//8. Создание классов и наследования для работы с животными:
//        	Создайте класс Animal (животное) и добавьте в него поля и методы, которые общие для всех животных (например, имя, возраст, метод для издания звука).
//        	Создайте подклассы (например, Dog, Cat, Bird), которые наследуют класс Animal и добавляют свои уникальные поля и методы (например, порода, тип корма, способность летать).
//        	Создайте объекты для каждого из подклассов и вызовите их методы, чтобы проверить, что наследование работает корректно.

package lr2;

class Animal {
    private String name;
    private String TypicalSound;
    private int age;


    //конструктор для класса Animal
    public Animal(String name, String TypicalSound, int age) {
        this.name = name;
        this.TypicalSound = TypicalSound;
        this.age = age;

    }

    public String MakeSomeNoize() {
        return TypicalSound;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public void sayCommon() {
        System.out.println("Имя животного: " + getName()+" \nВозраст: "+getAge()+"\nТипичный звук: "+MakeSomeNoize());
    }
}

class Wolf extends Animal {
    private String color;
    private int killed_animals;

    public Wolf(String name, String TypicalSound, int age, String color, int killed_animals) {
        super(name, TypicalSound, age);
        this.color = color;
        this.killed_animals = killed_animals;
    }

    public String getColor() {
        return color;
    }

    public int getKilled_animals() {
        return killed_animals;
    }

    public void SayYours() {
        System.out.println("\nЯ убил " + getKilled_animals() + " овец. \nМой цвет шкуры: " + getColor());
    }
}

    class Cat extends Animal {
        private String breed;
        private Boolean CanClimb;

        public Cat(String name, String TypicalSound, int age, String breed, Boolean CanClimb) {
            super(name, TypicalSound, age);
            this.breed = breed;
            this.CanClimb = CanClimb;
        }

        public String getBreed() {
            return breed;
        }

        public Boolean GetCanClimb() {
            return CanClimb;
        }

        public void SayYours() {
            System.out.println("\nМой порода " + getBreed() + "\n Я могу карабкаться по деревьям: " + GetCanClimb());
        }

        public void MakeCatThings() {
            System.out.println("\nЯ разбила тарелку");
        }
    }

    class Fish extends Animal {
        private Boolean can_swim;
        private double swim_speed;

        public Fish(String name, String TypicalSound, int age, Boolean can_swim, double swim_speed) {
            super(name, TypicalSound, age);
            this.can_swim = can_swim;
            this.swim_speed = swim_speed;
        }

        public double getSwimSpeed() {
            return swim_speed;
        }

        public Boolean GetCanSwim() {
            return can_swim;
        }

        public void SayYours() {
            System.out.println("\n\nЯ умею плавать" + GetCanSwim() + "\n Моя скорость: " + getSwimSpeed());
        }

        public void SayBubble() {
            System.out.println("\nКто проживает на дне океана?");
        }
    }
public class ex8 {
    public static void main(String[] args) {
        Wolf wolfy = new Wolf("Michael", "aooooo", 13, "black", 19);
        wolfy.sayCommon();
        wolfy.SayYours();
        Cat kitty = new Cat("Clara", "Myooow", 11, "egypt", Boolean.TRUE);
        kitty.sayCommon();
        kitty.SayYours();
        kitty.MakeCatThings();
        Fish cloun = new Fish("Marvin", "blow-blow", 1, Boolean.TRUE, 16);
        cloun.sayCommon();
        cloun.SayYours();
        cloun.SayBubble();
    }
}