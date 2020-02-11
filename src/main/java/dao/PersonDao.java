package dao;

import domain.Person;

import java.util.List;

/**
 * PersonDao.
 *
 * @author Natalia_Shipova
 */
public interface PersonDao {

    Person getByName(String name) throws PersonNotFoundException;

    List<Person> getAll();

    void deleteByName(String name) throws PersonNotFoundException;

    void save(Person person);
}
