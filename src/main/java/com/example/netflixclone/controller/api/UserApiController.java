package com.example.netflixclone.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.netflixclone.dto.ResponseDto;
import com.example.netflixclone.model.User;
import com.example.netflixclone.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	 public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController: save 호출");
		
        userService.joinUser(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
	
}
