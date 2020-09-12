package com.company.bma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.bma.model.ShortUrl;


@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl,Integer> {

}
