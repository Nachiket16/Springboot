package com.app.controller;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.RoleEnum;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency : service layer i/f
	@Autowired // (required=true)
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass() + " " + userService);// null
	}

//	@PostConstruct
	public void init() {
		System.out.println("in init " + userService);// not null
	}

	// add req handling method to show the login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		// will u have any results to send to D.S ? NO
		return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
	}

	// add a new method : processing login form
	@PostMapping("/login") // =@RequestMapping : method=POST
	// @RequestParam : method arg level annotation => binding between req param n
	// req handling method arg name
	// String em=request.getParamter("em"); String
	// password=request.getParamter("pass");
	public String processLoginForm(@RequestParam String em, 
			@RequestParam(name = "pass") String password,Model map) {
		System.out.println("in process login form " + em + " " + password);// actual em n password values
		// for authentication : DB based : simply call service layer method
		try {
			User user = userService.authenticateUser(em, password);
			//store validated user details under model map
			map.addAttribute("user_details", user);
			//=> valid login (authentication success) --> proceed to authorization
			if(user.getRole() == RoleEnum.ADMIN) //admin user :redirect  admin in the NEXT request : to admin.jsp
				return "redirect:/admin/display";
			if(user.getRole() == RoleEnum.AUTHOR) 
				return "redirect:/author/display";		
				//=>customer logged in --> redirect customer to topics in the NEXT request (P-R-G)
			return "redirect:/customer/topics";
			//Handler rets redirect view name to D.S --> D.S skips the V.R --> 
			//response.sendRedirect(response.encodeRedirectURL("/customer/topics")); --> temp redirect resp
			//SC 302 | Location =/day17_boot/customer/topics cookie : JSESSIONID :57536hgfhdgj | Body : EMPTY
			//clnt browser sends a NEW request , method=GET , URL : http://host:port/day17/boot/customer/topics
		} catch (RuntimeException e) {
			System.out.println("err in " + getClass() + " err " + e);
			//=> invalid login ---> forward the clnt to the login form
			map.addAttribute("mesg", "Invalid Login , Pls retry !!!!!!!!!!!!");
			return "/user/login";//Handler(RHC --> LVN --> D.S) : AVN : /WEB-INF/views/user/login.jsp
		}		
	}
}
