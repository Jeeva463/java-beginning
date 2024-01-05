package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public void save(Student student) {
		studentRepository.save(student);
		return;
	}

	public void saveAll(List<Student> student) {
		studentRepository.saveAll(student);
		return;
		
	}

	public void post(StudentDto studentDto) {
		Student obj=new Student();
		obj.setStudentName(studentDto.getStudentName());
		obj.setStudentAge(studentDto.getStudentAge());
		obj.setStudentGender(studentDto.getStudentGender());
		obj.setNativePlace(studentDto.getNativePlace());
		studentRepository.save(obj);
		return;
	}

	public void postAll(List<StudentDto> studentDto) {
		for(StudentDto stu: studentDto) {
			Student dent=new Student();
			dent.setStudentName(stu.getStudentName());
			dent.setStudentAge(stu.getStudentAge());
			dent.setStudentGender(stu.getStudentGender());
			dent.setNativePlace(stu.getNativePlace());
			studentRepository.save(dent);
			return;
			}
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public List<StudentDto> get() {
		List<StudentDto>studentList=new ArrayList<StudentDto>();
		List<Student>student=studentRepository.findAll();
		for(Student obj:student) {
			StudentDto dto=new StudentDto();
			dto.setStudentId(obj.getStudentId());
			dto.setStudentName(obj.getStudentName());
			dto.setStudentAge(obj.getStudentAge());
			dto.setStudentGender(obj.getStudentGender());
			dto.setNativePlace(obj.getNativePlace());
			studentList.add(dto);
		}
		return studentList;
	}

	public Student getByid(UUID id) {
		return studentRepository.findById(id).orElse(null);
	}

	public StudentDto getbyId(UUID id) {
		Optional<Student> student=studentRepository.findById(id);
		Student stu=student.get();
		StudentDto Dto=new StudentDto();
		Dto.setStudentId(stu.getStudentId());
		Dto.setStudentAge(stu.getStudentAge());
		Dto.setStudentGender(stu.getStudentGender());
		Dto.setStudentName(stu.getStudentName());
		Dto.setNativePlace(stu.getNativePlace());
		return Dto;
	}

	public Optional<Student> getByname(String name) {
		return studentRepository.findBystudentName(name);
	}

	public StudentDto getbyName(String name) {
		Optional<Student> obj=studentRepository.findBystudentName(name);
		Student stu=obj.get();
		StudentDto Dto=new StudentDto();
		Dto.setStudentId(stu.getStudentId());
		Dto.setStudentAge(stu.getStudentAge());
		Dto.setStudentGender(stu.getStudentGender());
		Dto.setStudentName(stu.getStudentName());
		Dto.setNativePlace(stu.getNativePlace());
		return Dto;
		
	}

	public void putDetails(Student student, UUID id) {
		studentRepository.save(student);
		return;
	}

	public void putdetails(StudentDto studentDto) {
		Optional<Student> obj=studentRepository.findById(studentDto.getStudentId());
		Student student=obj.get();
		student.setStudentName(studentDto.getStudentName());
		student.setStudentAge(studentDto.getStudentAge());
		student.setStudentGender(studentDto.getStudentGender());
		student.setNativePlace(studentDto.getNativePlace());
		studentRepository.save(student);
		return;
		}

	public void deleteDetails(Student student, UUID id) {
		 studentRepository.deleteById(id);
	}

	public void deleteDetails(StudentDto studentDto) {
		Optional<Student>obj=studentRepository.findById(studentDto.getStudentId());
		Student student=obj.get();
		student.setStudentName(studentDto.getStudentName());
		student.setStudentAge(studentDto.getStudentAge());
		student.setStudentGender(studentDto.getStudentGender());
		student.setNativePlace(studentDto.getNativePlace());
		studentRepository.delete(student);
		
		}

}
