package io.github.cafeteru.validator_lib;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.github.cafeteru.validator_lib.PhoneValidator;

/**
 * Check class ValidatorPhone
 */
class PhoneValidatorTest {

    /**
     * Checks the functionality with valid data
     */
    @ParameterizedTest
    @ValueSource(strings = {
        "625789535",
        "725789535",
        "925789535",
    })
    void validData(String phone) {
        var validator = new PhoneValidator(phone);
        assertTrue(validator.isValid());
    }

    /**
     * Checks the functionality with null data
     */
    @Test
    void nullData() {
        var validator = new PhoneValidator(null);
        assertTrue(validator.isValid());
    }

    /**
     * Checks the functionality with invalid data
     */
    @ParameterizedTest
    @ValueSource(strings = {
        "@gmail.es",
        "62578955",
        "6257895533",
        ""
    })
    void invalidData(String phone) {
        var validator = new PhoneValidator(phone);
        assertFalse(validator.isValid());
    }
}
