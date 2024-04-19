package com.dogproductinventory.app.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostcodeValidator implements ConstraintValidator<Postcode, String> {

    private static final String POSTCODE_PATTERN = "\\b\\d{5}\\b|\\b\\d{4}\\b";
    private Pattern pattern;

    @Override
    public void initialize(Postcode constraintAnnotation) {
        pattern = Pattern.compile(POSTCODE_PATTERN);
    }

    @Override
    public boolean isValid(String postcode, ConstraintValidatorContext context) {
        if (postcode == null || postcode.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(postcode);
        return matcher.matches();
    }
}


