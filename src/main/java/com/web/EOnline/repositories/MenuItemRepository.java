package com.web.EOnline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.EOnline.entities.MenuItems;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItems, Integer> {
	MenuItems findByMenuId(int menuId);

	public List<MenuItems> findAllByOrderByOrderAsc();
	
	@Query(value = "SELECT m.* FROM ecom_owner.products p, ecom_owner.menu_item m ,ecom_owner.category_1 c1, ecom_owner.category_2 c2 "
			+ "where 1=1 "
			+ "and m.menu_id = c1.menu_id "
			+ "and c2.category1_id = c1.category1_id "
			+ "and p.category2_id = c2.category2_id "
			+ "and p.product_code = :product_code ", nativeQuery = true)
	public MenuItems findMenuItemByProductCode(@Param("product_code") String productCode);
}
