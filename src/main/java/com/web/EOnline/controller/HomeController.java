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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.web.EOnline.entities.Heights;
import com.web.EOnline.entities.Prices;
import com.web.EOnline.entities.Products;
import com.web.EOnline.entities.Statuses;
import com.web.EOnline.entities.Technologies;
import com.web.EOnline.entities.TradeMarks;
import com.web.EOnline.entities.VAT;
import com.web.EOnline.entities.Weights;
import com.web.EOnline.services.HeightService;
import com.web.EOnline.services.PriceService;
import com.web.EOnline.services.ProductService;
import com.web.EOnline.services.StatusService;
import com.web.EOnline.services.TechnologyService;
import com.web.EOnline.services.TradeMarkService;
import com.web.EOnline.services.VATService;
import com.web.EOnline.services.WeightService;

@Controller
public class HomeController {

	@Autowired
	ProductService prodService;

	@Autowired
	HeightService heightService;

	@Autowired
	WeightService weightService;

	@Autowired
	StatusService statusService;

	@Autowired
	PriceService priceService;
	
	@Autowired
	VATService vatService;
	
	@Autowired
	TradeMarkService tradeMarkService;
	
	@Autowired
	TechnologyService technologyService;

	@GetMapping("simulate-data")
	public String simulateData() {
		VAT vat = new VAT("Giá trên chưa bao gồm thuế VAT");
		vatService.createVAT(vat);
		TradeMarks tradeMarks = new TradeMarks("Hồng Ký");
		tradeMarkService.createTradeMark(tradeMarks);
		Technologies technologies = new Technologies("Đức");
		technologyService.createTechnology(technologies);
		Heights heights = new Heights(61, 1.5f, "1.5m");
		heightService.createHeight(heights);
		Heights heightss = new Heights(62, 2.5f, "2.5m");
		heightService.createHeight(heightss);
		Heights heightsss = new Heights(63, 3.5f, "3.5m");
		heightService.createHeight(heightsss);
		Weights weights = new Weights(51, 150, "150Kg");
		weightService.createWeight(weights);
		Weights weightss = new Weights(52, 250, "250Kg");
		weightService.createWeight(weightss);
		Prices prices = new Prices(41, 0l, 2000000l, "Dưới 2.000.000đ");
		priceService.createPrice(prices);
		Prices pricess = new Prices(42, 2000000l, 5000000l, "2.000.000đ đến 5.000.000đ");
		priceService.createPrice(pricess);
		Prices pricesss = new Prices(43, 5000000l, 0l, "Trên 5.000.000đ");
		priceService.createPrice(pricesss);
		Statuses statuses = new Statuses(1, "Còn hàng");
		statusService.createStatus(statuses);
		Products products1 = new Products();
		products1.setProductCode("T0011");
		products1.setProductName("May Nhôm Rút Chữ A NIKAWA NK-38AI chữ A 1.9m, I 3.8m");
		products1.setGuarantee(12);
		products1.setHeight(heights);
		products1.setWeight(weights);
		products1.setStatus(statuses);
		products1.setPrice(10000000);
		products1.setPercentageDiscount(20);
		products1.setPriceDiscount((products1.getPrice() * (100 - products1.getPercentageDiscount())) / 100);
		products1.setVat(vat);
		products1.setTechnology(technologies);
		products1.setTradeMark(tradeMarks);
		prodService.createProduct(products1);
		Products products = new Products();
		products.setVat(vat);
		products.setTechnology(technologies);
		products.setTradeMark(tradeMarks);
		products.setProductCode("T001");
		products.setProductName("Thang Nhôm Rút Chữ A NIKAWA NK-38AI chữ A 1.9m, I 3.8m");
		products.setGuarantee(12);
		products.setPrice(2000000);
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setHeight(heights);
		products.setWeight(weights);
		products.setStatus(statuses);
		prodService.createProduct(products);
		products.setProductCode("T002");
		prodService.createProduct(products);
		products.setProductCode("T003");
		products.setHeight(heightss);
		products.setWeight(weightss);
		prodService.createProduct(products);
		products.setProductCode("T004");
		prodService.createProduct(products);
		products.setProductCode("T005");
		prodService.createProduct(products);
		products.setProductCode("T006");
		products.setHeight(heightsss);
		products.setWeight(weightss);
		prodService.createProduct(products);
		products.setHeight(heightss);
		products.setWeight(weightss);
		products.setProductCode("T007");
		products.setPrice(5000000);
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		prodService.createProduct(products);
		products.setProductCode("T008");
		products.setPrice(5000000);
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		prodService.createProduct(products);
		products.setProductCode("T009");
		products.setPrice(5000000);
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
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
		model.addAttribute("disabled", "true");
		return "cart-page";
	}

	@GetMapping("contact-page")
	public String contactPage() {
		return "contact-page";
	}

	@GetMapping(value = "category-product-page")
	public String girdSortPage(Model model, @RequestParam("page") Optional<String> page,
			@RequestParam(name="price", defaultValue = "0") int price, @RequestParam(name="height", defaultValue = "0") int height, @RequestParam(name="weight", defaultValue = "0") int weight) {
		System.out.println(price);
		try {
			if (page.orElse(null) == null) {
				return "forward:/category-product-page?page=1";
			}
			final int currentPage = Math.abs(Integer.parseInt(page.orElse("1")));
			final int pageSize = Constants.SIZE_PAGE;
			Page<Products> productPage = prodService
					.findFilterProductPagination(PageRequest.of(currentPage - 1, pageSize), price, height, weight);

			model.addAttribute("productPage", productPage);

			int totalPages = productPage.getTotalPages();
			if (totalPages > 0) {
				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
				model.addAttribute("pageNumbers", pageNumbers);
			}
			List<Prices> listPriceSortAsc = priceService.findAllByOrderByPriceCodeAsc();
			List<Heights> listHeightSortAsc = heightService.findAllByOrderByHeightCodeAsc();
			List<Weights> listWeightSortAsc = weightService.findAllByOrderByWeightCodeAsc();
			model.addAttribute("listPrice", listPriceSortAsc);
			model.addAttribute("listHeight", listHeightSortAsc);
			model.addAttribute("listWeight", listWeightSortAsc);
			model.addAttribute("priceSelected", price);
			model.addAttribute("heightSelected", height);
			model.addAttribute("weightSelected", weight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "grid-page";
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
	public String listProducts(Model model, @RequestParam("page") Optional<String> page) {
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

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> addToCarts(HttpSession session, @RequestParam("id") String productCode) {
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
			return new ResponseEntity<Map<String,Object>>(mapAll,HttpStatus.OK);
			
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