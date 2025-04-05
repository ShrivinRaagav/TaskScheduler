package com.example.TaskScheduler.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskScheduler.Entity.taskEntity;

import com.example.TaskScheduler.Service.taskService;




@RestController
public class taskController {
	
	@Autowired
	taskService std;
	
	
	
	//GetMapping
	@GetMapping("/getTask")
	public List<taskEntity> UserAll() {
		return std.getall();
	}
	
	 //PostMapping
	 @PostMapping("/postTask")
	 public taskEntity  postall(@RequestBody taskEntity obj) {
		 return std.post(obj);
	 }
	 
	 
	 //DeleteMapping
	 @DeleteMapping("/deleteTask/{data}")
	 public String deletedTask(@PathVariable int data) {
		 return std.deleteTaskid(data);
	 }
	 
	 
	 
	 //PutMapping
     @PutMapping("/updateTask/{id}")
	 public taskEntity updatebyTaskid(@PathVariable int id, @RequestBody taskEntity end) {
		 return std.updateTaskid(id, end);
	 }
     
     
     @GetMapping("/and")
	 public List<taskEntity> specific(@RequestParam int id,@RequestParam String task){
		 return std.retrive_specific(id,task);
	 }
	 @GetMapping("/or")
	 public List<taskEntity> retrive(@RequestParam int id , @RequestParam String task)
	 {
		return std.retrive(id,task);
	 }
	 
	 @GetMapping("/start")
	 public List<taskEntity> start_1(@RequestParam String task) {
		 return std.start(task);
		 
	 }
	 
	 @GetMapping("/endwith")
	 public List<taskEntity> end_1(@RequestParam String task){
		 return std.end(task);
	 }
	 
	 @GetMapping("/Contain")
	 public List<taskEntity> Having(@RequestParam String task)
	 {
	  	return std.Contain(task);
	 }
	 
	 @GetMapping("/IsContain")
	 public List<taskEntity> IsContains(@RequestParam String task)
	 {
	   	return std.Containing(task);
	 }
	 @GetMapping("/notContain")
	 public List<taskEntity> NotContaining(@RequestParam String task)
	 {
	   	return std.NotContain(task);
	 }
	 @GetMapping("/notContaining")
	 public List<taskEntity> NotContain(@RequestParam String task)
	 {
	   	return std.NotHaving(task);
	 }
	 @GetMapping("/Like")
	 public List<taskEntity> Likes(@RequestParam String task)
	 {
		 return std.TaskLiking(task);
	 }
	 @GetMapping("/notLike")
	 public List<taskEntity> NotLikes(@RequestParam String task)
	 {
	   	return std.TaskNotLiking(task);
	 }
	 
	 // Get tasks with pagination
	 @GetMapping("/tasks")
	 public Page<taskEntity> getTasks(
			 @RequestParam(defaultValue = "0") int page,
			 @RequestParam(defaultValue = "10") int size,
			 @RequestParam(defaultValue = "id") String sortBy, // Sorting field
			 @RequestParam(defaultValue = "asc") String direction // Sorting order
			 )       
	 {
		 return std.getAllTasks(page, size, sortBy, direction);
	 }

     
}
