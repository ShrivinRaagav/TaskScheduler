package com.example.TaskScheduler.repo;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskScheduler.Entity.taskEntity;


@Repository
public interface taskRepo extends JpaRepository<taskEntity, Integer> {
	
	List<taskEntity> findAll();
    List<taskEntity>findByIdAndTask(int id,String task);
	
	List<taskEntity> findByIdOrTask(int id,String task);


	List<taskEntity>findByTaskStartingWith(String task);
	List<taskEntity>findByTaskEndingWith(String task);
	
	List<taskEntity> findByTaskContains(String task);

	List<taskEntity> findByTaskIsContaining(String task);

	List<taskEntity> findByTaskNotContains(String task);

	List<taskEntity> findByTaskNotContaining(String task);
	
	List<taskEntity> findByTaskLike(String task);
	List<taskEntity> findByTaskNotLike(String task);
	
	//pagination
	Page<taskEntity> findAll(Pageable pageable); 
}
