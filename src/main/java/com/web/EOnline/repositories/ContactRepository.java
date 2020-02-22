package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Contacts;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, Integer> {
}
