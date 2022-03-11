package com.example.netflixclone.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.netflixclone.model.User;

import lombok.Data;
import lombok.Getter;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 장소에 저장을 해줌 그때 저장되는 것이 UserDetails의 PrincipalDetail
@Data
@Getter

public class PrincipalDetail implements UserDetails {
	
	private User user; // 객체를 품고 있는 것을 콤포지션이라고 함
	
	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	// 계정이 만료되지 않았는지 리턴. (true: 만료 안됨 / false: 만료 됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	// 계정이 잠겨있는지 안잠겨있는지 리턴. (true: 잠겨 있지 않음 / false: 잠김)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는지 리턴. (true: 만료 안됨 / false: 만료 됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용 가능)인지 리턴. (true: 활성화 / false: 비활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	

	// 계정의 권환을 리턴(이 계정이 어떤 권한을 가졌는지)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		// 람다식 방법
		collectors.add(()->{return "ROLE_"+user.getRole();});
		// 정석 방법
//		collectors.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				return "ROLE_"+user.getRole(); // ROLE_user
//			}
//		});
		return collectors;
	

	}
	
		
	
}

