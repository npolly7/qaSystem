package com.project.qa.controller;

import java.net.URLDecoder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.qa.domain.PageMaker;
import com.project.qa.domain.SearchCriteria;
import com.project.qa.domain.User;
import com.project.qa.dto.LoginDto;
import com.project.qa.service.ProjectService;
import com.project.qa.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@Inject
	private ProjectService projectService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(@ModelAttribute("dto") LoginDto dto) {
		
	}

	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPost(LoginDto dto, HttpSession session, Model model) throws Exception{
		User user = userService.login(dto);
		System.out.println(userService.toString());
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
	public void mypage(@ModelAttribute("criteria") SearchCriteria criteria, @ModelAttribute("keyword") String keyword, HttpServletRequest request, Model model) throws Exception{
		logger.info("Show Following Projects.....");
		
		String key = URLDecoder.decode(keyword,"UTF-8");
		
		HttpSession session = request.getSession();
		String tmpAttrPrj = "";
		User sessionUser = (User)session.getAttribute("login");
		
		if(sessionUser !=null) {
			User user = userService.read(sessionUser.getUSER_CODE());
			tmpAttrPrj = user.getATTR_PRJ();
		}

		String attrPrjArr[] = {};
		if( (tmpAttrPrj != null) && (!tmpAttrPrj.equals("")) ) { 
			attrPrjArr = tmpAttrPrj.split(",");
		}
		
		criteria.setKeyword(key);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(projectService.listSearchCountForMyPage(criteria, sessionUser.getUSER_CODE()));
	
		model.addAttribute("list", projectService.ListSearchCriteriaForMyPage(criteria, sessionUser.getUSER_CODE()));
		model.addAttribute("attrPrjArr", attrPrjArr);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("keyword", key);
		
	}
}
