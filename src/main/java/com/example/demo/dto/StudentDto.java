package com.example.demo.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private UUID studentId;
	private String studentName;
	private int studentAge;
	private String studentGender;
	private String nativePlace;

}
