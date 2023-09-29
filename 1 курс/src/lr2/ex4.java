//4. Создание класса "Человек":
//        	Создайте класс Person, который содержит поля для имени, возраста и пола человека.
//        	Добавьте методы, которые позволяют установить и получить значения этих полей.
//        	Добавьте конструктор, который позволяет создавать объекты класса Person, используя значения для имени, возраста и пола.

package lr2;

class Human {
    // Имя
    private String name;
    // Возраст
    private int age;
    // Пол
    private String sex;

    //конструктор для класса Human
    public Human(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Некорретный возраст, возраст устанавливается равным 0");
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void printOnDisplay() {
        System.out.println("Имя: " + name + ", возраст: " + age + ", пол: " + sex);
    }
}


public class ex4 {
    public static void main(String[] args) {
        Human person = new Human(
                "Дмитрий",
                23,
                "m");
        String peopleName = person.getName();
        int peopleAge = person.getAge();
        String peopleSex = person.getSex();
        person.printOnDisplay();
        System.out.println("Имя: " + peopleName + ", возраст: " + peopleAge + ", пол: " + peopleSex);
        person.setAge(-21);
        person.setName("Аня");
        person.setSex("Женщина");
        System.out.println("Имя: " + person.getName() + ", возраст: " + person.getAge() + ", пол: " + person.getSex());
    }
}