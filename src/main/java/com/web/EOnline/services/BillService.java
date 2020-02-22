package com.web.EOnline.services;

import com.web.EOnline.entities.Bills;

public interface BillService {

	Bills findBillById(long billId);

	Bills createBillingMethod(Bills bill);

	Bills updateBillingMethod(Bills bill);

}
