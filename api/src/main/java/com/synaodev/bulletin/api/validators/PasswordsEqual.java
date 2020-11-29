package com.synaodev.bulletin.api.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordsEqualValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsEqual {
	String message() default "Password confirmation differs from previously input password";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
