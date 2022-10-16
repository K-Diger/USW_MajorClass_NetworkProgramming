package week6;

import java.io.Serializable;

public class Person implements Serializable {

    private static String type = "A";
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Person.type = type;
    }
}
