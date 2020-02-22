package com.web.EOnline.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.web.EOnline.Utils.Constants;
import com.web.EOnline.Utils.ConvertUtils;
import com.web.EOnline.entities.BillingMethods;
import com.web.EOnline.entities.Category1;
import com.web.EOnline.entities.Category2;
import com.web.EOnline.entities.Contacts;
import com.web.EOnline.entities.Heights;
import com.web.EOnline.entities.Keywords;
import com.web.EOnline.entities.MenuItems;
import com.web.EOnline.entities.Prices;
import com.web.EOnline.entities.Products;
import com.web.EOnline.entities.Scripts;
import com.web.EOnline.entities.SocialLinks;
import com.web.EOnline.entities.Statuses;
import com.web.EOnline.entities.Technologies;
import com.web.EOnline.entities.TelePhones;
import com.web.EOnline.entities.TradeMarks;
import com.web.EOnline.entities.VAT;
import com.web.EOnline.entities.Weights;
import com.web.EOnline.entities.Youtube;
import com.web.EOnline.services.BillingMethodService;
import com.web.EOnline.services.Category1Service;
import com.web.EOnline.services.Category2Service;
import com.web.EOnline.services.ContactService;
import com.web.EOnline.services.HeightService;
import com.web.EOnline.services.KeyWordService;
import com.web.EOnline.services.MenuItemService;
import com.web.EOnline.services.PriceService;
import com.web.EOnline.services.ProductService;
import com.web.EOnline.services.ScriptService;
import com.web.EOnline.services.SocialLinksService;
import com.web.EOnline.services.StatusService;
import com.web.EOnline.services.TechnologyService;
import com.web.EOnline.services.TelephoneService;
import com.web.EOnline.services.TradeMarkService;
import com.web.EOnline.services.VATService;
import com.web.EOnline.services.WeightService;
import com.web.EOnline.services.YoutubeService;

@Controller
public class ProductController {

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

	@Autowired
	BillingMethodService billingMethodService;

	@Autowired
	MenuItemService menuItemService;

	@Autowired
	Category1Service category1Service;

	@Autowired
	Category2Service category2Service;

	@Autowired
	TelephoneService telephoneService;

	@Autowired
	ContactService contactService;

	@Autowired
	KeyWordService keyWordService;

	@Autowired
	ScriptService scriptService;

	@Autowired
	SocialLinksService socialLinksService;

	@Autowired
	YoutubeService youtubeService;

