package io.github.cafeteru.validator_lib;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class EmailValidatorTest {

    @Test
    void valid_data() {
        var validator = new EmailValidator("email@email.es");
        assertTrue(validator.isValid());
    }

    @Test
    void null_data() {
        var validator = new EmailValidator(null);
        assertTrue(validator.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "",
        "@gmail.es",
        "email@gmail",
        "email@@gmail",
        "emailgmail.es",
        "emailgmailes"
    })
    void invalidData(String email) {
        var validator = new EmailValidator(email);
        assertFalse(validator.isValid());
    }
}
