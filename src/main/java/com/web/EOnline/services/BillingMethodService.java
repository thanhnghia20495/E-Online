package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.BillingMethods;

public interface BillingMethodService {

	BillingMethods findBillingMethodById(int billingMethodId);
	
	List<BillingMethods> findAllBillingMethod();

	BillingMethods createBillingMethod(BillingMethods billingMethods);

	BillingMethods updateBillingMethod(BillingMethods billingMethods);

}
