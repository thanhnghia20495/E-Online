$(document)
		.on(
				'ready',
				function() {
					//Carousel One
					var carouselEl_one = $('#owl-1').owlCarousel({
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
					$(".btn-next-1").click(function(e) {
						e.preventDefault()
				        carouselEl_one.trigger('next.owl.carousel');
				    });
				
				    $(".btn-prev-1").click(function(e) {
				    	e.preventDefault()
				        carouselEl_one.trigger('prev.owl.carousel');
				    });
				    //Carousel two
				    var carouselEl_two = $('#owl-2').owlCarousel({
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
					$(".btn-next-2").click(function(e) {
						e.preventDefault()
				        carouselEl_two.trigger('next.owl.carousel');
				    });
				
				    $(".btn-prev-2").click(function(e) {
				    	e.preventDefault()
				        carouselEl_two.trigger('prev.owl.carousel');
				    });
				  //Carousel three
				    var carouselEl_three = $('#owl-3').owlCarousel({
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
					$(".btn-next-3").click(function(e) {
						e.preventDefault()
				        carouselEl_three.trigger('next.owl.carousel');
				    });
				
				    $(".btn-prev-3").click(function(e) {
				    	e.preventDefault()
				        carouselEl_three.trigger('prev.owl.carousel');
				    });
				  //Carousel four
				    var carouselEl_four = $('#owl-4').owlCarousel({
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
					$(".btn-next-4").click(function(e) {
						e.preventDefault()
				        carouselEl_four.trigger('next.owl.carousel');
				    });
				
				    $(".btn-prev-4").click(function(e) {
				    	e.preventDefault()
				        carouselEl_four.trigger('prev.owl.carousel');
				    });
				  //Carousel five
				    var carouselEl_five = $('#owl-5').owlCarousel({
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
					$(".btn-next-5").click(function(e) {
						e.preventDefault()
				        carouselEl_five.trigger('next.owl.carousel');
				    });
				
				    $(".btn-prev-5").click(function(e) {
				    	e.preventDefault()
				        carouselEl_five.trigger('prev.owl.carousel');
				    });
				    
				  //Carousel related product
				    var carouselEl_related = $('#owl-related').owlCarousel({
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
					$(".btn-next-related").click(function(e) {
						e.preventDefault()
				        carouselEl_related.trigger('next.owl.carousel');
				    });
				
				    $(".btn-prev-related").click(function(e) {
				    	e.preventDefault()
				        carouselEl_related.trigger('prev.owl.carousel');
				    });
				    
				  //Carousel Saw product
				    var carouselEl_see = $('#owl-see').owlCarousel({
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
					$(".btn-next-see").click(function(e) {
						e.preventDefault()
				        carouselEl_see.trigger('next.owl.carousel');
				    });
				
				    $(".btn-prev-see").click(function(e) {
				    	e.preventDefault()
				        carouselEl_see.trigger('prev.owl.carousel');
				    });
				});