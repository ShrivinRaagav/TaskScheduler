package com.example.TaskScheduler.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskScheduler.Entity.loginEntity;


@Repository
public interface loginRepo extends JpaRepository<loginEntity, Integer>{
	
	List<loginEntity> findAll();
}
