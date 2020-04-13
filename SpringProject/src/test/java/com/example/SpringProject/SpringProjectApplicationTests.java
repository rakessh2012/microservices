package com.example.SpringProject;

import org.junit.Test;
import org.junit.jupiter.api.Nested;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.SpringProject.controller.AccountController;
import com.example.SpringProject.controller.UserController;
import com.example.SpringProject.model.AccountModel;
import com.example.SpringProject.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc 
@Nested
public class SpringProjectApplicationTests 
{

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@InjectMocks
	UserController user;
	AccountController account;
	
	
	@Test
	public void createUserTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/api/userss/createUser").contentType(MediaType.APPLICATION_JSON).content("{\n" + " \"id\":2000,\n" + " \"createdBy\": \"1\",\n" + " \"email\": \"rakesh@gmail.com\",\n" + " \"firstName\": \"Nivas\",\n" + " \"lastModifiedBy\": \"1\",\n" + " \"lastName\": \"Baskaran\",\n" + " \"status\": \"active\",\n" + " \"username\": \"firstman\"\n" + " \n" + "}") .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void createAccountTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/createAccount").contentType(MediaType.APPLICATION_JSON).content("{\n" + " \"id\":2000,\n" + " \"createdBy\": \"1\",\n" + " \"createdDate\": \"01-01-2020\",\n" +  " \"owner\": \"12\",\n" + " \"lastModifiedBy\": \"1\",\n" + " \"lastModifiedDate\": \"10-01-2020\",\n" +" \n" + "}") .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
    public void findUser() throws Exception 
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/userss/getUserById/1"))
         .andExpect(MockMvcResultMatchers.status().isOk());            
    }
	@Test
    public void findAccount() throws Exception 
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/getAccount/1"))
         .andExpect(MockMvcResultMatchers.status().isOk());               
    }
	@Test
	public void deleteAccount() throws Exception 
	{     
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteAccount/1"))
		 .andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void deleteUser() throws Exception 
	{     
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteUser/1"))
	     .andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void updateAccount() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.put("/updateAccount/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" \"firstName\": \"Firstname\",\n" ).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void updateUser() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.put("/updateUser/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" \"accountName\": \"Firstaccount\",\n" ).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}

