package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CommentEntity;

public interface CommentRepo  extends JpaRepository<CommentEntity, Integer>  {

}
