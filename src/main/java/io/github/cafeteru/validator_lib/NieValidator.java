package io.github.cafeteru.validator_lib;

import java.util.Objects;

import lombok.AllArgsConstructor;

/**
 * Validate a text has the correct form of an NIE
 */
@AllArgsConstructor
public class NieValidator implements Validator {
    private String nie;

    @Override
    public boolean isValid() {
        if (Objects.isNull(nie)) {
            return true;
        }
        if (nie.isEmpty()) {
            return false;
        }
        var aux = checkFirstLetter(nie.toUpperCase(), 'X', 0);
        aux = checkFirstLetter(aux, 'Y', 1);
        aux = checkFirstLetter(aux, 'Z', 2);
        return new DniValidator(aux).isValid();
    }

    private String checkFirstLetter(String nie, Character firstLetter, int numberLetter) {
        if (nie.charAt(0) == firstLetter) {
            return numberLetter + nie.substring(1);
        }
        return nie;
    }
}
