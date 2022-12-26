package io.github.cafeteru.validator_lib.impl;

import io.github.cafeteru.validator_lib.Validator;
import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * Validate that a text has the correct form of an DNI
 */
@AllArgsConstructor
public class ValidatorDni implements Validator {
    private static final String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKET";
    private static final int SIZE = 9;

    private String dni;

    @Override
    public boolean isValid() {
        if (Objects.isNull(dni)) {
            return true;
        }
        try {
            if (dni.length() == SIZE && Character.isLetter(dni.charAt(dni.length() - 1))) {
                var myNumber = dni.substring(0, SIZE - 1);
                var numberConverted = Integer.parseInt(myNumber) % 23;
                var letterDni = dni.substring(SIZE - 1).toUpperCase();
                return letterDni.equals(LETTERS.substring(numberConverted, numberConverted + 1));
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
