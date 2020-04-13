package com.example.SpringProject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringProject.dao.AccountRepository;
import com.example.SpringProject.model.AccountModel;

@RestController
public class AccountController {
	
	
	@Autowired
	private AccountRepository repository;
	
	@PostMapping("/createAccount")
	public AccountModel createAccount(@RequestBody AccountModel account){
		return repository.save(account);
	}
	
	@GetMapping("/getAccount/{id}")
	public List<AccountModel> getAccount(@PathVariable Integer id){
		return repository.findAllById(id);
	}
	
	@PutMapping("/updateAccount/{id}")
	public String updateAccount(@RequestBody AccountModel account,@PathVariable Integer id){
	        repository.save(account);
	        return "Account Updated Successfully";  	
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable Integer id){
		repository.deleteById(id);
		return "Account Deleted Successfully";
	}	

}