package com.debateEvent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debateEvent.entity.Student;
import com.debateEvent.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		List<Student> student=studentRepository.findAll();
		return student;
	}

	@Override
	public Student findById(int id) {
		Student student =studentRepository.findById(id).get();
		return student;
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);
	}
	
}
