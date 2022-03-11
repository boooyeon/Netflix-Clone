package com.example.netflixclone.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.netflixclone.config.auth.PrincipalDetail;


@Controller
public class HomeController {
	
	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤러에서 세션을 어떻게 찾지? 의문 생김	
		if (principal != null) {
			System.out.println("타입정보 : " + principal.getUsername());	
		}
		return "index";
	}
}
