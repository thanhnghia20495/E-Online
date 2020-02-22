package com.web.EOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.BillingMethods;

@Repository
public interface BillingMethodRepository extends JpaRepository<BillingMethods, Integer> {
	BillingMethods findByBillingMethodId(int billingMethodId);
}