	@GetMapping("simulate-data")
	public String simulateData() {

		Youtube youtube = new Youtube("WelCome", "4LB5OE6f8zk&t=6s");
		youtubeService.createYoutube(youtube);
		MenuItems menuItems = new MenuItems("/home-page", "Trang chủ", 1);
		menuItemService.createMenuItem(menuItems);
		MenuItems menuItems1 = new MenuItems("#", "Giới thiệu", 2);
		menuItemService.createMenuItem(menuItems1);
		MenuItems menuItems2 = new MenuItems("#", "Dịch vụ", 3);
		menuItemService.createMenuItem(menuItems2);
		MenuItems menuItems3 = new MenuItems("#", "Tin tức", 4);
		menuItemService.createMenuItem(menuItems3);
		MenuItems menuItems4 = new MenuItems("/contact-page", "Liên hệ", 5);
		menuItemService.createMenuItem(menuItems4);
		Category1 category1 = new Category1("/category-product-page", "Thang nhôm Ameca", 1, menuItems);
		category1Service.createCategory1(category1);
		Category1 category11 = new Category1("/category-product-page", "Thang Nhôm HYUNDAI", 2, menuItems);
		category1Service.createCategory1(category11);
		Category1 category12 = new Category1("/category-product-page", "Thang Nhôm UNIGAWA", 3, menuItems);
		category1Service.createCategory1(category12);
		Category2 category2 = new Category2("/category-product-page", "Thang Nhôm Chữ A", 1, "Y", category1);
		category2Service.createCategory2(category2);
		Category2 category21 = new Category2("/category-product-page", "Thang Nhôm Chữ B", 2, "Y", category1);
		category2Service.createCategory2(category21);
		Category2 category22 = new Category2("/category-product-page", "Thang Nhôm Chữ C", 3, "Y", category12);
		category2Service.createCategory2(category22);
		Category2 category23 = new Category2("/category-product-page", "Thang Nhôm Chữ D", 4, "N", category11);
		category2Service.createCategory2(category23);
		BillingMethods billingMethods = new BillingMethods("Chuyển khoản");
		BillingMethods billingMethodss = new BillingMethods("Tiền mặt");
		billingMethodService.createBillingMethod(billingMethods);
		billingMethodService.createBillingMethod(billingMethodss);
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
		products1.setDescription(
				"Máy Hàn Điện Tử Hồng Ký SR 200R Cam Kết Chính Hãng. Nhanh	Tay Đặt Hàng Ngay Để Được Gía Tốt, Tư Vấn Tận Tình Bảo Hành	Chuyên Nghiệp");
		products1.setPercentageDiscount(20);
		products1.setPriceDiscount((products1.getPrice() * (100 - products1.getPercentageDiscount())) / 100);
		products1.setVat(vat);
		products1.setTechnology(technologies);
		products1.setTradeMark(tradeMarks);
		products1.setOptionBestSelling("Y");
		products1.setCategory2(category21);
		prodService.createProduct(products1);
		Products products = new Products();
		products.setVat(vat);
		products.setTechnology(technologies);
		products.setTradeMark(tradeMarks);
		products.setProductCode("T001");
		products.setProductName("Thang Nhôm Rút Chữ A NIKAWA NK-38AI chữ A 1.9m, I 3.8m");
		products.setGuarantee(12);
		products.setPrice(2000000);
		products.setDescription(
				"Máy Hàn Điện Tử Hồng Ký SR 200R Cam Kết Chính Hãng. Nhanh	Tay Đặt Hàng Ngay Để Được Gía Tốt, Tư Vấn Tận Tình Bảo Hành	Chuyên Nghiệp");
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setHeight(heights);
		products.setWeight(weights);
		products.setStatus(statuses);
		products.setOptionBestSelling("Y");
		products.setCategory2(category22);
		prodService.createProduct(products);
		products.setProductCode("T002");
		products.setOptionBestSelling("Y");
		prodService.createProduct(products);
		products.setProductCode("T055");
		products.setOptionBestSelling("Y");
		prodService.createProduct(products);
		products.setProductCode("T003");
		products.setHeight(heightss);
		products.setWeight(weightss);
		products.setOptionBestSelling("Y");
		products.setCategory2(category23);
		prodService.createProduct(products);
		products.setProductCode("T004");
		products.setOptionBestSelling("Y");
		products.setCategory2(category23);
		prodService.createProduct(products);
		products.setProductCode("T005");
		products.setOptionBestSelling("Y");
		products.setCategory2(category2);
		prodService.createProduct(products);
		products.setProductCode("T006");
		products.setHeight(heightsss);
		products.setWeight(weightss);
		products.setOptionBestSelling("Y");
		products.setCategory2(category22);
		prodService.createProduct(products);
		products.setHeight(heightss);
		products.setWeight(weightss);
		products.setOptionBestSelling("Y");
		products.setCategory2(category21);
		products.setProductCode("T007");
		products.setPrice(5000000);
		products.setPercentageDiscount(20);
		products.setOptionBestSelling("Y");
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category21);
		prodService.createProduct(products);
		products.setProductCode("T008");
		products.setPrice(5000000);
		products.setOptionBestSelling("Y");
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category21);
		prodService.createProduct(products);
		products.setProductCode("T009");
		products.setPrice(5000000);
		products.setPercentageDiscount(20);
		products.setOptionBestSelling("Y");
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category2);
		prodService.createProduct(products);
		products.setProductCode("T010");
		products.setPrice(5000000);
		products.setOptionBestSelling("Y");
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category2);
		prodService.createProduct(products);
		products.setProductCode("T011");
		products.setOptionBestSelling("Y");
		products.setPrice(5000000);
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category2);
		prodService.createProduct(products);
		products.setProductCode("T012");
		products.setPrice(5000000);
		products.setOptionBestSelling("Y");
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category2);
		prodService.createProduct(products);
		products.setProductCode("T013");
		products.setPrice(5000000);
		products.setOptionBestSelling("Y");
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category2);
		prodService.createProduct(products);
		products.setProductCode("T014");
		products.setPrice(10000000);
		products.setProductName("NonYoutube");
		products.setOptionBestSelling("N");
		products.setPercentageDiscount(20);
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setYoutube(youtube);
		products.setOptionYoutube("N");
		products.setCategory2(category2);
		prodService.createProduct(products);
		products.setProductCode("T015");
		products.setPrice(10000000);
		products.setOptionBestSelling("N");
		products.setPercentageDiscount(20);
		products.setYoutube(youtube);
		products.setProductName("Youtube");
		products.setOptionYoutube("Y");
		products.setPriceDiscount((products.getPrice() * (100 - products.getPercentageDiscount())) / 100);
		products.setCategory2(category2);
		prodService.createProduct(products);
		Contacts contact = new Contacts("info@thietbikhangan.vn",
				"Số 4, Đường 17, Khu Phố 5, P. Linh tây, Q. Thủ Đức, TP.HCM");
		contactService.createContact(contact);
		TelePhones telePhones = new TelePhones("0989231172", contact, "N");
		telephoneService.createTelephone(telePhones);
		TelePhones telePhones1 = new TelePhones("0989231173", contact, "Y");
		telephoneService.createTelephone(telePhones1);
		Scripts script = new Scripts("Google Map", "<div class=\"mapouter\">\n"
				+ "							<div class=\"gmap_canvas\">\n"
				+ "								<iframe width=\"1370\" height=\"540\" id=\"gmap_canvas\"\n"
				+ "									src=\"https://maps.google.com/maps?q=CTY%20TNHH%20TM%20DV%20QU%E1%BB%90C%20KHANG%20AN&t=&z=13&ie=UTF8&iwloc=&output=embed\"\n"
				+ "									frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\"></iframe>\n"
				+ "							</div>\n" + "							<style>\n" + ".mapouter {\n"
				+ "	position: relative;\n" + "	text-align: right;\n" + "	height: auto;\n" + "	width: auto;\n"
				+ "}\n" + "\n" + ".gmap_canvas {\n" + "	overflow: hidden;\n" + "	background: none !important;\n"
				+ "	height: auto;\n" + "	width: auto;\n" + "}\n" + "</style>\n" + "						</div>");
		scriptService.createScript(script);
		Keywords keyword = new Keywords("Máy cắt sắt Dewalt BẢO HÀNH 3 NĂM; Máy rửa xe mini giá rẻ; Máy cắt sắt", "N");
		Keywords keyword2 = new Keywords("giá chỉ 1tr 750 Thang nhôm chữ A", "Y");
		Keywords keyword3 = new Keywords("giá chỉ 899.000đ Thang nhôm rút gọn", "Y");
		Keywords keyword4 = new Keywords("giá chỉ 1tr 479 Thang ghế ", "Y");
		keyWordService.createKeyWord(keyword);
		keyWordService.createKeyWord(keyword2);
		keyWordService.createKeyWord(keyword3);
		keyWordService.createKeyWord(keyword4);
		SocialLinks link1 = new SocialLinks("Facebook", "https://www.facebook.com/quocnguyen.w");
		SocialLinks link2 = new SocialLinks("Youtube", "https://www.youtube.com/channel/UCePxvwuYpMqFYtz33rG_q8g");
		socialLinksService.createSocialLinks(link1);
		socialLinksService.createSocialLinks(link2);

		return "contact-page";
	}

	@GetMapping("detail-page")
	public String detailPage(HttpServletResponse response, HttpServletRequest request, Model model,
			@RequestParam("id") String productCode) {
		Products product = prodService.findProductById(productCode);
		product.setViews(product.getViews() + 1);
		prodService.createProduct(product);
		Category2 category2 = category2Service.findCategoryById(product.getCategory2().getCategory2Id());
		Category1 category1 = category1Service.findCategoryById(product.getCategory2().getCategory1().getCategory1Id());
		MenuItems menuItem = menuItemService.findMenuItemById(category1.getMenuItems().getMenuId());
		Cookie cookie = WebUtils.getCookie(request, "_prodSee");
		String srtCookie = "";
		if (cookie == null) {
			cookie = new Cookie("_prodSee", product.getProductCode());
			cookie.setMaxAge(24 * 60 * 60); // expires in 1 days
			cookie.setPath("/");
		} else {
			srtCookie = cookie.getValue().toString();
			if (!srtCookie.contains(product.getProductCode())) {
				srtCookie = srtCookie.trim() + "-" + product.getProductCode().trim();
			}
			cookie.setValue(srtCookie.toString().trim());
		}

		response.addCookie(cookie);

		List<Products> prodRelated = prodService.findByCategory2AndOptionBestSelling("Y", category2.getCategory2Id());
		SocialLinks fb = socialLinksService.findSocialLinksByDescription(Constants.FACEBOOK);
		SocialLinks youtube = socialLinksService.findSocialLinksByDescription(Constants.YOUTUBE);
		model.addAttribute("category", category2);
		model.addAttribute("trading", category1);
		model.addAttribute("menuItem", menuItem);
		model.addAttribute("product", product);
		model.addAttribute("prodRelated", prodRelated);
		model.addAttribute("fb", fb);
		model.addAttribute("youtube", youtube);
		return "detail-page";
	}
	@RequestMapping(value = "qrcode/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ConvertUtils.getQRCodeImage(id, 400, 400));
		outputStream.flush();
		outputStream.close();
	}
}