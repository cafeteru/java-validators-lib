package io.github.cafeteru.validator_lib.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.github.cafeteru.validator_lib.impl.ValidatorNie;

/**
 * Check class ValidatorNie
 */
class ValidatorNieTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "Z1854217P",
        "Y1387672G",
        "Y8331424X",
        "X3233633V"
    })
    void validData(String nie) {
        var validator = new ValidatorNie(nie);
        assertTrue(validator.isValid());
    }

    @Test
    void nullData() {
        var validator = new ValidatorNie(null);
        assertTrue(validator.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "Y050166T",
        "",
        "X0501662",
        "1050Y662T"
    })
    void invalidData(String nie) {
        var validator = new ValidatorNie(nie);
        assertFalse(validator.isValid());
    }
}
