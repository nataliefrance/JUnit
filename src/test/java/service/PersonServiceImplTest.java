package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import dao.PersonDao;
import domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        //mock при любом getByName возвращает Ivan
//        given(personDao.getByName(any()))
//                .willReturn(new Person(10, "Ivan"));

        when(personDao.getByName(Mockito.eq("Ivan"))).thenReturn(new Person(10, "Ivan"));
        assertThat(personService.getByName("Ivan")).isEqualTo(new Person(10, "Ivan"));
    }
}