package ru.foe.person.PersonMain;

import ru.foe.person.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class PersonMain {
    public static void main(String[] args) {
        Person person1 = new Person("Иван", 28);
        Person person2 = new Person("Сергей", 26);
        Person person3 = new Person("Мария", 18);
        Person person4 = new Person("Иван", 30);
        Person person5 = new Person("Дмитрий", 17);
        Person person6 = new Person("Дарья", 15);

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5, person6);
        String allNamesString = personList.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Имена: " + allNamesString);

        double underage = personList.stream()
                .mapToDouble(Person::getAge)
                .filter(x -> x < 18)
                .average().orElse(0);
        System.out.println("Средний возраст людей младше 18 - " + underage);


        Map<String, List<Person>> personByAverageAge = personList.stream()
                .collect(Collectors.groupingBy(Person::getName));
        personByAverageAge.forEach((name, p) -> System.out.printf("Имя: %s   Средний возраст: %s%n", name, p.stream().mapToDouble(Person::getAge).average().orElse(0)));

        List<Person> adults = personList.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .filter(p -> p.getAge() < 45 && p.getAge() > 20)
                .collect(Collectors.toList());
        adults.forEach(p -> System.out.println("Имя: " + p.getName() + ", Возраст:" + p.getAge()));
    }
}
