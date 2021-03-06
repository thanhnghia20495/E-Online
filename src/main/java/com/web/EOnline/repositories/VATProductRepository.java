package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.VAT;

@Repository
public interface VATProductRepository extends JpaRepository<VAT, Integer> {
	VAT findByVatId(int VATId);
}
