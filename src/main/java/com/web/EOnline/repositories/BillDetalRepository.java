package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.BillDetails;

@Repository
public interface BillDetalRepository extends JpaRepository<BillDetails, Integer> {
	BillDetails findByBillDetailId(int billDetailId);
}
