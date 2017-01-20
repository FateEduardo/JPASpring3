package com.softtek.jpa.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.softtek.jpa.domain.User;
import com.softtek.jpa.web.UserController;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Mock
	UserRolService userRoleService;
	
	
	 

	@Before
	public void setup(){
		  MockitoAnnotations.initMocks(this);
	        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	
	@Test
	public void testUserControllerListViewStatusEqual200() throws Exception {
		int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/User/ListView", "")).andReturn().getResponse().getStatus();
		Assert.assertTrue(status==200);
	}
	
	@Test
	public void testUserControllerEditViewStatusEqual200() throws Exception {
		int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/User/editView", "")).andReturn().getResponse().getStatus();
		Assert.assertTrue(status==200);
	}
	
	@Test
	public void testUserControlleraddNewStatusEqual200() throws Exception {
		int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/User/addView", "")).andReturn().getResponse().getStatus();
		Assert.assertTrue(status==200);
	}
	
	@Test
	public void testUserControllerListNoContent() throws Exception {
		int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/User/List","")).andReturn().getResponse().getStatus();
		Assert.assertTrue(status==204);
	}
	
	@Test
	public void testUserControllerListStatusEqual200() throws Exception {
		List<User>users=new ArrayList<User>();
		User user=new User("userName", "password", "name", "Role", "S", "description");
		users.add(user);
		when(userService.userList()).thenReturn(users);
		int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/User/List","")).andReturn().getResponse().getStatus();
		Assert.assertTrue(status==200);
	}
	
	@Test
	public void testUserControllerEditStatusEqual204() throws Exception{
		int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/User/edit","popo")).andReturn().getResponse().getStatus();
		System.out.println(status);
		Assert.assertTrue(status==204);
	}
	
	

}
