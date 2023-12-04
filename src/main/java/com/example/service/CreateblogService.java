package com.example.service;

import java.util.List;

import com.example.binding.CreateblogForm;
import com.example.binding.ViewblogForm;
import com.example.entity.CommentEntity;
import com.example.entity.PostEntity;
public interface CreateblogService {

	

	public boolean saveCreateblog(CreateblogForm formObj);

	public List<PostEntity> getDashboard();

	public boolean saveViewblog(ViewblogForm formObj);

	public List<CommentEntity> getViewcomment();







	



	

	

	

	
	
	

}
