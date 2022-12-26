package io.github.cafeteru.validator_lib.impl;

import java.util.Objects;
import java.util.regex.Pattern;

import io.github.cafeteru.validator_lib.Validator;
import lombok.AllArgsConstructor;

/**
 * Validate that a text has the correct form of an DNI
 */
@AllArgsConstructor
public class ValidatorPhone implements Validator {
    private String value;

    @Override
    public boolean isValid() {
        if (Objects.isNull(value)) {
            return true;
        }
        var pattern = Pattern.compile("^[679]\\d{8}$");
        var mather = pattern.matcher(value);
        return mather.find();
    }
}
