package com.web.EOnline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.EOnline.entities.MenuItems;
import com.web.EOnline.repositories.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public MenuItems findMenuItemById(int menuItemId) {
		try {
			return menuItemRepository.findByMenuId(menuItemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MenuItems createMenuItem(MenuItems menuItems) {
		try {
			return menuItemRepository.save(menuItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MenuItems updateMenuItem(MenuItems menuItems) {
		try {
			return menuItemRepository.save(menuItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuItems> findAllMenuItem() {
		try {
			return menuItemRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuItems> findAllByOrderByOrderAsc() {
		try {
			return menuItemRepository.findAllByOrderByOrderAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MenuItems findMenuItemByProductCode(String productCode) {
		try {
			return menuItemRepository.findMenuItemByProductCode(productCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
