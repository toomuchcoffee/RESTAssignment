package de.smava.assignment;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.smava.assignment.entities.User;
import de.smava.assignment.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<User> users = service.getAllUsers();

		model.addAttribute("users", users);

		return "users";
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public String byUser(@PathVariable("userId") String userId, Locale locale, Model model) {

		Integer userIdInt = Integer.valueOf(userId);

		User user = service.getUserForId(userIdInt);

		model.addAttribute("user", user);

		return "user";
	}

	@RequestMapping(value = "users", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User post(@RequestBody final User user) {
		service.addUser(user);
		
		return user;
	}

	@RequestMapping(value = "users/{userId}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User update(@PathVariable String userId, @RequestBody final User user) {
		Integer userIdInt = Integer.valueOf(userId);
		
		service.updateUser(userIdInt, user);
		
		return user;
	}

}
