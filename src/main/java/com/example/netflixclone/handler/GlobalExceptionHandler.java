package com.example.netflixclone.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.netflixclone.dto.ResponseDto;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	//IllegalArgumentException이 발생하면 처리해주는 함
		//만약 모든 exception에 대해서 처리하고 싶으면 value=Exception.class로 변
		@ExceptionHandler(value=Exception.class)
		public ResponseDto<String> handlArgumentException(Exception e) {
			return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
		}
}
