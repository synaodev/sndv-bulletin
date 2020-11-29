package com.synaodev.bulletin.api.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.synaodev.bulletin.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	@Autowired UserRepository repository;
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !repository.existsByEmail(email);
	}
}
