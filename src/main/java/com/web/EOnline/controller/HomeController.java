package com.web.EOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("home-page")
	public String homePage() {
		return "home-page";
	}
	 @GetMapping("detail-page")
	    public String detailPage() {
	        return "detail-page";
	    }

	    @GetMapping("cart-page")
	    public String cartPage() {
	        return "cart-page";
	    }

	    @GetMapping("contact-page")
	    public String contactPage() {
	        return "contact-page";
	    }
}
