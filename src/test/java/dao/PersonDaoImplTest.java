package dao;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotEquals;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * PersonDaoImplTest.
 *
 * @author Natalia_Shipova
 */
class PersonDaoImplTest {

    @Test
    void getByName() {
        PersonDaoImpl personDao = newPersonDao();
        assertThat(personDao.getByName("Ivan"), is(personDao.getPersonList().get(0)));
    }

    @Test
    void getByName_throw_exception() throws PersonNotFoundException {
        PersonDaoImpl personDao = newPersonDao();
        try {
            personDao.getByName("Grigory");
        } catch (PersonNotFoundException e) {
            assertNotEquals("", e.getMessage());
        }
    }

    @Test
    void getAll() {
        List<Person> personList = newPersonList();
        PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.setPersonList(personList);

        assertThat(personDao.getAll(), is(personList));
    }

    @Test
    void deleteByName() {
        PersonDaoImpl personDao = newPersonDao();
        String name = "Ivan";
        personDao.deleteByName(name);

        try {
            personDao.getByName(name);
        } catch (PersonNotFoundException e){
            assertNotEquals("", e.getMessage());
        }
    }

    /**
     * Тестирование исключения с использованием возможностей JUnit 5.
     */
    @Test
    void deleteByName_throw_exception() {
        PersonDaoImpl personDao = newPersonDao();
        String name = "Maria";
        Throwable thrown = catchThrowable(() -> {
            personDao.deleteByName(name);
        });
        assertThat(thrown).isInstanceOf(PersonNotFoundException.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    /**
     * Метод должен найти по имени в списке.
     * Если такой есть - заменить,
     * если такого нет - добавить.
     */
    @Test
    void save() {
        PersonDao personDao = newPersonDao();

        Person maria = new Person(15, "Maria");
        personDao.save(maria);
        assertThat(personDao.getByName("Maria"), is(maria));

        Person newMaria = new Person(20, "Maria");
        personDao.save(newMaria);
        assertNotEquals(personDao.getByName("Maria"), maria);
    }

    private List<Person> newPersonList() {
        List<Person> personList = new ArrayList<>();
        Person personIvan = new Person(42, "Ivan");
        Person personVasiliy = new Person(30, "Vasiliy");
        Person personTatyana = new Person(25, "Tatyana");

        personList.add(personIvan);
        personList.add(personVasiliy);
        personList.add(personTatyana);
        return personList;
    }

    private PersonDaoImpl newPersonDao() {
        PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.setPersonList(newPersonList());
        return personDao;
    }
}