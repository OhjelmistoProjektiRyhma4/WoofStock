package com.dogproductinventory.app.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_NUMBER_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private Pattern pattern;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}

