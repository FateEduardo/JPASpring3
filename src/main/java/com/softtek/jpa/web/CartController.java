package com.softtek.jpa.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.jpa.domain.Cart;
import com.softtek.jpa.domain.ShipTo;
import com.softtek.jpa.domain.Status;
import com.softtek.jpa.domain.User;
import com.softtek.jpa.domain.UserRole;
import com.softtek.jpa.services.CartService;
import com.softtek.jpa.services.ShipToService;
import com.softtek.jpa.services.StatusService;


@RequestMapping(value="/Cart")
@Controller
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

/*	@Autowired
	CartService cartSerciveImpl;*/
	
	 @Autowired
	 CartService cartService;
	 
	 @Autowired
	 StatusService statusService;;
	 
	 @Autowired
	 ShipToService shipToService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String root() {
		return "home";
	}
	 @RequestMapping(value="/ListView", method = RequestMethod.GET)
	public String listView( ) {
		return "ListCart";	
	 }
	 
	 @RequestMapping(value="/List", method = RequestMethod.GET)
	 public ResponseEntity<?> List( ) {
		 List<Cart> carts = cartService.cartList();
		 if(carts.isEmpty()){
			 return new ResponseEntity<List<Cart>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		 }
		 return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
	 }

	 @RequestMapping(value="/editView", method = RequestMethod.GET)
	 public String editView( ) {
		 return "EditCart";
	 }
	 
	 @RequestMapping(value="/edit",method = RequestMethod.POST)
	 public ResponseEntity<?> editUser(@RequestBody  Long cartId) {
		 Cart cart = cartService.cart(cartId);
		 List<Status> cartStatus = statusService.statusList("CART");
		 List<ShipTo> shipTos = shipToService.shipToList();
		 Map<String,Object>map=new HashMap<String, Object>();
		 map.put("cart", cart);
		 map.put("cartStatus", cartStatus);
		 map.put("shipTos", shipTos);
		 if(cartStatus.isEmpty() && shipTos.isEmpty() && cart!=null ){
			 return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		 }
		 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/update" ,method=RequestMethod.POST)
	 public String updateUser(@RequestBody Cart cart) {
		 
		 if( cartService.update(cart)){
		
			 return "redirect:/User/ListView";
		 }
		 return "redirect:/User/editView";
	 }
	 @RequestMapping(value="/addView", method = RequestMethod.GET)
	 public String add( ) {
		 return "NewCart";
	 }
	 @RequestMapping(value = "/data", method = RequestMethod.GET)
		public ResponseEntity<?> dataUser() {
		 List<Status> cartStatus = statusService.statusList("CART");
		 List<ShipTo> shipTos = shipToService.shipToList();
		 Map<String,Object>map=new HashMap<String, Object>();
		 map.put("cartStatus", cartStatus);
		 map.put("shipTos", shipTos);
		 if(cartStatus.isEmpty() && shipTos.isEmpty() ){
			 return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		 }
		 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		}
	 
	 
	 
	 @RequestMapping(value="/add" ,method=RequestMethod.POST)
	 public String addUser(@RequestBody Cart cart ) {
		 if( cartService.newCart(cart)){
			 return "redirect:/User/ListView";
		 }
		 return "redirect:/User/addView";
	 }
	 
	 @RequestMapping(value="/delete" ,method=RequestMethod.POST)
	 public String delete(@RequestBody Long id ) {
		 Cart cart = cartService.cart(id);
		 if( cartService.deleteCart(cart)){
			 return "redirect:/User/ListView";
		 }
		 return "redirect:/User/addView";
	 }
	 
}
