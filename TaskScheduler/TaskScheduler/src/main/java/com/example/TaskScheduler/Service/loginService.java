package com.example.TaskScheduler.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskScheduler.Entity.loginEntity;
import com.example.TaskScheduler.repo.loginRepo;

@Service
public class loginService {
	
	@Autowired
	loginRepo logi;
	
	
	//get
	public List<loginEntity> all() {
		return logi.findAll();
	}
	
	
	//post
	public loginEntity post(loginEntity user) {
		return logi.save(user);
	}
	
	
	//delete
	public String deleteLoginid(int id) {
		if(logi.existsById(id)) {
			logi.deleteById(id);
			return "Value Deleted Successfully";
		}
		else {
			return "Value not Found "+id;
		}
	}
	
	
	//update
	public loginEntity updateLoginid(int id,loginEntity etd) {
		if(logi.existsById(id)) {
			loginEntity obj=logi.findById(id).get();
			
			obj.setPassword(etd.getPassword());
			return logi.save(obj);
		}
		return etd;
	}

}
