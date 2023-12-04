package com.example.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.binding.CreateblogForm;
import com.example.binding.ViewblogForm;
import com.example.entity.CommentEntity;
import com.example.entity.PostEntity;
import com.example.service.CreateblogService;

@Controller
public class CreateblogController {
	
	@Autowired
	private CreateblogService createService;
	

	
	
	
	
	
	
	@GetMapping("/Createblog")
	public String addCreateblogPage(Model model) {
		initForm(model);
		
		return "Createblog";
	}
	
	@PostMapping("/Createblog")
	public String Createblog(@ModelAttribute("formObj") CreateblogForm formObj, Model model)
	{
		System.out.println(formObj);
		
		boolean status = createService.saveCreateblog(formObj);
		
		if(status) {
			model.addAttribute("succMsg", "Createblog Added");
			
		}else
		{
			model.addAttribute("errMsg", "Problem Occured");
		}
		
		return "Createblog";
	}

	
	
	
	@GetMapping("/Dashboard")
	public String DashboardPage(Model model) {
		initForm(model);
	    List<PostEntity> dashboard = createService.getDashboard();
		model.addAttribute("dashboard", dashboard);
		return "Dashboard";
	}
	
	
	@GetMapping("/Viewblog")
	public String ViewblogPage(Model model) {
		initForm(model);
		
		return "Viewblog";
	}
	
	private void initForm(Model model) {
		// TODO Auto-generated method stub
		
	}

	@PostMapping("/Viewblog")
	public String Viewblog(@ModelAttribute("formObj") ViewblogForm formObj, Model model)
	{
		System.out.println(formObj);
		
		boolean status = createService.saveViewblog(formObj);
		
		if(status) {
			model.addAttribute("succMsg", "Comment Added");
			
		}else
		{
			model.addAttribute("errMsg", "Problem Occured");
		}
		
		return "Viewblog";
	}

	
	@GetMapping("/Viewcomment")
	public String ViewcommentPage(Model model) {
		initForm(model);
	    List<CommentEntity> viewcomment = createService.getViewcomment();
		model.addAttribute("viewcomment", viewcomment);
		return "Viewcomment";
	}
	
	
	
	
	
}
