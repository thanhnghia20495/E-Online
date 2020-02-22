package com.web.EOnline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.web.EOnline.Utils.Constants;
import com.web.EOnline.Utils.ConvertUtils;
import com.web.EOnline.dto.CartDTO;
import com.web.EOnline.dto.Category2Product;
import com.web.EOnline.dto.MessageError;
import com.web.EOnline.entities.Bills;
import com.web.EOnline.entities.Category1;
import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Heights;
import com.web.EOnline.entities.MenuItems;
import com.web.EOnline.entities.Prices;
import com.web.EOnline.entities.Products;
import com.web.EOnline.entities.Weights;
import com.web.EOnline.services.BillingMethodService;
import com.web.EOnline.services.Category1Service;
import com.web.EOnline.services.Category2Service;
import com.web.EOnline.services.HeightService;
import com.web.EOnline.services.MenuItemService;
import com.web.EOnline.services.PriceService;
import com.web.EOnline.services.ProductService;
import com.web.EOnline.services.WeightService;

@Controller
public class ShoppingCartController {

	@Autowired
	ProductService prodService;

	@Autowired
	HeightService heightService;

	@Autowired
	WeightService weightService;

	@Autowired
	PriceService priceService;

	@Autowired
	BillingMethodService billingMethodService;

	@Autowired
	Category2Service category2Service;

	@Autowired
	Category1Service category1Service;
	
	@Autowired
	MenuItemService menuItemService;
	
	@GetMapping("/cart-page")
	public String cartPage(Model model) {
		model.addAttribute("disabled", "true");
		model.addAttribute("bills", new Bills());
		model.addAttribute("messageError", new MessageError());
		model.addAttribute("billingMethods", billingMethodService.findAllBillingMethod());
		return "cart-page";
	}

	@GetMapping(value = "/category-product-page")
	public String girdSortPage(HttpServletRequest request ,Model model, @RequestParam(value = "page", defaultValue = "1") Optional<String> page,
			@RequestParam(name = "current", defaultValue = "", required = false) String current,
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			@RequestParam(name = "price", defaultValue = "0") int price,
			@RequestParam(name = "height", defaultValue = "0") int height,
			@RequestParam(name = "weight", defaultValue = "0") int weight,
			@RequestParam(name = "category", defaultValue = "0") int category,
			@RequestParam(name = "trading", defaultValue = "0") int trading) {
		try {
			final int currentPage = Math.abs(Integer.parseInt(page.orElse("1")));
			final int pageSize = Constants.SIZE_PAGE;
			Page<Products> productPage = prodService.findFilterProductPagination(
					PageRequest.of(currentPage - 1, pageSize), keyword, price, height, weight, trading, category);

			model.addAttribute("productPage", productPage);

			int totalPages = productPage.getTotalPages();
			if (totalPages > 0) {
				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
				model.addAttribute("pageNumbers", pageNumbers);
			}
			List<Prices> listPriceSortAsc = priceService.findAllByOrderByPriceCodeAsc();
			List<Heights> listHeightSortAsc = heightService.findAllByOrderByHeightCodeAsc();
			List<Weights> listWeightSortAsc = weightService.findAllByOrderByWeightCodeAsc();
			List<Category1> lisCategory1 = category1Service.findAllCategory1();
			List<Category2> listCategory2 = category2Service.findAllCategory2();
			Map<Integer, Category2Product> mapCategoryProduct = new HashMap<Integer, Category2Product>();
			for (Category2 category2 : listCategory2) {
				List<Products> sizeProduct = prodService.findByCategory2(category2);
				mapCategoryProduct.put(category2.getCategory2Id(), new Category2Product(category2, sizeProduct.size()));
			}
			Category2 category2 = category2Service.findCategoryById(category);
			Category1 category1 = null; 
			MenuItems menuItem  = null; 
			String titleProd ="Tất cả sản phẩm";
			if (category2!=null) {
				category1 = category1Service.findCategoryById(category2.getCategory1().getCategory1Id());
				titleProd = category2.getDescription();
			}else {
				category1 = category1Service.findCategoryById(trading);
			}
			if (category1 !=null) {
				menuItem = menuItemService.findMenuItemById(category1.getMenuItems().getMenuId());
				titleProd = category1.getDescription();
			}else {
				menuItem = menuItemService.findMenuItemById(1);
				model.addAttribute("allProduct", "true");
			}
			List<Products> prodSee = new ArrayList<Products>();
			Cookie cookie = WebUtils.getCookie(request, "_prodSee");
			if (cookie !=null) {
				String[] prodCode = cookie.getValue().replace(" ", "").split("-");
				for (int i = 0; i < prodCode.length; i++) {
					Products product = prodService.findProductById(prodCode[i]);
					if (product != null) {
						prodSee.add(product);
					}
				}
			}
			String params = ConvertUtils.currentHerf(keyword, price, height, weight, category, trading);
			model.addAttribute("paramURI", params);
			model.addAttribute("listPrice", listPriceSortAsc);
			model.addAttribute("listHeight", listHeightSortAsc);
			model.addAttribute("listWeight", listWeightSortAsc);
			model.addAttribute("page", page.get());
			model.addAttribute("Nextpage", Integer.valueOf(page.get()) + 1);
			model.addAttribute("Backpage", Integer.valueOf(page.get()) - 1);
			model.addAttribute("priceSelected", price);
			model.addAttribute("heightSelected", height);
			model.addAttribute("weightSelected", weight);
			model.addAttribute("categorySelected", category);
			model.addAttribute("category1Product", lisCategory1);
			model.addAttribute("category2Product", mapCategoryProduct);
			model.addAttribute("category", category2);
			model.addAttribute("trading", category1);
	 		model.addAttribute("menuItem", menuItem);
	 		model.addAttribute("titleProd", titleProd.toUpperCase());
	 		model.addAttribute("prodSee", prodSee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "grid-page";
	}

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> addToCarts(HttpSession session, @RequestParam("id") String productCode,
			@RequestParam("qty") int qty) {
		try {
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
					cartItem.setQuantities(cartItem.getQuantities() + qty);
				} else {
					CartDTO cartDTO = new CartDTO(product, qty);
					items.put(productCode, cartDTO);
				}
				session.setAttribute("cartItem", items);
				session.setAttribute("totalPrice", totalPrice(items));
				session.setAttribute("sizeCartItem", items.size());
			}
			mapAll.put("AllItems", items);
			mapAll.put("totalPrice", ConvertUtils.convertFormatPrice((long) (totalPrice(items))));
			mapAll.put("sizeCartItem", items.size());
			return new ResponseEntity<Map<String, Object>>(mapAll, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

	@RequestMapping(value = "/updateCartItem", method = RequestMethod.POST)
	public ResponseEntity<String> updateCarts(HttpSession session, @RequestParam("id") String productCode,
			@RequestParam("qty") int qty) {
		@SuppressWarnings("unchecked")
		Map<String, CartDTO> items = (HashMap<String, CartDTO>) session.getAttribute("cartItem");
		if (items == null) {
			items = new HashMap<String, CartDTO>();
		}
		if (items.containsKey(productCode)) {
			CartDTO cartItem = items.get(productCode);
			cartItem.setQuantities(qty);
		}
		session.setAttribute("cartItem", items);
		session.setAttribute("totalPrice", totalPrice(items));
		session.setAttribute("sizeCartItem", items.size());

		return ResponseEntity.ok().body("success");
	}

	public long totalPrice(Map<String, CartDTO> items) {
		long total = 0;
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