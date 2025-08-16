package com.practicing.dailyentries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicing.dailyentries.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
