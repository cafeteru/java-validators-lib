package io.github.cafeteru.validator_lib;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.github.cafeteru.validator_lib.DniValidator;


/**
 * Check class ValidatorDni
 */
class DniValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "14892253Y",
        "37468912A",
        "19484773R",
        "66690812N",
        "14718986K"
    })
    void validData(String dni) {
        var validator = new DniValidator(dni);
        assertTrue(validator.isValid());
    }

    @Test
    void nullData() {
        var validator = new DniValidator(null);
        assertTrue(validator.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "6069263B",
        "",
        "60692Z63B",
        "584654383",
        "58465438S"
    })
    void invalidData(String dni) {
        var validator = new DniValidator(dni);
        assertFalse(validator.isValid());
    }
}
