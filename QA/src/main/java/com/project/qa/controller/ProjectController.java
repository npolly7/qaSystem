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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.qa.domain.PageMaker;
import com.project.qa.domain.Project;
import com.project.qa.domain.SearchCriteria;
import com.project.qa.domain.User;
import com.project.qa.service.ProjectService;
import com.project.qa.service.TestCaseService;
import com.project.qa.service.UserService;

@Controller
@RequestMapping(value="/project")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Inject
	private ProjectService projectService;
	
	@Inject
	private TestCaseService testCaseService;
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("PRJ_CODE") int PRJ_CODE, @ModelAttribute("criteria") SearchCriteria criteria, Model model) throws Exception {
		model.addAttribute("project", projectService.read(PRJ_CODE));
		model.addAttribute("testCase", testCaseService.read(PRJ_CODE));
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGet(Project project, Model model) throws Exception{
		logger.info("register get....");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(Project project, RedirectAttributes rttr) throws Exception{
		
		logger.info("register post.......");
		logger.info(project.toString());
		projectService.regist(project);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(int PRJ_CODE, @ModelAttribute("criteria") SearchCriteria criteria, Model model) throws Exception{
		model.addAttribute("project",projectService.read(PRJ_CODE));
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(Project project, @ModelAttribute("criteria") SearchCriteria criteria, RedirectAttributes rttr) throws Exception{
	
		logger.info("modify project post..........");
		logger.info("PRJ_CODE:" + project.getPRJ_CODE());
		String tmpPrjCodeArr[] = project.getPRJ_CODE().split(","); 
		
		project.setPRJ_CODE(tmpPrjCodeArr[0]);
		projectService.modify(project);
		
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		rttr.addAttribute("searchType",criteria.getSearchType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/project/listAll";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("PRJ_CODE") int PRJ_CODE, @ModelAttribute("criteria") SearchCriteria criteria, RedirectAttributes rttr) throws Exception{
		
		logger.info("removing project.....");
		projectService.remove(PRJ_CODE);
		
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		rttr.addAttribute("searchType",criteria.getSearchType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/project/listAll";
	}
	
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String listPage(@ModelAttribute("criteria") SearchCriteria criteria, @ModelAttribute("keyword") String keyword, HttpServletRequest request, Model model) throws Exception{
		
		logger.info("show all project.....");
		
		String key = URLDecoder.decode(keyword,"UTF-8");
		
		criteria.setKeyword(key);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(projectService.listSearchCount(criteria));

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
		
		model.addAttribute("list", projectService.listSearchCriteria(criteria));
		model.addAttribute("attrPrjArr", attrPrjArr);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("keyword", key);
		
		return "main";
	}
}
