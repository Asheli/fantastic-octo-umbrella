package ru.foe.person;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
