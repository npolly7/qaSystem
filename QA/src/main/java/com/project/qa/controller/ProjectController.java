package com.project.qa.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import com.project.qa.domain.TestCase;
import com.project.qa.service.ProjectService;
import com.project.qa.service.TestCaseService;

@Controller
@RequestMapping(value="/project")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Inject
	private ProjectService projectService;
	
	@Inject
	private TestCaseService testCaseService;
	
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
		
		projectService.remove(PRJ_CODE);
		
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		rttr.addAttribute("searchType",criteria.getSearchType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/project/listAll";
	}
	
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String listPage(@ModelAttribute("criteria") SearchCriteria criteria, Model model) throws Exception{
		
		logger.info("show all project.....");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(projectService.listSearchCount(criteria));
		
		model.addAttribute("list", projectService.listSearchCriteria(criteria));
		model.addAttribute("pageMaker", pageMaker);
		return "main";
	}
	

}
