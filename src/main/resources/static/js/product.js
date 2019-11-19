$(document)
		.on(
				'ready',
				function() {
					$(".regular").slick({
						autoplay : true,
						autoplaySpeed : 1000,
						dots : true,
						infinite : true,
						speed : 1000,
						fade : false,
						slide : 'div',
						cssEase : 'linear',
						pauseOnFocus : false,
						pauseOnHover : false,
						pauseOnDotsHover : false,
						slidesToShow : 6,
						slidesToScroll : 1,
					});

					var menu = $('.header-top');
					var origOffsetY = menu.offset();
					// console.log(origOffsetY);
					function scroll() {
						if ($(window).scrollTop() >= origOffsetY) {
							// $('.categori-menu-wrapper2').removeClass("header-fixed");
							// console.log("top");
						} else {
							// console.log("down");
							// $('.categori-menu-wrapper2').addClass("header-fixed");
						}
					}
					
					 var shrinkHeader = 143;
					  $(window).scroll(function() {
					    var scroll = getCurrentScroll();
					      if ( scroll >= shrinkHeader ) {
					    	    $('.categori-menu-wrapper2').addClass("header-fixed");
					    	    $('.menu-style-4 nav ul').css('margin','10px');
					    	    $('.category-heading-2').removeClass("category-left-1");
					    	    $('.category-heading-2').addClass("category-left-fixed");
					        }
					        else {
					        	$('.category-heading-2').addClass("category-left-1");
							    $('.category-heading-2').removeClass("category-left-fixed");
							    $('.categori-menu-wrapper2').removeClass("header-fixed");
							    $('.menu-style-4 nav ul').css('margin','0px');
					        }
					  });
					function getCurrentScroll() {
					    return window.pageYOffset || document.documentElement.scrollTop;
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
					document.onscroll = scroll;
					/* Remove cart row on cart page */
					$('.header-cart-3').on('click', '.removeCart', function(e) {
						e.preventDefault();
						$(this).closest('.single-product-cart').remove();
					});
					
					/* Remove cart row on cart page */
					$('#cart-row').on('click', 'tr a', function(e) {
						e.preventDefault();
						$(this).closest('tr').remove();
					});
					
					/* Placeholder Typewriter */
					var srtSuggesstSearch = $('#suggestSearch').val();
					var placeholderText = srtSuggesstSearch.split(';');
					$('#search').placeholderTypewriter({
						text : placeholderText
					});
					/* auto complete */
					$("#search").keyup(function(event) {
						var dulieu = $(this).val();
						if (dulieu.length > 0) {
							$(".search-list").show();
							console.log("show")
							$.ajax({
								url : '/autocomplete',
								type : 'post',
								data : {
									keyword : dulieu
								},
								success : function(kq) {
									console.log(kq);
									$(".search-list>ul").html(kq);
								}
							});
						} else {
							$(".search-list").hide();
							console.log("hide")
						}
					});
					
					/* remove cart */
// $(".removeCart").click(function(e) {
					$(".header-cart-3").on("click", ".removeCart",function(e) {
						e.preventDefault()
						var arrId = $(this).attr('class').split(' ');
						var id = arrId[0];
						var price = arrId[1];
						var qty = arrId[2];
						var total = $('.cart-price h4').text().replace('đ','').replace(/\./g,'');
						var calTotal = 0;
						console.log(total);
						console.log(price);
						var sizeCart = $(".cart-number span").text();
						if (id.length > 0) {
							$.ajax({
								url : '/removeCartItem',
								type : 'post',
								data : {
									id : id
								},
								success : function(kq) {
									calTotal = total - price*qty;
									$(".cart-number span").text(sizeCart -1);
									$('.cart-price h4').text(formatNumber(calTotal));
								}
							});
						} else {
							console.log("hide");
						}
					});
					
					$("#cart-row").on("click", ".removeCart",function(e) {
						e.preventDefault()
						var arrId = $(this).attr('class').split(' ');
						var id = arrId[0];
						if (id.length > 0) {
							var conf = confirm("Bạn Có Muốn Xoá Sản Phẩm Này Không ?");
							  if (conf == true) {
								  $.ajax({
										url : '/removeCartItem',
										type : 'post',
										data : {
											id : id
										},
										success : function(kq) {
											location.reload();
										}
									});
							  }
						} else {
							alert('Error');
						}
					});
					
					/* add to cart */
					$("#addToCart")
							.click(
									function(e) {
										e.preventDefault()
										var id = $("#productCode").html();
										var price = 0;
										if (id.length > 0) {
											$
													.ajax({
														url : '/addtocart',
														type : 'post',
														data : {
															id : id
														},
														success : function(kq) {
															console.log(kq)
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
																					+ "<a href='#'>"+getValueByKey(allItem,key).products.productName+"</a>"
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
																					+ "href='#'>Xem giỏ hàng</a> <a class='cart-btn btn-hover' href='#'>Thanh toán</a>"
																					+ "</li>");
															showCartItem();
														}
													});
										} else {
											console.log("hide");
										}
									});

					

				function getValueByKey(object, key) {
						for ( var prop in object) {
							if (prop === key) {
								return object[prop];
							}
						}
					}
				 var carouselEl = $('.owl-carousel').owlCarousel({
					rewind:true,
				    items: 1,
				    margin:10,
				    nav:true,
				    singleItem: true,
				    responsive:{
				        0:{
				            items:2
				        },
				        600:{
				            items:3
				        },
				        1000:{
				            items:5
				        }
				    }
				})
				$(".btn-next").click(function(e) {
					e.preventDefault()
			        carouselEl.trigger('next.owl.carousel');
			    });
			
			    $(".btn-prev").click(function(e) {
			    	e.preventDefault()
			        carouselEl.trigger('prev.owl.carousel');
			    });
				function formatNumber(num) {
					  return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.') +'đ';
					}	
				
				function addFilterProduct(price, height , weight) {
					var str='/category-product-page?';
					if(typeof price !== 'undefined'){
						console.log('price'+ price);
						str = str +'&price='+price;
                		}
					if(typeof height !== 'undefined'){
						console.log('height'+ height);
						str = str +'&height='+height;
                		}
					if(typeof weight !== 'undefined'){
						console.log('weight'+ weight);
						str = str +'&weight='+weight;
	            		}
					return str;
				}
				
				function getUrlVars() {
				    var vars = {};
				    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
				        vars[key] = value;
				    });
				    return vars;
				}
				
				$(function(){
					console.log(getUrlVars());
					
					 var price = getUrlVars()["price"];
					 var height = getUrlVars()["height"];
					 var weight = getUrlVars()["weight"];
					 console.log("price height weight: "+ price +" - "+ height +" - "+ weight);
	                $("#price_sort").change(function(e){
	                	price =$('#price_sort option:selected').val();
	                	//console.log(addFilterProduct(price, height, weight));
	                	document.location.href = addFilterProduct(price, height, weight);
	                });
	                $("#height_sort").change(function(e){
	                	height =$('#height_sort option:selected').val();
	                	document.location.href = addFilterProduct(price, height, weight);
	                });
	                $("#weight_sort").change(function(e){
	                	weight =$('#weight_sort option:selected').val();
	                	document.location.href = addFilterProduct(price, height, weight);
                
	                });
	                
	            });

});

				