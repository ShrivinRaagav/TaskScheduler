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

import com.example.TaskScheduler.Entity.roleEntity;
import com.example.TaskScheduler.Service.roleService;

@RestController
public class roleController {

	@Autowired
	roleService rstd;
	
	@GetMapping("/getRole")
	public List<roleEntity> RoleAll(){
		return rstd.roleall();
	}
	
	@PostMapping("/postRole")
	 public roleEntity  postall(@RequestBody roleEntity obj) {
		 return rstd.post(obj);
	 }
	
	@DeleteMapping("/deleteRole/{data}")
	 public String deletedRole(@PathVariable int data) {
		 return rstd.deleteRoleid(data);
	 }
	
	@PutMapping("/updateRole/{id}")
	 public roleEntity updatebyRoleid(@PathVariable int id, @RequestBody roleEntity end) {
		 return rstd.updateRoleid(id, end);
	 }
}
