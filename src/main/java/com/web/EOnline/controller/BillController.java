package com.web.EOnline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.EOnline.Utils.ConvertUtils;
import com.web.EOnline.dto.CartDTO;
import com.web.EOnline.dto.MessageError;
import com.web.EOnline.entities.BillDetails;
import com.web.EOnline.entities.Bills;
import com.web.EOnline.services.BillDetailService;
import com.web.EOnline.services.BillService;
import com.web.EOnline.services.BillingMethodService;

@Controller
public class BillController {

	@Autowired
	BillService billService;

	@Autowired
	BillDetailService billDetailService;

	@Autowired
	BillingMethodService billingMethodService;

	@RequestMapping(value = "/bill-page", method = RequestMethod.POST)
	public String billPage(HttpSession session, Model model, @ModelAttribute("formBill") Bills formBills,
			BindingResult bindingResult) {
		MessageError messageError = new MessageError();
		List<String> messageStr = new ArrayList<String>();
		if (bindingResult.hasErrors()) {
			messageError.setError(true);
			messageStr.add("Thanh toán thất bại!");
		}
		if (!ConvertUtils.validate(formBills.getEmail())) {
			messageError.setError(true);
			messageStr.add("Email của bạn không hợp lệ!");
		}
		if (billingMethodService.findBillingMethodById(formBills.getBillingMethods().getBillingMethodId())==null) {
			messageError.setError(true);
			messageStr.add("Vui lòng chọn phương thức thanh toán!");
		}
		if (messageError.isError()) {
			messageError.setMessage(messageStr);
			model.addAttribute("disabled", "true");
			model.addAttribute("bills", new Bills());
			model.addAttribute("billingMethods", billingMethodService.findAllBillingMethod());
			model.addAttribute("messageError", messageError);
			return "cart-page";
		}
		@SuppressWarnings("unchecked")
		Map<String, CartDTO> items = (HashMap<String, CartDTO>) session.getAttribute("cartItem");
		long totalPrice = (long) session.getAttribute("totalPrice");
		long billId =0;
		if (items != null) {
			billId = System.currentTimeMillis();
			Bills bills = new Bills(billId, "Khach Hang", formBills.getEmail(), formBills.getTelephone(),
					formBills.getAddress(), formBills.getNote(), totalPrice, formBills.getBillingMethods());
			billService.createBillingMethod(bills);
			for (Map.Entry<String, CartDTO> prod : items.entrySet()) {
				BillDetails billDetails = new BillDetails(bills, prod.getValue().getProducts(), prod.getValue().getProducts().getProductName(),
						prod.getValue().getProducts().getPriceDiscount(), prod.getValue().getQuantities());
				billDetailService.createBillingMethod(billDetails);
			}
		}
		items.clear();
		session.removeAttribute("sizeCartItem");
		session.removeAttribute("totalPrice");
		return "redirect:/check-out?id="+billId;
	}

	@RequestMapping(value = "/check-out", method = RequestMethod.GET)
	public String checkoutPage(Model model, @RequestParam("id") long billId) {
		Bills bills= billService.findBillById(billId);
		if (bills==null) {
			model.addAttribute("errorStatus", 404);
	        return "error-pages/error";
		}
		model.addAttribute("bills", bills);
		return "checkout-page";
	}
}