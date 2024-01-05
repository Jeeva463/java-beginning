package com.example.demo.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="records")
public class Student {
	@Id
	@GeneratedValue(generator="UUID")
	@Column(name="student_id")
	private UUID studentId;
	@Column(name="student_name")
	private String studentName;
	@Column(name="student_age")
	private int studentAge;
	@Column(name="student_gender")
	private String studentGender;
	@Column(name="native_place")
	private String nativePlace;


}
