import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * PersonTest.
 *
 * @author Natalia_Shipova
 */
@DisplayName("Класс Person")
class PersonTest {

    @DisplayName("корректно создаётся конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Person person = getPerson();

        assertEquals("Ivan", person.getName());
        assertEquals(42, person.getAge());

        assertAll("person",
                () -> assertEquals("Ivan", person.getName()),
                () -> assertEquals(42, person.getAge())
        );
    }

    @DisplayName("корректно увеличивает возраст")
    @Test
    void birthDay() {
        Person person = getPerson();
        person.birthDay();

        assertEquals(43, person.getAge());
    }

    @Test
    void setAge() {
        Person person = getPerson();
        person.setAge(18);

        assertEquals(18, person.getAge());
    }

    @Test
    void setName() {
        Person person = getPerson();
        person.setName("Vasiliy");

        assertEquals("Vasiliy", person.getName());
    }

    private Person getPerson(){
        return new Person(42, "Ivan");
    }
}