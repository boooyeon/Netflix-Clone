package com.example.netflixclone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.netflixclone.dao.UserRepository;
import com.example.netflixclone.entity.User;

@RestController
public class UserController {
	private UserRepository repository;

	// 스프링부트가 UserController를 만들때 repository된 객체를 만들어서 파라미터로 넘겨
	public UserController(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	// Insert(입력하기)
	//http://localhost:8080/user
	@PutMapping("/user")
	public User putUser(User user) {
		return repository.save(user);
	}
	
	// Update(수정하기)
	//http://localhost:8080/user (post)
	@PostMapping("/user")
	public User postUser(User user) {
		return repository.save(user);
	}
	
	// Delete(삭제하기)
	//http://localhost:8080/user (delete)
	@DeleteMapping("/user")
	public void deleteUser(int id) {
		repository.deleteById(id);
	}
	
	// Select(id로 user 찾기)
	//http://localhost:8080/user (get)
	@GetMapping("/user")
	public User getUser(int id) {
		return repository.findById(id).orElse(null);
	}
	

	
	// Select(전체 찾기)
	// http://localhost:8080/user/list (get)
	@GetMapping("/user/list")
	public List<User> getUser() {
		return (List<User>) repository.findAll();
	}
	
//	// Select(username으로 user 찾기)
//	//http://localhost:8080/user/username (get)
//	@GetMapping("/user/username")
//	public List<User> getUser(String username) {
//		return repository.findByName(username);
//	}
//	
//	// Select(검색 하기)
//	//http://localhost:8080/user/search (get)
//	@GetMapping("/user/search")
//	public List<User> searchUser(String username) {
//		return repository.findByNameLike("%" + username + "%");
//	}
	
}
