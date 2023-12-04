package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CommentEntity;
import com.example.entity.PostEntity;

public interface PostRepo  extends JpaRepository<PostEntity, Integer> {

	public void save(CommentEntity commentEntity);

}
