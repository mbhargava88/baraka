/**
 * 
 */
package com.baraka.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author MBhargava
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class ErrorResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1663025826958858827L;
	
	private HttpStatus status;
	private Map<String, String> missingFields;
	private String error;
	private String message;
	private String path;

	public ErrorResponseDto(HttpStatus status, String error, String message, String path) {
		this.status = status;
		this.error = error;
		this.message = message;
		this.path =path;
	}

}
