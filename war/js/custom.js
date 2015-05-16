			
/*
 * ScrollTo plugins
 */
 
jQuery(function( $ ){
	$('.scroll-link').click(function(){
		var section = $($(this).data("to"));
		var top = section.offset().top;
		$("html, body").animate({ scrollTop: top }, 1000);

		if($(window).width() < 768){
			var $navMain = $(".navbar-collapse");
			$navMain.collapse('hide');
		}
		return false;
	});
});
			
/* Side bar animation JS */

$(document).ready(function(){
	if($(window).width() <= 767){
		$("#page_sidebar").removeClass("open");
	}
	else{
		$("#page_sidebar").addClass("open");
	}
		
	$(window).resize(function(){
		if($(window).width() <= 767){
			$("#page_sidebar").animate({left:"-281px"});
			$("#page_sidebar").removeClass("open");
		}
		else{
			$("#page_sidebar").animate({left:"0px"});
			$("#page_sidebar").addClass("open");
		}
	});

	$(".navi-btn a").click(function(e){
		e.preventDefault();
		var button = $(".navi-btn a");
		var side_bar = $("#page_sidebar");
		var main_bar = $(".mainbar");
	
		if(side_bar.hasClass("open")){
			side_bar.animate({left:"-281px"});
			side_bar.removeClass("open");
			
			if($(window).width() >= 767){
				main_bar.css("margin-left","0px");
			}
		}
		else{
			side_bar.animate({left:"0"});
			side_bar.addClass("open");
			
			if($(window).width() >= 767){
				main_bar.css("margin-left","280px");
			}
		}
	});
});

/* Side bar sub menu JS */

$(document).ready(function(){
	$(".has_submenu > a").click(function(e){
		e.preventDefault();
		var menu_li = $(this).parent("li");
		var menu_ul = $(this).next("ul");

		if(menu_li.hasClass("open")){
			menu_ul.slideUp(350);
			menu_li.removeClass("open")
		}
		else{
			$(".navi > li > ul").slideUp(350);
			$(".navi > li").removeClass("open");
			menu_ul.slideDown(350);
			menu_li.addClass("open");
		}
	});
});

/* Light box gallery JS */

$(document).ready(function() {
	$('.light-box').magnificPopup({
		delegate: 'a', 
		type: 'image',
		mainClass: 'mfp-with-zoom',
		zoom: {
			enabled: true,
			duration: 300
		}
	});
});

// Testimonial JS
			
$(window).load(function(){
	$('.flexslider-testimonial').flexslider({
		animation: 		"fade",
		slideshowSpeed:	5000,
		animationSpeed:	1000,
		controlNav:		true,
		directionNav:	false
	});
});

/* GMAP JS */

$('#my_map').gMap({
	zoom: 15,
	markers:[
		{
			address: "#397, Good City Road, Bangalore",
			html: "<h5>Site Name</h5><p>#397, Good City Road<br />, Bangalore<br />Karnataka - 625003</p>",
			popup: true
		}
	]
});


/* Portfolio lightbox gallery */

$(document).ready(function() {
	$('.element').magnificPopup({
		delegate: 'a', 
		type: 'image',
		gallery:{
			enabled:true
		}
	});
});

/* Isotope */  

var $container = $('#portfolio');

// Initialize isotope
$container.imagesLoaded( function(){
  $container.fadeIn(1000).isotope({
    layoutMode : 'fitRows',
    itemSelector : '.p-element'
  });
});

// Filter items when filter link is clicked

$('#filters a').click(function(){
	var selector = $(this).attr('data-filter');
	$container.isotope({ filter: selector });
	return false;
});  


/* Way Point Animation */

$(document).ready(function(){

	// Features Item Animation
	$('.features-item').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('fadeInUp');
	}, { offset: '100%' });
	
	// Features Item Two Animation
	$('.f-two-item').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('fadeIn');
	}, { offset: '100%' });
	
	// Skill Item Animation
	$('.skill-item').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('bounceIn');
	}, { offset: '100%' });
	
	// Team Member Animation
	$('.team-member').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('fadeIn');
	}, { offset: '100%' });
	
	// Video Container Animation
	$('.video-container').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('fadeInLeft');
	}, { offset: '100%' });
	
	// Video Content Animation
	$('.video-content-outer').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('fadeInRight');
	}, { offset: '100%' });
	
	// Service Item Animation
	$('.service-item').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('fadeIn');
	}, { offset: '100%' });
	
	// Blog Entry Animation
	$('.entry').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('bounceIn');
	}, { offset: '100%' });
	
	// Pricing Item Animation
	$('.pricing-item').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('fadeInUp');
	}, { offset: '100%' });
	
	// Social Hub Item Animation
	$('.hub-item').waypoint(function(down){
		$(this).addClass('animation');
		$(this).addClass('bounceIn');
	}, { offset: '100%' });
	
});

/* Scroll to top */

$(".totop").hide();

$(function(){
	$(window).scroll(function(){
		if ($(this).scrollTop()>300)
		{
			$('.totop').fadeIn();
		} 
		else
		{
			$('.totop').fadeOut();
		}
	});
	$('.totop a').click(function (e) {
		e.preventDefault();
		$('body,html').animate({scrollTop: 0}, 600);
	});
 });
