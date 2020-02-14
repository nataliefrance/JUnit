package service;

import domain.Person;

import java.util.List;

/**
 * PersonService.
 *
 * @author Natalia_Shipova
 */
public interface PersonService {
    Person getByName(String name);

    List<Person> getAll();

    boolean existsWithName(String name);

    void save(Person p);
}
