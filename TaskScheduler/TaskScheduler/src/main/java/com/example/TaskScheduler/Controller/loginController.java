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

import com.example.TaskScheduler.Entity.loginEntity;
import com.example.TaskScheduler.Service.loginService;

@RestController
public class loginController {

	
	@Autowired
	loginService lstd;
	
	//get
	@GetMapping("/getLogin")
	public List<loginEntity> loginAll() {
		return lstd.all();
	}
	
	//post
	@PostMapping("/postLogin")
	 public loginEntity  postall(@RequestBody loginEntity obj) {
		 return lstd.post(obj);
	 }
	
	//delete
	@DeleteMapping("/deleteLogin/{data}")
	 public String deletedLogin(@PathVariable int data) {
		 return lstd.deleteLoginid(data);
	 }
	
	//update
	@PutMapping("/updateLogin/{id}")
	 public loginEntity updatebyLoginid(@PathVariable int id, @RequestBody loginEntity end) {
		 return lstd.updateLoginid(id, end);
	 }
	
}
