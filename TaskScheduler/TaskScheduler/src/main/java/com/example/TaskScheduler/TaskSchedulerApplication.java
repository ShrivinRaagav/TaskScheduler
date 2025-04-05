package com.example.TaskScheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSchedulerApplication.class, args);
		
		String url="jdbc:mysql://localhost:3306/taskScheduler";
		String user="root";
		String password="Raagav756";
		try(Connection con=DriverManager.getConnection(url, user, password))
		{
			if(con!=null)
			{
				System.out.println("Connection successfully");
				
			}
		}
		catch(SQLException e)	
		{
			System.out.println("Connection unsuccessful"+e.getMessage());
		}
				
	}

}
