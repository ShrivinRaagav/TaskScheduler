package com.example.TaskScheduler.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskScheduler.Entity.roleEntity;
import com.example.TaskScheduler.repo.roleRepo;

@Service
public class roleService {
	
	@Autowired
	roleRepo role;
	
	//get
	public List<roleEntity> roleall(){
		return role.findAll();
	}
	
	//post
	public roleEntity post(roleEntity user) {
		return role.save(user);
	}
	
	//delete
	public String deleteRoleid(int id) {
		if(role.existsById(id)) {
			role.deleteById(id);
			return "Value Deleted Successfully";
		}
		else {
			return "Value not Found "+id;
		}
	}
	
	//update
	public roleEntity updateRoleid(int id,roleEntity etd) {
		if(role.existsById(id)) {
			roleEntity obj=role.findById(id).get();
			
			obj.setRolename(etd.getRolename());
			return role.save(obj);
		}
		return etd;
	}

}
