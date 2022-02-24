package main.src;

import static main.src.Gender.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("John", MALE), new Person("Brain", MALE), new Person("Maria", FEMALE),
                new Person("Siti", FEMALE), new Person("Desmond", MALE));
        // Imprative approach

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative appoarch
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender); // java.util.Function where
                                                                                    // Predicate is a method that change
                                                                                    // person to boolean statement

        List<Person> females2 = people.stream().filter(personPredicate) // "-> is a if statement"
                .collect(Collectors.toList());
        females2.forEach(System.out::println); // double colomn operator "::" is a method reference

    }

}

class Person {
    private final String name;
    final Gender gender;

    Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {

        return "Person{" + "name='" + name + '\'' + ", gender=" + gender + '}';
    }
}

enum Gender {
    MALE, FEMALE
}
