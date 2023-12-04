package com.example.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "POST_TBL")
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private String title;
	private String description;
	
	
	
	@Lob
	private String content;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	@UpdateTimestamp
	private LocalDate updatedOn;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	
	
	





	public Integer getPostId() {
		return postId;
	}



	public void setPostId(Integer postId) {
		this.postId = postId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public LocalDate getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}



	public LocalDate getUpdatedOn() {
		return updatedOn;
	}



	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}



	public UserEntity getUser() {
		return user;
	}



	public void setUser(UserEntity user) {
		this.user = user;
	}



	


	

	
	
	
}
