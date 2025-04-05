package com.example.TaskScheduler.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskScheduler.Entity.remainderEntity;


@Repository
public interface remainderRepo extends JpaRepository<remainderEntity, Integer>{
	
	List<remainderEntity> findAll();
}
