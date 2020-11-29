package com.synaodev.bulletin.api.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.synaodev.bulletin.api.forms.RegisterForm;

import org.springframework.stereotype.Component;

@Component
public class PasswordsEqualValidator implements ConstraintValidator<PasswordsEqual, Object> {
	@Override
	public void initialize(PasswordsEqual constraint) {

	}
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		RegisterForm form = (RegisterForm)object;
		String password = form.getPassword();
		String passwordConfirmation = form.getPasswordConfirmation();
		return password.equals(passwordConfirmation);
	}
}
