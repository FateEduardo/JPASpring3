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

import com.softtek.jpa.domain.Cart;
import com.softtek.jpa.domain.User;
import com.softtek.jpa.web.CartController;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class CartControllerTest {

	
	private MockMvc mockMvc;

	@InjectMocks
	CartController cartController;
	
	 @Mock
	 CartService cartService;
	 
	 @Mock
	 StatusService statusService;;
	 
	 @Mock
	 ShipToService shipToService;

	 @Before
	 public void setup(){
		 MockitoAnnotations.initMocks(this);
		 this.mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
	 }


	 @Test
	 public void testUserControllerListViewStatusEqualTwoHundred() throws Exception {
		 int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/Cart/ListView", "")).andReturn().getResponse().getStatus();
		 Assert.assertTrue(status==200);
	 }

	 @Test
	 public void testUserControllerEditViewStatusEqualTwoHundred() throws Exception {
		 int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/Cart/editView", "")).andReturn().getResponse().getStatus();
		 Assert.assertTrue(status==200);
	 }

	 @Test
	 public void testUserControlleraddNewStatusEqualTwoHundred() throws Exception {
		 int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/Cart/addView", "")).andReturn().getResponse().getStatus();
		 Assert.assertTrue(status==200);
	 }
	 
	 @Test
	 public void testCartControllerListNoContent() throws Exception {
		 int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/Cart/List","")).andReturn().getResponse().getStatus();
		 Assert.assertTrue(status==204);
	 }
	 
	 @Test
	 public void testUserControllerListStatusEqual200() throws Exception {
		 List<Cart>cart=new ArrayList<Cart>();
		 Cart carts=new Cart(1l,1.0,1.0,1.0,1l,1l);
		 cart.add(carts);
		 when(cartService.cartList()).thenReturn(cart);
		 int status= this.mockMvc.perform(MockMvcRequestBuilders.get("/Cart/List","")).andReturn().getResponse().getStatus();
		 Assert.assertTrue(status==200);
	 }


}
