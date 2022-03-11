package com.example.netflixclone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.netflixclone.model.User;

// DAO
// @Repository 생략 가능 => 자동으로 bean등록이 됨
public interface UserRepository extends JpaRepository<User, Integer> {
	// SELECT * FROM user WHERE username=첫번째 파라미터(username);
	
	Optional<User> findByUsername(String username);
	
}
