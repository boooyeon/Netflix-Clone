package com.example.netflixclone.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.netflixclone.dto.ResponseDto;
import com.example.netflixclone.dto.UserRequestDto;
import com.example.netflixclone.service.UserService;

// 인증이 안 된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
@Controller
public class UserController {
	
	//회원가입 페이지
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	//로그인 페이지
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@Autowired
	private UserService userService;
	
	//회원가입 유효성 검사
	@PostMapping("/auth/joinProc")
	public String joinProc(@RequestBody @Valid UserRequestDto userDto, Errors errors, Model model){ //username, password, email를 받음
		if (errors.hasErrors()) {
			//회원가입 실패 시 입력 데이터 값을 유지
			model.addAttribute("userDto", userDto);
			
			//유효성 통과 못한 필드와 메시지를 핸들링
			Map<String, String> validatorResult = userService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
		}
			//회원가입 페이지로 다시 리턴
			return "user/joinForm";
			
		}
		userService.joinUser(userDto);
		return "redirect:/";
	}
	
}
