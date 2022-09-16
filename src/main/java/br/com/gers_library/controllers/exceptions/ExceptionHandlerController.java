package br.com.gers_library.controllers.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.gers_library.entities.exception.FieldErrorsDto;
import br.com.gers_library.entities.exception.IdNotFoundException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ApiResponse(responseCode= "400", description = "There was an error with the form you sent.")
	public ResponseEntity<List<FieldErrorsDto>> formFieldsHasErrors(MethodArgumentNotValidException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(exception.getBindingResult().getFieldErrors().stream()
													.map(error -> new FieldErrorsDto(error.getField(), error.getDefaultMessage()))
													.collect(Collectors.toList()));
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	@ApiResponse(responseCode= "404", description = "The id you informed doesn't exist.")
	public ResponseEntity<String> idNotFound(IdNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
		
	
}
