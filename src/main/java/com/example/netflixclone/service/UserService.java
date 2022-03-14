package com.example.netflixclone.service;

import com.example.netflixclone.dto.UserRequestDto;
import com.example.netflixclone.model.RoleType;
import com.example.netflixclone.model.User;
import com.example.netflixclone.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import lombok.RequiredArgsConstructor;


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 함(IoC를 해줌)
// Service의 의미: 
// Service가 필요한 이유 1: 트랜잭션 관리
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired // DI가 되서 주입이 됨
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public int joinUser(UserRequestDto userDto){
		User user = userDto.toEntity();
		String rawPassword = userDto.getPassword(); // 원 비밀번호
		String encPassword = encoder.encode(rawPassword); // 해쉬 비밀번호
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		System.out.println(user);
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	
	// 회원가입시, 유효성 체크
	@Transactional(readOnly = true)
	public Map<String, String> validateHandling(Errors errors) {
			 Map<String, String> validatorResult = new HashMap<>();
			 
			 //유효성 검사에 실패한 필드 목록을 받음
			 for (FieldError error : errors.getFieldErrors()) {
				 String validKeyName = String.format("valid_%s", error.getField());
				 validatorResult.put(validKeyName, error.getDefaultMessage());
			 }
			 System.out.println(validatorResult.values());
			 return validatorResult; 
	}
	
}
