package com.rootware.meetingrooms.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootware.meetingrooms.domain.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	List<Users> findAll();
}
