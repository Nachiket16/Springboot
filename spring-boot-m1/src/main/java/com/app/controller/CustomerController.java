package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.ITopicDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//dep : Topic dao i/f (since service layer is skipped!!!!!!!!!!!!!)
	@Autowired
	private ITopicDao topicDao;
	 
	public CustomerController() {
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method to forward the clnt to topics page.
	@GetMapping("/topics")
	public String showTopics(Model map)
	{
		System.out.println("in show topics "+map);
		//add model attri : topic list
		map.addAttribute("topic_list", topicDao.getAllTopics());
		return "/customer/topics";//D.S --> V.R ---> AVN : /WEB-INF/view/customer/topics.jsp
	}

}
