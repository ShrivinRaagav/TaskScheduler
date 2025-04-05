package com.example.TaskScheduler.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskScheduler.Entity.remainderEntity;
import com.example.TaskScheduler.repo.remainderRepo;

@Service
public class remainderService {
	
	@Autowired
	remainderRepo rem;
	
	
	//get
	public List<remainderEntity> remall(){
		return rem.findAll();
	}
	
	//post
	public remainderEntity post(remainderEntity user) {
		return rem.save(user);
	}
	
	
	//delete
	public String deleteRemainderid(int id) {
		if(rem.existsById(id)) {
			rem.deleteById(id);
			return "Value Deleted Successfully";
		}
		else {
			return "Value not Found "+id;
		}
	}
	
	
	//update
	public remainderEntity updateRemainderid(int id,remainderEntity etd) {
		if(rem.existsById(id)) {
			remainderEntity obj=rem.findById(id).get();
			
			obj.setRemainderTime(etd.getRemainderTime());
			return rem.save(obj);
		}
		return etd;
	}

}
