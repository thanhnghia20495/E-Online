package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Statuses;

@Repository
public interface StatusProductRepository extends JpaRepository<Statuses, Integer> {
}
