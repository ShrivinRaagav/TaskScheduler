package com.example.TaskScheduler.Entity;

import java.time.LocalDate;

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

@Table(name="remainder_credentials")
public class remainderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="remainder_id")
	int remainder_id;
	@Column (name="remainder_time")
	private LocalDate remainderTime;
	
	

}
