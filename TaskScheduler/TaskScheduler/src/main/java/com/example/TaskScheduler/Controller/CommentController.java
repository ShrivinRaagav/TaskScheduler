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

import com.example.TaskScheduler.Entity.commentEntity;
import com.example.TaskScheduler.Service.commentService;

@RestController
public class CommentController {
	
	@Autowired
	commentService cstd;
	
	
	@GetMapping("/getComment")
	public List<commentEntity> commentAll(){
		return cstd.cmtall();
	}
	
	@PostMapping("/postComment")
	 public commentEntity  postall(@RequestBody commentEntity obj) {
		 return cstd.post(obj);
	 }
	
	@DeleteMapping("/deleteComment/{data}")
	 public String deletedComment(@PathVariable int data) {
		 return cstd.deleteCommentid(data);
	 }
	
	@PutMapping("/updateComment/{id}")
	 public commentEntity updatebyCommentid(@PathVariable int id, @RequestBody commentEntity end) {
		 return cstd.updateCommentid(id, end);
	 }
}
