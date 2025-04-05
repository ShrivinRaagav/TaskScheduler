package com.example.TaskScheduler.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskScheduler.Entity.remainderEntity;
import com.example.TaskScheduler.Service.remainderService;

@RestController
public class remainderController {

	@Autowired
	remainderService rstd;
	
	
	//get
	@GetMapping("/getRemainder")
	public List<remainderEntity> remaindAll(){
		return rstd.remall();
	}
	
	//post
	@PostMapping("/postRemainder")
	 public remainderEntity  postall(@RequestBody remainderEntity obj) {
		 return rstd.post(obj);
	 }
	
	
	//delete
	@DeleteMapping("/deleteRemainder/{data}")
	 public String deletedRemainder(@PathVariable int data) {
		 return rstd.deleteRemainderid(data);
	 }
	
	
	//put
	@PutMapping("/updateRemainder/{id}")
	 public remainderEntity updatebyRemainderid(@PathVariable int id, @RequestBody remainderEntity end) {
		 return rstd.updateRemainderid(id, end);
	 }
}
