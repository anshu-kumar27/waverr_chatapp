package com.app.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(error->error.getField()+" : "+error.getDefaultMessage())
				.collect(Collectors.toList());
		
		ValidationErrorResponse validationErrorresponse  = new ValidationErrorResponse("Validation failed : ",errors);
		return new ResponseEntity<>(validationErrorresponse.getDetails().toString(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleCustomException(CustomException ex){
		System.out.println("EXCEPTION ENCOUNTERED ---------------------------------\nCustom Exception, details-> custom_exception message : "+ex.getMessage()+" , customException errorCode : "+ex.getErrorCode());
		HttpStatus status = HttpStatus.resolve(ex.getErrorCode());
		if(status == null) 
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		System.out.println("Status type processed from errorcode successfully : "+status);
		return new ResponseEntity<>(ex.getMessage(),status);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
		System.out.println("EXCEPTION ENCOUNTERED ---------------------------------\nRuntime exception (internal server error), details : "+ ex.getMessage());
	    return new ResponseEntity<>("A required resource was not found.", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
		System.out.println("EXCEPTION ENCOUNTERED ---------------------------------\nRuntime exception (internal server error), details : "+ ex.getMessage());	    return new ResponseEntity<>("Invalid arguments provided.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRunTimeException(RuntimeException ex){
		System.out.println("EXCEPTION ENCOUNTERED ---------------------------------\nRuntime exception (internal server error), details : "+ ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex){
		System.out.println("EXCEPTION ENCOUNTERED ---------------------------------\nGeneric exception <Details are below>\n");
		ex.printStackTrace();
		return new ResponseEntity<>("An unexpected exception has occured "+ ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
