package br.com.gers_library.validation.document_cpf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DocumentCpfValidator.class)
public @interface DocumentCpfIsValid {
	
	String message() default "You must write a valid CPF!";

	boolean required() default true;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
