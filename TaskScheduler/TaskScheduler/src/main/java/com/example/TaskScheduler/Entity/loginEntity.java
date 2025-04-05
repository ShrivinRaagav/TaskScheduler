package com.example.TaskScheduler.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name="login_credentials")
public class loginEntity {
	@Id
	@Column (name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column (name="username")
	String username;
	@Column (name="email")
	String email;
	@Column (name="password")
	String password;
}
