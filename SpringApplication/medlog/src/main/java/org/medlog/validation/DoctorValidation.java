package org.medlog.validation;

import org.medlog.models.Doctors;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DoctorValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Doctors.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "description", "field.required");
    }
}
