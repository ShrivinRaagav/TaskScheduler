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

@Table(name="comment_credentials")
public class commentEntity {
	@Id
	@Column (name="comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int comment_id;
	@Column (name="task_id")
	int task_id;
	@Column (name="user_id")
	int user_id;
	@Column (name="content")
	String content;
}
