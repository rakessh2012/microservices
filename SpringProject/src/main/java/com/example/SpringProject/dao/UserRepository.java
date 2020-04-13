package com.example.SpringProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringProject.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>
{
	List<UserModel> findAllById(Integer id);

	List<UserModel> findAllByEmail(String email);
}