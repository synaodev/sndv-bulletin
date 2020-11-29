package com.synaodev.bulletin.api.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.synaodev.bulletin.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueHandleValidator implements ConstraintValidator<UniqueHandle, String> {
	@Autowired UserRepository repository;
	@Override
	public boolean isValid(String handle, ConstraintValidatorContext context) {
		return !repository.existsByHandle(handle);
	}
}
