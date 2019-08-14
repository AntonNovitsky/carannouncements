package by.novitsky.carannouncements.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdValidatorTest {

    Validator<String> validator = new IdValidator();

    @Test
    public void validate(){
        assertTrue(validator.validate("1"));
        assertFalse(validator.validate("-1"));
        assertFalse(validator.validate("1.1"));
        assertFalse(validator.validate("1,1"));
        assertFalse(validator.validate("1a"));
        assertFalse(validator.validate("abc"));
    }

}