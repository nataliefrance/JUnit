import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(person).matches(p -> p.getAge() == 42 && "Ivan".equals(p.getName()));
    }

    @DisplayName("корректно увеличивает возраст")
    @Test
    void birthDay() {
        Person person = getPerson();
        person.birthDay();
        assertThat(person.getAge()).isEqualTo(43);
    }

    @DisplayName("корректно устанавливает возраст")
    @Test
    void setAge() {
        Person person = getPerson();
        person.setAge(18);
        assertThat(person.getAge()).isEqualTo(18);
    }

    @DisplayName("корректно устанавливает имя")
    @Test
    void setName() {
        Person person = getPerson();
        person.setName("Vasiliy");
        assertThat(person.getName()).isEqualTo("Vasiliy");
    }

    private Person getPerson(){
        return new Person(42, "Ivan");
    }
}