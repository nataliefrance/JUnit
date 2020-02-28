package service;

import dao.PersonDao;
import dao.PersonNotFoundException;
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
        if (name == null || name.isEmpty()) {
            throw new PersonNotFoundException("Имя не может быть null или пустым.");
        }

        try {
            return dao.getByName(name) != null;
        } catch (PersonNotFoundException e) {
            return false;
        }
    }

    /**
     * Метод должен найти по имени в списке.
     * Если такой есть - заменить,
     * если такого нет - добавить.
     */
    @Override
    public void save(Person p) {
        dao.save(p);
    }
}
