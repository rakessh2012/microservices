package com.example.SpringProject.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringProject.dao.UserRepository;
import com.example.SpringProject.model.UserModel;

@RestController
@RequestMapping(value="/api/userss")
public class UserController {
	
	@Autowired
	private UserRepository repouser;
	
	@PostMapping("/createUser")
	public UserModel createUser(@RequestBody UserModel user){
		return repouser.save(user);
	}
	
	@GetMapping("/getUserById/{id}")
	public List<UserModel> getUserById(@PathVariable Integer id){
		return repouser.findAllById(id);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public List<UserModel> getUserByEmail(@PathVariable String email){
		return repouser.findAllByEmail(email);
	}
	
	@PutMapping("/updateUser/{id}")
	public String updateUser(@RequestBody UserModel user,@PathVariable Integer id){
        repouser.save(user);
        return "User Updated Successfully"; 
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id){
		repouser.deleteById(id);
		return "User Deleted Successfully";
	}
}