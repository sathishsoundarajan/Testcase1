package com.niit.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.testcase.DAO.UserDAO;
import com.niit.testcase.model.User;

public class UserTestcase {

	@Autowired static AnnotationConfigApplicationContext context;		//ACAC is used to configure Db using Annotations
	
	@Autowired static UserDAO userDAO;
	
	@Autowired static User user;
	
	//initialize the above methods
	
	@BeforeClass
	
	public static void initialize(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get UserDAO from context
		userDAO=(UserDAO) context.getBean("userDAO");
		
		//get user from context
		user=(User) context.getBean("user");
		}
	
	//TestCAses
	
	@Test
	public void createUserTestcase(){
		user.setId("S2004");
		user.setName("Mithra");
		user.setPassword("mithra");
		user.setContact(90657843);
		user.setRole("ROLE_USER");
		boolean flag=userDAO.save(user);
		assertEquals("createUserTestCase",true,flag);
		
	}
	
	/*@Test
	public void updateUserTestCase(){
		user.setId("S1001");
		user.setName("Meera");
		user.setPassword("Meena");
		user.setContact(88765);
		boolean flag=userDAO.update(user);
		assertEquals("createUserTestCase",true,flag);
		}*/
	
	/*@Test
	public void validateUserTestCase(){
		boolean flag=userDAO.validate("Meena","Meena");
		assertEquals(true,flag);
	}*/
	
	/*@Test
	public void getAllUserTestCase(){
		int actualSize=userDAO.list().size();
		assertEquals(3,actualSize);
	}*/
}