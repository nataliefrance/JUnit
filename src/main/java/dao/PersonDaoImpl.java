package dao;

import domain.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * PersonDaoImpl.
 *
 * @author Natalia_Shipova
 */
@Getter
@Setter
public class PersonDaoImpl implements PersonDao {

    private List<Person> personList;

    @Override
    public Person getByName(String name) throws PersonNotFoundException {
        if (name == null || name.isEmpty()) {
            throw new PersonNotFoundException("Имя не может быть null или пустым.");
        }
        for (Person person : personList) {
            if (name.equals(person.getName())) {
                return person;
            }
        }
        throw new PersonNotFoundException("Person с именем " + name + " не найден");
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public void deleteByName(String name) throws PersonNotFoundException {
        if (name == null || name.isEmpty()) {
            throw new PersonNotFoundException("Имя не может быть null или пустым.");
        }
        Person person = getByName(name);
        personList.remove(person);
    }

    /**
     * Метод должен найти по имени в списке.
     * Если такой есть - заменить,
     * если такого нет - добавить.
     */
    @Override
    public void save(Person person) {
        personList.removeIf(p -> p.getName().equals(person.getName()));
        personList.add(person);
    }
}
