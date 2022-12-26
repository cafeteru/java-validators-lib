package io.github.cafeteru.validator_lib;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;

/**
 * Validate a text has the correct form of an email
 */
@AllArgsConstructor
public class EmailValidator implements Validator {
    private String email;

    @Override
    public boolean isValid() {
        if (Objects.isNull(email)) {
            return true;
        }
        var pattern = Pattern.compile(
            "^\\w+(\\.[_A-Za-z0-9-])*@"
                + "\\w+(\\.[A-Za-z0-9])*(\\.[A-Za-z]{2,})$"
        );
        var mather = pattern.matcher(email);
        return mather.find();
    }
}
