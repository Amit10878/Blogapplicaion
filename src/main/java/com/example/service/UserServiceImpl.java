package com.example.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binding.LoginForm;
import com.example.binding.SignUpForm;
import com.example.binding.UnlockForm;
import com.example.entity.UserEntity;
import com.example.repo.UserRepo;
import com.example.util.EmailUtils;
import com.example.util.PwdUtils;

@Service
public class UserServiceImpl implements UserService {
	

    @Autowired
	private UserRepo UserRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private  HttpSession session;
	
	
	@Override
	public String Login(LoginForm form) {
		
	UserEntity entity = 
			UserRepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		
	  
	        if(entity == null) {
	        	return "Invalid Credentials";
	        }
	        
	        if(entity.getAccStatus().equals("LOCKED")) {
	             return "Your Account Locked";
	        }
	        
	        //create session and store user data in session
	        
	        session.setAttribute("userId", entity.getUserId());
	        
	        return "success";
	}

	
	
	@Override
	public boolean UnlockAccount(UnlockForm form) {
		
		 UserEntity entity = UserRepo.findByEmail(form.getEmail());
		
		 if(entity.getPwd().equals(form.getTempPwd())) {
			 
			 entity.setPwd(form.getNewPwd());
			 entity.setAccStatus("UNLOCKED");
			 UserRepo.save(entity);
			 return true;
			 
		 }else {
			 return false;
		 }
		 
		 
	}
	
	
	
	
	
	

	@Override
	public boolean SignUp(SignUpForm form) {
		
		
		UserEntity  user = UserRepo.findByEmail(form.getEmail());
		
		if(user != null) {
			return false;
		}
		
		//TODO:  Copy data from binding obj to entity obj
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(form, entity);
		
		
		//TODO:  generate random pwd  and set to object
		String tempPwd = PwdUtils.generateRandomPwd();
		entity.setPwd(tempPwd);
		
		//TODO:  Set account status as LOCKED
		entity.setAccStatus("LOCKED");
		
		//TODO:  Insert record
		UserRepo.save(entity); 
		
		//TODO:  Send email to user to unlock the account
		String to = form.getEmail();
		String subject = "Unlock Your Account|Ashok IT";
		
		StringBuffer body = new StringBuffer("");
		body.append("<h1> Use below temporary password to unlock your account</h1>");
		
		body.append("Temporary pwd : "+ tempPwd);
		
		body.append("<br/>");
		
		body.append("<a href=\"http://localhost:8080/Unlock?email=" + to +  "\">Click Here To Unlock Your Account</a>");
		
		emailUtils.sendEmail(to, subject, body.toString());
		 
		return true;
	}
	
	
	
	
	
	@Override
	public boolean ForgotPwd(String email) {
		 
	    //check record presence in db with given email	
		 UserEntity entity = UserRepo.findByEmail(email);
		
		
		
		//if record not available return false
		 if(entity == null) {
			 return false;
		 }
		 
		
		//if record available send Pwd to email and return true
		 
		 String Subject = "Recover Password";
		 String body = "Your Pwd :: "+ entity.getPwd();
		 
		 emailUtils.sendEmail(email, Subject, body);
		
		 return true;
	}


	
	
	
	

}
