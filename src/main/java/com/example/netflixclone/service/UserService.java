package com.example.netflixclone.service;

import com.example.netflixclone.model.RoleType;
import com.example.netflixclone.model.User;
import com.example.netflixclone.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 함(IoC를 해줌)
// Service의 의미: 
// Service가 필요한 이유 1: 트랜잭션 관리
@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired // DI가 되서 주입이 됨
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public int joinUser(User user){
		String rawPassword = user.getPassword(); // 원 비밀번호
		String encPassword = encoder.encode(rawPassword); // 해쉬 비밀번호
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

}
