package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/post")
	public String save(@RequestBody Student student) {
		studentService.save(student);
		return "success";
	}
	
	@PostMapping("/postall")
	public String saveAll(@RequestBody List<Student>student) {
		studentService.saveAll(student);
		return "success";
	}
	@PostMapping("/save")
	public String post(@RequestBody StudentDto studentDto) {
		studentService.post(studentDto);
		return "success";
		
		}
	@PostMapping("/saveall")
	public String postAll(@RequestBody List<StudentDto>studentDto) {
		studentService.postAll(studentDto);
		return "Success";
		
	}
	
	@GetMapping("/get")
	public List<Student>get(){
		return studentService.getAll();	
	}
	@GetMapping("/getall")
	public List<StudentDto>getAll(){
		return studentService.get();
	}
	@GetMapping("/getbyid")
	public Student getByid(@RequestParam UUID id) {
		return studentService.getByid(id);
	}
	@GetMapping("/getByid")
	public StudentDto getbyId(@RequestParam UUID id) {
		return studentService.getbyId(id);
	}
	@GetMapping("/getByname")
	public Optional<Student> getByname(@RequestParam String name) {
		return studentService.getByname(name);
	}
	@GetMapping("/getbyName")
	public StudentDto getbyName(@RequestParam String name) {
		return studentService.getbyName(name);
	}
	@PutMapping("/put/{id}")
	public String putDetails(@RequestBody Student student,@PathVariable UUID id) {
		studentService.putDetails(student,id);
		return "Success";
	}
	@PutMapping("/putdetails")
	public String putdetails(@RequestBody StudentDto studentDto) {
		studentService.putdetails(studentDto);
		return "Success";
	}
	@DeleteMapping("/delete/{id}")
	public void deleteDetails(@PathVariable UUID id,@RequestBody Student student) {
		 studentService.deleteDetails(student,id);
	}
	@DeleteMapping("/deletedetails")
	public void deletedetails(@RequestBody StudentDto studentDto) {
		studentService.deleteDetails(studentDto);
	}

}
