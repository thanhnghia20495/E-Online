package com.web.EOnline.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.EOnline.Utils.Constants;
import com.web.EOnline.entities.Products;
import com.web.EOnline.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService prodService;

	@GetMapping("simulate-data")
	public String simulateData() {
		Products products = new Products();
		products.setProductCode("T001");
		products.setProductName("Thang Nhôm Rút Chữ A NIKAWA NK-38AI chữ A 1.9m, I 3.8m");
		products.setGuarantee(12);
		products.setPrice(2000000);
		products.setPriceDiscount(20);
		products.setPercentageDiscount((2000000 * 80) / 100);
		prodService.createProduct(products);
		products.setProductCode("T002");
		prodService.createProduct(products);
		products.setProductCode("T003");
		prodService.createProduct(products);
		products.setProductCode("T004");
		prodService.createProduct(products);
		products.setProductCode("T005");
		prodService.createProduct(products);
		products.setProductCode("T006");
		prodService.createProduct(products);
		products.setProductCode("T007");
		prodService.createProduct(products);
		products.setProductCode("T008");
		prodService.createProduct(products);
		return "home-page";
	}

	@GetMapping("detail-page")
	public String detailPage() {

		Products products = prodService.findProductById("T001");
		products.setProductName("KaKo");
		prodService.updateProduct(products);
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

	@RequestMapping(value = "autocomplete", method = RequestMethod.POST)
	@ResponseBody
	public List<String> autoComplete(@RequestParam("keyword") String keyword) {
		List<String> l = new ArrayList<String>();
		List<Products> listProduct = prodService.findByProductNameContainingIgnoreCase(keyword);
		if (!listProduct.isEmpty()) {
			l = new ArrayList<String>();
			l.add("<span>Tim Thay " + listProduct.size() + " San Pham</span>");
			l.add("<ul>");
			for (Products p : prodService.findByProductNameContainingIgnoreCase(keyword)) {
				l.add("<li><a>" + p.getProductName() + "</a></li>");
			}
			l.add("</ul>");
		} else {
			l.add("<ul><li>Không tìm thấy sản phẩm nào :(</li></ul>");
		}

		return l;
	}

	@RequestMapping(value = "/home-page", method = RequestMethod.GET)
	public String listBooks(Model model, @RequestParam("page") Optional<String> page) {
		try {
			if (page.orElse(null) == null) {
				return "forward:/home-page?page=1";
			}
			final int currentPage = Math.abs(Integer.parseInt(page.orElse("1")));
			final int pageSize = Constants.SIZE_PAGE;
			Page<Products> productPage = prodService
					.findAllProductPagination(PageRequest.of(currentPage - 1, pageSize));

			model.addAttribute("productPage", productPage);

			int totalPages = productPage.getTotalPages();
			if (totalPages > 0) {
				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
				model.addAttribute("pageNumbers", pageNumbers);
			}
		} catch (Exception e) {
			return "redirect:/home-page";
		}
		return "home-page";
	}
}
