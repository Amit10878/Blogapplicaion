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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "COMMENT_TBL")
public class CommentEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String comment;
	
	
	@Lob
	private String content;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	@ManyToOne
	@JoinColumn(name ="post_id")
	private PostEntity post;

	
	
	





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public void setUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		
	}

	
	

	

	
	
	
	
	
	
	
	
	
}
