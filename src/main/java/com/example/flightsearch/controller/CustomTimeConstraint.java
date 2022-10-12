package com.example.flightsearch.controller;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomTimeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomTimeConstraint {
    String message() default "Invalid time format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}