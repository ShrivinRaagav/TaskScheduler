package com.example.TaskScheduler.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.TaskScheduler.Entity.taskEntity;

import com.example.TaskScheduler.repo.taskRepo;

@Service
public class taskService {
	
	@Autowired
	taskRepo rep;
	
	
	//get
	public List<taskEntity> getall() {
		return rep.findAll();
	}
	
	
	//post
	public taskEntity post(taskEntity user) {
		return rep.save(user);
	}
	
	
	//delete
	public String deleteTaskid(int id) {
		if(rep.existsById(id)) {
			rep.deleteById(id);
			return "Value Deleted Successfully";
		}
		else {
			return "Value not Found "+id;
		}
	}
	
	
	//update
	public taskEntity updateTaskid(int id,taskEntity etd) {
		if(rep.existsById(id)) {
			taskEntity obj=rep.findById(id).get();
			
			obj.setStatus(etd.getStatus());
			return rep.save(obj);
		}
		return etd;
	}
	
	public List<taskEntity> retrive_specific(int id,String task) {
		return rep.findByIdAndTask(id,task);
	}
	public List<taskEntity> retrive(int id,String task) {
		return rep.findByIdOrTask(id,task);
	}
	
	//contains
	public List<taskEntity> start(String task){
		return rep.findByTaskStartingWith(task);
	}
	public List<taskEntity> end(String task){
		return rep.findByTaskEndingWith(task);
	}
	
	public List<taskEntity> Contain(String task)
	{
		return rep.findByTaskContains(task);
	}
	public List<taskEntity> Containing(String task)
	{
		return rep.findByTaskIsContaining(task);
	}
	public List<taskEntity> NotContain(String task)
	{
		return rep.findByTaskNotContains(task);
	}
	public List<taskEntity> NotHaving(String task)
	{
		return rep.findByTaskNotContaining(task);
	}
	public List<taskEntity> TaskLiking(String task)
	{
		return rep.findByTaskLike(task);
	}
	public List<taskEntity> TaskNotLiking(String task)
	{
		return rep.findByTaskNotLike(task);
	}
	
	// Get tasks with pagination
    public Page<taskEntity> getAllTasks(int page, int size,String sortBy, String direction) {
    	Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
    	Pageable pageable = PageRequest.of(page, size, sort);
        return rep.findAll(pageable);
    }
}
