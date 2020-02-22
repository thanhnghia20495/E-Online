package com.web.EOnline.Handling;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Contacts;
import com.web.EOnline.entities.Keywords;
import com.web.EOnline.entities.MenuItems;
import com.web.EOnline.services.Category2Service;
import com.web.EOnline.services.ContactService;
import com.web.EOnline.services.KeyWordService;
import com.web.EOnline.services.MenuItemService;

@Component
public class MenuItemHandlerInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MenuItemService menuItemService;

	@Autowired
	Category2Service category2Service;
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	KeyWordService KeyWordService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<MenuItems> listmenuItem = menuItemService.findAllMenuItem();
		List<Category2> listCategory2 = category2Service.findAllCategory2();
		List<Contacts> contact = contactService.findAllContact();
		List<Keywords> keywords = KeyWordService.findKeywordsByActive("Y");
		String srtKeyWords ="";
		for (Keywords keyword : keywords) {
			srtKeyWords = srtKeyWords + keyword.getKeyWord() +";";
		}
		request.setAttribute("keywords", srtKeyWords);
		request.setAttribute("contact", contact);
		request.setAttribute("menuItems", listmenuItem);
		request.setAttribute("category2", listCategory2);
		return super.preHandle(request, response, handler);
	}
}