package com.example.TaskScheduler.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.example.TaskScheduler.Entity.notificationEntity;
import com.example.TaskScheduler.repo.notificationRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class notificationService {

	
	@Autowired JavaMailSender sender;
	
	@Autowired 
	notificationRepo notify;
	
	
	//get
	public List<notificationEntity> notifyall(){
		return notify.findAll();
	}
	
	//post
	public notificationEntity post(notificationEntity user) {
		return notify.save(user);
	}
	
	
	//delete
	public String deleteNotificationid(int id) {
		if(notify.existsById(id)) {
			notify.deleteById(id);
			return "Value Deleted Successfully";
		}
		else {
			return "Value not Found "+id;
		}
	}
	
	
	//update
	public notificationEntity updateNotificationid(int id,notificationEntity etd) {
		if(notify.existsById(id)) {
			notificationEntity obj=notify.findById(id).get();
			obj.setReceiver(etd.getReceiver());
			obj.setSubject(etd.getSubject());
			obj.setBody(etd.getBody());
			return notify.save(obj);
		}
		return etd;
	}
	
	
	//email
	public String sendmail(String receiver,String subject,String body) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(receiver);            // setTo is a function to set to the receiver
			helper.setSubject(subject);        //setSubject used to set the subject              
			helper.setText(body);              //setText is used to set the body
			
			sender.send(message);
			
			notificationEntity email= new notificationEntity();
			email.setReceiver(receiver);
			email.setSubject(subject);
			email.setBody(body);
			notify.save(email);
			return "Email sent successfully "+receiver;
		}
		catch (MessagingException e) {
			return "Email Not Found "+e.getMessage();                              
		} 
	}
}
