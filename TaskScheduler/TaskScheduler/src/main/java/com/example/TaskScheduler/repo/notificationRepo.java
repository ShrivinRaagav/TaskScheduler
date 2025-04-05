package com.example.TaskScheduler.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskScheduler.Entity.notificationEntity;


public interface notificationRepo extends JpaRepository<notificationEntity, Integer>{
	
	List<notificationEntity> findAll();
}
