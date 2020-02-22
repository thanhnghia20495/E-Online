package com.web.EOnline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.EOnline.Utils.ConvertUtils;
import com.web.EOnline.dto.CategoryProductDTO;
import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Products;
import com.web.EOnline.services.Category2Service;
import com.web.EOnline.services.MenuItemService;
import com.web.EOnline.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService prodService;

	@Autowired
	MenuItemService menuItemService;

	@Autowired
	Category2Service category2Service;

	@RequestMapping(value = "autocomplete", method = RequestMethod.POST)
	@ResponseBody
	public List<String> autoComplete(@RequestParam("keyword") String keyword) {
		List<String> l = new ArrayList<String>();
		List<Products> listProduct = prodService.findByProductNameContainingIgnoreCase(keyword);
		if (!listProduct.isEmpty()) {
			l = new ArrayList<String>();
			l.add("<div class= 'des_autocomplete'>Tìm thấy " + listProduct.size() + " sản phẩm</div>");
			for (Products p : prodService.findByProductNameContainingIgnoreCase(keyword)) {
				l.add("<li><a href='/detail-page?id=" + p.getProductCode()
						+ "'> <img alt='' src='https://thietbikhangan.vn/upload/sanpham/may_phun_xit_rua_ap_luc_cao_bosch_advanced-aquatak_140-8099.jpg'> "
						+ p.getProductName() + "<p class='product-price-search'>\n" + "\n" + "<span class="
						+ (p.getPriceDiscount() > 0 ? "'old-price'" : "'new-price'") + "><b>"
						+ ConvertUtils.convertFormatPrice(p.getPrice()) + "</b></span> \n" + "\n" + "<span class="
						+ (p.getPriceDiscount() > 0 ? "'new-price'" : "'old-price'") + "><b>"
						+ ConvertUtils.convertFormatPrice(p.getPriceDiscount()) + "</b></span>\n" + "\n" + "</p>"
						+ "</a></li>");
			}
		} else {
			l.add("<ul><li>Không tìm thấy sản phẩm nào :(</li></ul>");
		}

		return l;
	}

	@RequestMapping(value = "/home-page", method = RequestMethod.GET)
	public String listProducts(Model model, @RequestParam(value = "page", defaultValue = "1") Optional<String> page) {
		try {
			Map<Integer, CategoryProductDTO> mapHomeProduct = new HashMap<Integer, CategoryProductDTO>();
			List<Category2> category2 = category2Service.findByOptionBestSellingAndOrderByOrderAsc("Y");
			for (Category2 category : category2) {
				List<Products> products = prodService.findByCategory2AndOptionBestSelling("Y",
						category.getCategory2Id());
				CategoryProductDTO categoryProduct = new CategoryProductDTO(category, products);
				mapHomeProduct.put(category.getCategory2Id(), categoryProduct);
			}
			model.addAttribute("prodHomePage", mapHomeProduct);
			model.addAttribute("bCrumbDisaled", true);
		} catch (Exception e) {
			return "redirect:/home-page";
		}
		return "home-page";
	}

}