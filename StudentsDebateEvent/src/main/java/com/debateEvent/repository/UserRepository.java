package com.debateEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.debateEvent.entity.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
	@Query("Select u from User u where u.username=?1")
	public User getUserByUserName(String userName);
}
