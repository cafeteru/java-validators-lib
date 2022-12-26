package io.github.cafeteru.validator_lib.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.github.cafeteru.validator_lib.impl.ValidatorPhone;

/**
 * Check class ValidatorPhone
 */
class ValidatorPhoneTest {

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
        var validator = new ValidatorPhone(phone);
        assertTrue(validator.isValid());
    }

    /**
     * Checks the functionality with null data
     */
    @Test
    void nullData() {
        var validator = new ValidatorPhone(null);
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
        var validator = new ValidatorPhone(phone);
        assertFalse(validator.isValid());
    }
}
