package dao;

/**
 * PersonNotFoundException.
 *
 * @author Natalia_Shipova
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String message) {
        super(message);
    }
}
