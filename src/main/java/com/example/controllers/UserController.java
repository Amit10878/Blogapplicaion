package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.example.binding.LoginForm;
import com.example.binding.SignUpForm;
import com.example.binding.UnlockForm;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/SignUp")
	public String SignUpPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return "SignUp";
	}
	
	
	@PostMapping("/SignUp")
	public String HandleSignUp(@ModelAttribute("user")SignUpForm form, Model model) {
		
		boolean status = userService.SignUp(form);
		
		if(status) {
			model.addAttribute("succMsg", "Account Created, Check Your Email");
		}else {
			model.addAttribute("errMsg", "Choose Unique Email");
		}
		return "SignUp";
		
	}
	
	@GetMapping("/Unlock")
	public String UnlockPage(@RequestParam String email, Model model) {
		
		UnlockForm unlockFormObj = new UnlockForm();
		unlockFormObj.setEmail(email);
		
		model.addAttribute("Unlock", unlockFormObj);
		
		return "Unlock";
	}
	
	@PostMapping("/Unlock")
	public String UnlockUserAccount(@ModelAttribute("Unlock") UnlockForm unlock, Model model) {
		
		//System.out.println(unlock);
		
		if(unlock.getNewPwd().equals(unlock.getConfirmPwd())) {
			boolean status = userService.UnlockAccount(unlock);
			
			if(status) {
				model.addAttribute("succMsg", "Your account unlocked successfully");
			}else {
				model.addAttribute("errorMsg", "Given temporary password is incorrect, check your email"); 
			}
			
		}else {
			model.addAttribute("errorMsg","New Pwd and Confirm Pwd should be same");
		}
		return "Unlock";
	}
	
	
	
	
	@GetMapping("/Login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());	
		return "Login";
	}
	
	
	@PostMapping("/Login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
	   String status = userService.Login(loginForm);
	  if(status.contains("success")) {
			return "redirect:/Dashboard";
	}
		
		model.addAttribute("errMsg", status);
		
		return "Login";
		
		
		
	}
	

	
		
		
	
	
	@GetMapping("/Forgot")
	public String ForgotPwdPage() {
		return "ForgotPwd";
	}

	
	@PostMapping("/ForgotPwd")
	public String ForgotPwd(@RequestParam("email") String email, Model model) {
		
		System.out.println(email);
		
		//TODO: Logic
		boolean status = userService.ForgotPwd(email); 
		
		if(status) {
			//send success msg
			model.addAttribute("succMsg", "Pwd sent to your email");
		}else {
			//send error msg
			model.addAttribute("errMsg", "Invalid Email");
		}
		
		
		return "ForgotPwd";
	}
	
	

	
	
}
