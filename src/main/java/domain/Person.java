package domain;

import lombok.Getter;
import lombok.Setter;

/**
 * domain.Person.
 *
 * @author Natalia_Shipova
 */
@Getter
@Setter
public class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void birthDay() {
        this.age++;
    }
}