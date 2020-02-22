package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.TelePhones;

@Repository
public interface TelephoneRepository extends JpaRepository<TelePhones, Integer> {
	public TelePhones findByHotLine(String hotLine);
}
