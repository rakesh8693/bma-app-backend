package com.company.bma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.bma.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
