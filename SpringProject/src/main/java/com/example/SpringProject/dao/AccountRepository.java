package com.example.SpringProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringProject.model.AccountModel;



public interface AccountRepository extends JpaRepository<AccountModel, Integer>{



	List<AccountModel> findAllById(Integer id);

	

	

}
