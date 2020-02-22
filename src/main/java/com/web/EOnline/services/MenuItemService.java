package com.web.EOnline.services;

import java.util.List;

import com.web.EOnline.entities.MenuItems;

public interface MenuItemService {

	MenuItems findMenuItemById(int menuItemId);

	MenuItems createMenuItem(MenuItems menuItems);

	MenuItems updateMenuItem(MenuItems menuItems);

	List<MenuItems> findAllMenuItem();

	public List<MenuItems> findAllByOrderByOrderAsc();

	public MenuItems findMenuItemByProductCode(String productCode);
}
