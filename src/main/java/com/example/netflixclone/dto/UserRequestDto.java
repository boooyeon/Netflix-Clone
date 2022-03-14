package com.example.netflixclone.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.netflixclone.model.RoleType;
import com.example.netflixclone.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
	private int id;
	
	@NotBlank(message = "닉네임은 필수 입력 값입니다.")
	@Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
	private String username;
	
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.") 
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String password;
	
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
	@NotBlank(message = "이메일은 필수 입력 값입니다.")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	public User toEntity() {
		return User.builder()
				.id(id)
				.username(username)
				.password(password)
				.email(email)
				.role(role)
				.build();
	}
	@Builder
	public UserRequestDto(String username, String password, String email, RoleType role) {
		this.username=username;
		this.password=password;
		this.email=email;
		this.role=role;
	}
	
}
