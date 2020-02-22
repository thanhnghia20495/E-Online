package com.web.EOnline.services;

import com.web.EOnline.entities.BillDetails;

public interface BillDetailService {

	BillDetails findBillById(int billDetailId);

	BillDetails createBillingMethod(BillDetails billDetail);

	BillDetails updateBillingMethod(BillDetails billDetail);

}
