package com.dogproductinventory.app.domain;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PostcodeValidator.class)
public @interface Postcode {
    String message() default "Invalid Finnish postal code!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
