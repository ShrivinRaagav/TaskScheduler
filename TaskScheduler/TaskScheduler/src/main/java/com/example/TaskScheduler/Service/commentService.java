package com.example.TaskScheduler.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskScheduler.Entity.commentEntity;
import com.example.TaskScheduler.repo.commentRepo;

@Service
public class commentService {
	
	@Autowired
	commentRepo cmt;
	
	//get
	public List<commentEntity> cmtall(){
		return cmt.findAll();
	}
	
	//post
	public commentEntity post(commentEntity user) {
		return cmt.save(user);
	}
	
	//delete
	public String deleteCommentid(int id) {
		if(cmt.existsById(id)) {
			cmt.deleteById(id);
			return "Value Deleted Successfully";
		}
		else {
			return "Value not Found "+id;
		}
	}
	
	//update
	public commentEntity updateCommentid(int id,commentEntity etd) {
		if(cmt.existsById(id)) {
			commentEntity obj=cmt.findById(id).get();
			
			obj.setTask_id(etd.getTask_id());
			obj.setUser_id(etd.getUser_id());
			obj.setContent(etd.getContent());
			return cmt.save(obj);
		}
		return etd;
	}

}
