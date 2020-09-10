package com.company.bma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShortUrlRepository extends JpaRepository<com.company.bma.model.ShortUrl,Integer> {

}
