package com.debateEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debateEvent.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> 
{
	
}
