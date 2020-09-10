package com.company.bma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.bma.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer>{

}
