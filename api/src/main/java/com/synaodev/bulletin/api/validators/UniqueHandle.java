package com.synaodev.bulletin.api.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueHandleValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueHandle {
	String message() default "Handle is already in use";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
