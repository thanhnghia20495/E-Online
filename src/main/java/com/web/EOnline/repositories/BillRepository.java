package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.Bills;

@Repository
public interface BillRepository extends JpaRepository<Bills, Long> {
	Bills findByBillId(long billId);
}
