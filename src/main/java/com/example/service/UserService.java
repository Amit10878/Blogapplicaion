package com.example.service;

import com.example.binding.LoginForm;
import com.example.binding.SignUpForm;
import com.example.binding.UnlockForm;

public interface UserService {

	public String Login(LoginForm form);

	public boolean UnlockAccount(UnlockForm form);

	public boolean SignUp(SignUpForm form);

	public boolean ForgotPwd(String email);

	

}
