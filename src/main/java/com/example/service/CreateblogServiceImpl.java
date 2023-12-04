package com.example.service;

import java.util.List;


import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.binding.CreateblogForm;

import com.example.binding.ViewblogForm;
import com.example.entity.CommentEntity;
import com.example.entity.PostEntity;
import com.example.entity.UserEntity;
import com.example.repo.CommentRepo;
import com.example.repo.PostRepo;
import com.example.repo.UserRepo;



@Repository
public class CreateblogServiceImpl  implements CreateblogService {
	

	@Autowired
	private UserRepo  userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	
	@Autowired
	private  HttpSession session;
	
	
	

	
	


	 @Override	
		public List<PostEntity> getDashboard(){
			Integer userId = (Integer) session.getAttribute("userId");
			Optional<UserEntity> findById = userRepo.findById(userId);
			if(findById.isPresent()) {
				
				UserEntity userEntity = findById.get();
				List<PostEntity> dashboard = postRepo.findAll();
				return dashboard;
			} 
			return null;
	    }
	 
	 @Override
		public boolean saveCreateblog(CreateblogForm formObj) {
			
			 PostEntity postEntity = new  PostEntity();
			 //BeanUtils.copyProperties(formObj, postEntity);
			 postEntity.setTitle(formObj.getPosttitleCnt());
			 postEntity.setDescription(formObj.getPostshortdescriptionCnt());
			
			 Integer userId = (Integer) session.getAttribute("userId");
			
			 UserEntity userEntity = userRepo.findById(userId).get();
			 postEntity.setUser(userEntity);
			 
			 postRepo.save(postEntity);
			
			 return true;
		}
	
	
	 @Override
		public boolean saveViewblog(ViewblogForm formObj) {
			
		 CommentEntity commentEntity = new  CommentEntity();
	     //BeanUtils.copyProperties(formObj, commentEntity);
		 commentEntity.setName(formObj.getNameCnt());
		 commentEntity.setEmail(formObj.getEmailCnt());
		 commentEntity.setComment(formObj.getCommentCnt());
		 
			
			 Integer userId = (Integer) session.getAttribute("userId");
			
			 UserEntity userEntity = userRepo.findById(userId).get();
			 commentEntity.setUser(userEntity);
			 
			 commentRepo.save(commentEntity);
			
			 return true;
		}
	
	    @Override	
		public List<CommentEntity> getViewcomment(){
			Integer userId = (Integer) session.getAttribute("userId");
			Optional<UserEntity> findById = userRepo.findById(userId);
			if(findById.isPresent()) {
				
				UserEntity userEntity = findById.get();
				List<CommentEntity> viewcomment = commentRepo.findAll();
				return viewcomment;
			} 
			return null;
	    }

		
		
	
}
