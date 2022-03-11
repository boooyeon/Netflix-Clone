package com.example.netflixclone.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.netflixclone.dto.ResponseDto;
import com.example.netflixclone.dto.UserRequestDto;
import com.example.netflixclone.model.User;
import com.example.netflixclone.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user){ //username, password, email를 받음
		System.out.println("UserApiController: save 호출");
		// 실제로 DB에 insert를 하고 아래에서 return
		userService.joinUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
}