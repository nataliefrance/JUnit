package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import dao.PersonDao;
import dao.PersonNotFoundException;
import domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * PersonServiceImplTest.
 *
 * @author Natalia_Shipova
 */
@ExtendWith(MockitoExtension.class) //позволяет подставить mock  в поле теста
class PersonServiceImplTest {

    @Mock
    private PersonDao personDao;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonServiceImpl(personDao);
    }

    @Test
    void getByName() {
//        mock при любом getByName возвращает Ivan
//        given(personDao.getByName(any()))
//                .willReturn(new Person(10, "Ivan"));

        when(personDao.getByName(Mockito.eq("Ivan"))).
                thenReturn(new Person(10, "Ivan"));
        assertThat(personService.getByName("Ivan")).
                isEqualTo(new Person(10, "Ivan"));
    }

    @Test
    public void getAll() {
        List<Person> personList = newPersonList();
        when(personDao.getAll()).thenReturn(personList);
        assertThat(personService.getAll()).isEqualTo(personList);
    }

    @Test
    public void existsWithName(String name) {
        when(personDao.getByName("Maria")).thenThrow(new PersonNotFoundException("Person с именем " + name + " не найден"));
        when(personDao.getByName("Ivan")).thenReturn(new Person(42, "Ivan"));
        assertThat(personService.existsWithName("Ivan")).isNotNull();
        assertThat(personService.existsWithName("Maria")).isFalse();
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
}