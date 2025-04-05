package com.example.TaskScheduler.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

@Table(name="user_credentials")
public class taskEntity {
	
	@Id
	@Column (name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="Task")
	String task;
	@Column(name="Description")
	String description;
	@Column(name="Due_date")
	private LocalDate dueDate;
	@Column(name="Status")
	String status;
	
	@OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<remainderEntity> remainder;


	
}
