package service;

import dao.PersonDao;
import domain.Person;

import java.util.List;

/**
 * PersonServiceImpl.
 *
 * @author Natalia_Shipova
 */
public class PersonServiceImpl  implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person getByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public List<Person> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean existsWithName(String name) {
        //TODO: реализовать данный метод по технике Test-First
        return false;
    }

    @Override
    public void save(Person p) {
        //TODO: реализовать данный метод по технике Test-First
    }
}
