package com.project.qa.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.qa.domain.User;
import com.project.qa.dto.LoginDto;
import com.project.qa.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Inject
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(@ModelAttribute("dto") LoginDto dto) {
		
	}

	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPost(LoginDto dto, HttpSession session, Model model) throws Exception{
		User user = service.login(dto);
		System.out.println(service.toString());
		if(user == null) {
			return;
		}
		model.addAttribute("user", user);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("login");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public void mypage() throws Exception{
		
	}
}
