package com.debateEvent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.debateEvent.entity.Student;

@Service
public interface StudentService 
{
	public List<Student> findAll();
	public Student findById(int id);
	public void save(Student student);
	public void delete(int id);
}
