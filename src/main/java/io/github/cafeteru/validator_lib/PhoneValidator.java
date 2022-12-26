package io.github.cafeteru.validator_lib;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;

/**
 * Validate a text has the correct form of a phone
 */
@AllArgsConstructor
public class PhoneValidator implements Validator {
    private String phone;

    @Override
    public boolean isValid() {
        if (Objects.nonNull(phone)) {
            return true;
        }
        var pattern = Pattern.compile("^[679]\\d{8}$");
        var mather = pattern.matcher(phone);
        return mather.find();
    }
}
