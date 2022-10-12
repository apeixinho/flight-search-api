package com.example.flightsearch.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomTimeValidator implements ConstraintValidator<CustomTimeConstraint, String> {

    @Override
    public void initialize(CustomTimeConstraint timeConstraint) {
    }

    @Override
    public boolean isValid(String timeField, ConstraintValidatorContext cxt) {
        return timeField != null && timeField.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")
            && (timeField.length() == 5) ;
    }

}