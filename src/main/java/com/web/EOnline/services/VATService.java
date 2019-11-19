package com.web.EOnline.services;

import com.web.EOnline.entities.VAT;

public interface VATService {
	VAT findByVATId(int VATId);

	VAT createVAT(VAT VAT);

	VAT updateVAT(VAT VAT);


}
