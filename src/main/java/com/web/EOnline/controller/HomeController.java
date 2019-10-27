package com.web.EOnline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.EOnline.Utils.Constants;
import com.web.EOnline.Utils.ConvertUtils;
import com.web.EOnline.dto.CartDTO;
import com.web.EOnline.entities.Products;
import com.web.EOnline.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService prodService;

	@GetMapping("simulate-data")
	public String simulateData() {
		Products products1 = new Products();
		products1.setProductCode("T0011");
		products1.setProductName("May Nhôm Rút Chữ A NIKAWA NK-38AI chữ A 1.9m, I 3.8m");
		products1.setGuarantee(12);
		products1.setPrice(2000000);
		prodService.createProduct(products1);
		Products products = new Products();
		products.setProductCode("T001");
		products.setProductName("Thang Nhôm Rút Chữ A NIKAWA NK-38AI chữ A 1.9m, I 3.8m");
		products.setGuarantee(12);
		products.setPrice(2000000);
		products.setPriceDiscount((2000000 * 80) / 100);
		products.setPercentageDiscount(20);
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
		products.setProductCode("T009");
		prodService.createProduct(products);
		return "home-page";
	}

	@GetMapping("detail-page")
	public String detailPage(Model model, @RequestParam("id") String productCode) {

		Products products = prodService.findProductById(productCode);
		model.addAttribute("product", products);
		return "detail-page";
	}

	@GetMapping("cart-page")
	public String cartPage(Model model) {
		model.addAttribute("disabled","true");
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
			l.add("<div class= 'des_autocomplete'>Tìm thấy " + listProduct.size() + " sản phẩm</div>");
			for (Products p : prodService.findByProductNameContainingIgnoreCase(keyword)) {
				l.add("<li><a href='#'> <img alt='' src='https://thietbikhangan.vn/upload/sanpham/may_phun_xit_rua_ap_luc_cao_bosch_advanced-aquatak_140-8099.jpg'> "
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

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCarts(HttpSession session, @RequestParam("id") String productCode) {
		@SuppressWarnings("unchecked")
		Map<String, CartDTO> items = (HashMap<String, CartDTO>) session.getAttribute("cartItem");
		Map<String, Object> mapAll = new HashMap<String, Object>();
		if (items == null) {
			items = new HashMap<String, CartDTO>();
		}
		Products product = prodService.findProductById(productCode);
		if (product != null) {
			if (items.containsKey(productCode)) {
				CartDTO cartItem = items.get(productCode);
				cartItem.setQuantities(cartItem.getQuantities() + 1);
			} else {
				CartDTO cartDTO = new CartDTO(product, 1);
				items.put(productCode, cartDTO);
			}
			session.setAttribute("cartItem", items);
			session.setAttribute("totalPrice", totalPrice(items));
			session.setAttribute("sizeCartItem", items.size());
		}
		mapAll.put("AllItems", items);
		mapAll.put("totalPrice", ConvertUtils.convertFormatPrice((long) (totalPrice(items))));
		mapAll.put("sizeCartItem", items.size());
		return ResponseEntity.ok().body(mapAll);
	}

	@RequestMapping(value = "/removeCartItem", method = RequestMethod.POST)
	public ResponseEntity<String> removeCarts(HttpSession session, @RequestParam("id") String productCode) {
		@SuppressWarnings("unchecked")
		Map<String, CartDTO> items = (HashMap<String, CartDTO>) session.getAttribute("cartItem");
		if (items == null) {
			items = new HashMap<String, CartDTO>();
		}
		if (items.containsKey(productCode)) {
			items.remove(productCode);
		}
		session.setAttribute("cartItem", items);
		session.setAttribute("totalPrice", totalPrice(items));
		session.setAttribute("sizeCartItem", items.size());

		return ResponseEntity.ok().body("success");
	}

	public double totalPrice(Map<String, CartDTO> items) {
		double total = 0.0;
		for (Entry<String, CartDTO> cartItem : items.entrySet()) {
			if (cartItem.getValue().getProducts().getPriceDiscount() > 0) {
				total += cartItem.getValue().getProducts().getPriceDiscount() * cartItem.getValue().getQuantities();
			} else {
				total += cartItem.getValue().getProducts().getPrice() * cartItem.getValue().getQuantities();
			}
		}
		return total;
	}
}