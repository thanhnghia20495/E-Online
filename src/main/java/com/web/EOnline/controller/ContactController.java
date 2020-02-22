package com.web.EOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.EOnline.entities.MenuItems;
import com.web.EOnline.entities.Scripts;
import com.web.EOnline.services.MenuItemService;
import com.web.EOnline.services.ScriptService;

@Controller
public class ContactController {
	@Autowired
	MenuItemService menuItemService;
	
	@Autowired
	ScriptService scriptService;
	
	@GetMapping("contact-page")
	public String contactPage(Model model) {
		MenuItems homeBC = menuItemService.findMenuItemById(1);
		MenuItems ContactBC = menuItemService.findMenuItemById(5);
		Scripts script = scriptService.findScriptByDescription("Google Map");
		model.addAttribute("googleMap", script);
		model.addAttribute("contact_bc", ContactBC);
 		model.addAttribute("menuItem", homeBC);
		return "contact-page";
	}

}