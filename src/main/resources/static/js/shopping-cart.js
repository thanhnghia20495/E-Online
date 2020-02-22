function shoppingCart(idParam) {
										var id = idParam;
										var price = 0;
										var ele_qty =document.getElementById('intLimitTextBox');
										if (ele_qty!==null) {
											var qty = ele_qty.value;
										}else{
											var qty = 1;
										}							
										if (id.length > 0 && typeof id !== 'undefined') {
											if (qty.length == 0) {
												qty = 1;
												document.getElementById('intLimitTextBox').value = 1;
											}
											$
													.ajax({
														url : '/addtocart',
														type : 'post',
														data : {
															id : id,
															qty : qty
														},
														success : function(kq) {
															$(".cart-number")
																	.remove();
															$(".cart-dropdown")
																	.remove();
															$(".header-cart-3")
																	.append(
																			"<a href='/cart-page' class='cart-number'> <i class='ti-shopping-cart'></i>Giỏ hàng <span>"+ getValueByKey(kq,"sizeCartItem") +"</span>"
																					+ "</a>"
																					+ "<ul class='cart-dropdown'></ul>")
													var allItem = getValueByKey(kq,"AllItems");	
													for ( var key in allItem ) {
														price = getValueByKey(allItem,key).products.priceDiscount <= 0 ? getValueByKey(allItem,key).products.price : getValueByKey(allItem,key).products.priceDiscount;
															$(".cart-dropdown")
																	.append(
																			"<li class='single-product-cart'>"
																					+ "<div class='cart-img'>"
																					+ "<a href='#'><img src='assets/img/cart/3.jpg' alt=''></a>"
																					+ "</div>"
																					+ "<div class='cart-title' >"
																					+ "<h5>"
																					+ "<a href='"+'/detail-page?id='+getValueByKey(allItem,key).products.productCode+"'>"+getValueByKey(allItem,key).products.productName+"</a>"
																					+ "</h5>"
																					+ "<span>"+ formatNumber(price) + 'đ' + ' X '+ getValueByKey(allItem,key).quantities + "</span>"
																					+ "</div>"
																					+ "<div class='cart-delete'>"
																					+ "<a href='#' class='"+getValueByKey(allItem,key).products.productCode + ' ' + price + ' ' + getValueByKey(allItem,key).quantities + " removeCart'><i class='ti-trash'></i></a>"
																					+ "</div>"
																					+ "</li>");
													}
															$(".cart-dropdown")
																	.append(
																			"<li class='cart-space'>"
																					+ "<div class='cart-sub'>"
																					+ "<h4>Tổng Tiền</h4>"
																					+ "</div>"
																					+ "<div class='cart-price'>"
																					+ "<h4>" + getValueByKey(kq,"totalPrice") + "</h4>"
																					+ "</div>"
																					+ "</li>"
																					+ "<li class='cart-btn-wrapper'><a class='cart-btn btn-hover'"
																					+ "href='/cart-page'>Xem giỏ hàng</a>"
																					+ "</li>");
															showCartItem();
														}
													});
										} else {
											console.log("hide");
										}
									};

				
				function getValueByKey(object, key) {
						for ( var prop in object) {
							if (prop === key) {
								return object[prop];
							}
						}
					}
				 
				function formatNumber(num) {
					  return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.') +'đ';
					}
				function showCartItem() {
					$(".cart-dropdown").css({
						"visibility" : "visible",
						"opacity" : "1",
						"top" : "100%"
					});
					setInterval(function() {
						$(".cart-dropdown").removeAttr("style");
					}, 5000, 1);
				}
				function updateCartItem(id) {
					var idQty = 'qty-'+id;
					var qty = document.getElementById(idQty).value;
					if (qty==='') {
						qty=1;
					}
					if (id.length > 0) {
						var conf = confirm("Bạn Có Muốn Cập Nhật Số Lượng Sản Phẩm Này Không ?");
						  if (conf == true) {
							  $.ajax({
									url : '/updateCartItem',
									type : 'post',
									data : {
										id : id,
										qty : qty
									},
									success : function(kq) {
										location.reload();
									}
								});
						  }
					} else {
						alert('Error');
					}
				};