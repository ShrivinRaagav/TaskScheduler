package com.example.TaskScheduler.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskScheduler.Entity.notificationEntity;
import com.example.TaskScheduler.Service.notificationService;

@RestController
public class notificationController {

	@Autowired 
	notificationService rstd;
	
	
	@GetMapping("/getNotification")
	public List<notificationEntity> notifiAll(){
		return rstd.notifyall();
	}
	
	@PostMapping("/postNotification")
	 public notificationEntity  postall(@RequestBody notificationEntity obj) {
		 return rstd.post(obj);
	 }
	
	@DeleteMapping("/deleteNotification/{data}")
	 public String deletedNotification(@PathVariable int data) {
		 return rstd.deleteNotificationid(data);
	 }
	
	@PutMapping("/updateNotification/{id}")
	 public notificationEntity updatebyNotificationid(@PathVariable int id, @RequestBody notificationEntity end) {
		 return rstd.updateNotificationid(id, end);
	 }
	
	
	//email
	@PostMapping("Email")
	public String senddata(@RequestParam String receiver,@RequestParam String Subject,@RequestParam String body) {
		return rstd.sendmail(receiver, Subject, body);
	}
}
