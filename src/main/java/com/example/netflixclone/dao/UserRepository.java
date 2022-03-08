package com.example.netflixclone.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.netflixclone.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
//	List<User> findByName(String username);
//	List<User> findByNameLike(String username);
	
}
