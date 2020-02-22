package com.web.EOnline.Handling;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.web.EOnline.entities.MenuItems;
import com.web.EOnline.services.MenuItemService;

@Configuration
public class MenuItemConfig implements WebMvcConfigurer {
	@Autowired
	MenuItemHandlerInterceptor menuItemHandlerInterceptor;

	@Autowired
	MenuItemService menuItemService;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> paths = menuItemService.findAllByOrderByOrderAsc().stream().map(MenuItems::getPathUrl)
				.collect(Collectors.toList());
		// paths.add(Constants.PATH_URL_CATEGORY);
		registry.addInterceptor(menuItemHandlerInterceptor).addPathPatterns(paths);
	}
}
