package com.softtek.jpa.web;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softtek.jpa.domain.User;
import com.softtek.jpa.domain.UserRole;
import com.softtek.jpa.services.UserRolService;
import com.softtek.jpa.services.UserService;



/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="/User")
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRolService userRoleService;
	
	/*@Autowired
	UserRolService userRoleImpl;*/
	


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String root() {
		return "home";
	}
	@RequestMapping(value="/ListView", method = RequestMethod.GET)
	public String listView( ) {
		return "ListUser";
	}

	@RequestMapping(value="/List", method = RequestMethod.GET)
	public ResponseEntity<?>  list( ) {
		List<User> users = userService.userList();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editView", method = RequestMethod.GET)
	public String editView( ) {
		return "EditUser";
	}
	

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ResponseEntity<?> editUser(@RequestBody  String username) {
		
		User user = userService.user(username);
		List<UserRole> userRoleList = userRoleService.userRoleList();
		List<String> listStatus = userRoleService.statusList();
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("users", user);
		map.put("userRole", userRoleList);
		map.put("listStatus", listStatus);
		if(userRoleList.isEmpty() && listStatus.isEmpty() && user!=null ){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
	}

	 
	 
	 @RequestMapping(value="/update" ,method=RequestMethod.POST)
	 public String updateUser(@RequestBody User user) {
		 
		 if( userService.update(user)){
		
			 return "redirect:/User/ListView";
		 }
		 return "redirect:/User/editView";

	 }
	 
	 @RequestMapping(value="/addView", method = RequestMethod.GET)
	 public String add( ) {
		 return "NewUser";
	 }
	 
	 @RequestMapping(value = "/data", method = RequestMethod.GET)
		public ResponseEntity<?> dataUser() {
			List<UserRole> userRoleList = userRoleService.userRoleList();
			List<String> listStatus = userRoleService.statusList();
			Map<String,Object>map=new HashMap<String, Object>();
			map.put("userRole", userRoleList);
			map.put("listStatus", listStatus);
			if(userRoleList.isEmpty() && listStatus.isEmpty()  ){
				return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		}
	 
	 @RequestMapping(value="/add" ,method=RequestMethod.POST)
	 public String addUser(@RequestBody User user ) {
		 if( userService.newUser(user)){
			 return "redirect:/User/ListView";
		 }
		 return "redirect:/User/addView";
	 }
	 
	 @RequestMapping(value="/delete" ,method=RequestMethod.POST)
	 public String delete(@RequestBody String username ) {
		 User user = userService.user(username);
		 if( userService.deleteUser(user)){
			 return "redirect:/User/ListView";
		 }
		 return "redirect:/User/addView";
	 }
}
