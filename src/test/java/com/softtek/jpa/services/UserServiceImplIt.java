package com.softtek.jpa.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.softtek.jpa.domain.User;
import com.softtek.jpa.domain.UserRole;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value={"/dataset/default.xml"}, type=DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UserServiceImplIt {

	@Autowired
	private UserService userService;
	
	@Test
	@DatabaseSetup(value="/dataset/scenario1.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testUserServiceSizeThree(){
		List<User> users = userService.userList();

		Assert.assertTrue(users.size()==3);
	}

	@Test
	@DatabaseSetup(value="/dataset/scenario1.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testUserServiceFindOneUserByUserNameAdmin(){
		User user=userService.user("admin");
		Assert.assertTrue(user.getUsername().equals("admin"));
	}
	
	@Test
	@ExpectedDatabase("/dataset/scenario2.xml")
	public void testUserServiceUpdateOneByName(){
		User user=userService.user("admin");
		user.setName("admin");
		userService.update(user);
		List<User>users=userService.userList();
		System.out.println("Test:"+users);
	}
	
	
	@Test
	@ExpectedDatabase("/dataset/scenario3.xml")
	public void testUserServiceDeleteByUserNameAdmin(){
		User user=userService.user("admin");
		userService.deleteUser(user);
	}
	
	@Test
	@ExpectedDatabase("/dataset/scenario4.xml")
	public void testUserServiceAddNewUser(){
		String username="asuna";
		String status="S";
		String password="asuna";
		String name="asuna";
		UserRole userRoleId=new UserRole();
		userRoleId.setUser_roleid("ADM");
		userRoleId.setDescription("Admin");
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setUsername(username);
		user.setRole(userRoleId);
		user.setStatus(status);
		userService.newUser(user);
	
	
	}
	
	@Test
	@DatabaseSetup(value="/dataset/scenario1.xml", type=DatabaseOperation.CLEAN_INSERT)
	public void testUserSerficeFindOneByUserNameAdmin(){
		User user=userService.user("admin");

		Assert.assertTrue(user.getName().equals("raul"));
	}
	
	
	
	
}
