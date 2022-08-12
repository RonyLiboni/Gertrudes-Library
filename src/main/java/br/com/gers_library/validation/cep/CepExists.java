package br.com.gers_library.validation.cep;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CepValidator.class)
public @interface CepExists {
	
	String message() default "The cep you informed doesn't exist!";

	boolean required() default true;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
