package br.com.gers_library.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gers_library.entities.exception.FieldErrorsDto;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<FieldErrorsDto>> formFieldsHasErrors(MethodArgumentNotValidException exception) {
		List<FieldErrorsDto> fieldErrorsdto = new ArrayList<>();
		
		exception.getBindingResult().getFieldErrors().forEach(error ->{
			fieldErrorsdto.add(FieldErrorsDto.builder()
					.field(error.getField())
					.error(error.getDefaultMessage())
					.build());
		});;

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrorsdto);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> idNotFound(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
		
	
}
