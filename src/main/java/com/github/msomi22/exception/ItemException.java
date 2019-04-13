/**
 * 
 */
package com.github.msomi22.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author t_pnjeru
 *
 */
public class ItemException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(value=ItemException.class)
	public ResponseEntity<Object> exception(ItemException exception){
		return new ResponseEntity<>("Item not found ", HttpStatus.NOT_FOUND); 
	}
	
}
