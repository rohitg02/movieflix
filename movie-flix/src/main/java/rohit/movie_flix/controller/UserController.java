package rohit.movie_flix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rohit.movie_flix.entity.User;
import rohit.movie_flix.service.UserService;

@RestController
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//Find user profile
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findUser(@PathVariable("id") String userId){
		return userservice.findUser(userId);
	}
	
	//Login user page
	@RequestMapping(method = RequestMethod.GET)
	public User loginUser(@RequestParam("userId") String userEmail, @RequestParam("Password") String password){
		 String id = userservice.userValidate(userEmail, password);
		 return userservice.findUser(id);
	}
	
	//Create (signUp) a new user
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User createUser(@RequestBody User user){
		return userservice.createUser(user);
	}
	
	//Update user's profile
	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser(@PathVariable("id") String userId, @RequestBody User user){
		return userservice.updateUser(userId, user);
	}
	
	//Deactivate user's profile
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteUser(@PathVariable("id") String userId){
		userservice.deleteUser(userId);
	}
}
