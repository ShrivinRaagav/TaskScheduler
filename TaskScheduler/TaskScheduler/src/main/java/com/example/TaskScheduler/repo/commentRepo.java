package com.example.TaskScheduler.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskScheduler.Entity.commentEntity;

@Repository
public interface commentRepo extends JpaRepository<commentEntity, Integer>{
	
	List<commentEntity> findAll();
}
