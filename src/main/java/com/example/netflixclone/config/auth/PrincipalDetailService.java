package com.example.netflixclone.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.netflixclone.model.User;
import com.example.netflixclone.repository.UserRepository;

@Service // Bean 등록
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	// 스프링이 로그인 요청을 가로챌 때, email, password 변수 2개를 가로채는데
	// password 부분 처리는 알아서 함
	// email이 DB에 있는지만 확인해주기만 하면 됨
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User principal = userRepository.findByEmail(email)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.:"+email);
				});
			return new PrincipalDetail(principal); // 시큐리티의 세션에 유저 정보가 저장 됨
	}
	
	
}
