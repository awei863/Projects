<?php
/**
 * The template for displaying the footer
 *
 * Contains the closing of the #content div and all content after
 *
 * @package UnderStrap
 */

// Exit if accessed directly.
defined( 'ABSPATH' ) || exit;

$container = get_theme_mod( 'understrap_container_type' );
?>

<?php get_template_part( 'sidebar-templates/sidebar', 'footerfull' ); ?>

<div class="wrapper" id="wrapper-footer">

	<div id='footer' class="pt-5 pb-5">
		<div class="container">
			<div class="row">
				<div class="about col-3 col-xs-6">
					<h2>About</h2>
					<ul>
						<li>Shipping & Deliveries</li>
						<li>Returns & Exchanges</li>
						<li>Affiliates</li>
						<li>Brand Ambassadors</li>
						<li>Our Story</li>
						<li>FAQ/Help</li>
						<li>Terms of Service</li>
						<li>Refund Policy</li>
					</ul>					
				</div>
				<div class="company col-3 col-xs-6">
					<h2>Company</h2>
					<ul>
						<li>About Us</li>
						<li>Privacy Policy</li>
						<li>Terms & Conditions</li>
						<li>Contact Us</li>
						
					</ul>
					
				</div>
				<div class="signup col-6">
					<h2>Keep in Touch</h2>
					<p>Sign up for our newsletter and be the first to know about coupons and special promotions.</p>
					<input type="text" placeholder="Sign up with email...">
					<div class='socials pt-5'>
						<i class="bi bi-twitter rounded-circle"></i>
						<i class="bi bi-facebook rounded-circle"></i>
						<i class="bi bi-instagram rounded-circle"></i>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id='footer-mobile' class="pt-5 pb-5">
		<div class="container">
			<div class="row">
				<div class="signup col">
					<h2>Keep in Touch</h2>
					<input type="text" placeholder="Sign up with email...">
					<div class='socials pt-5'>
						<i class="bi bi-twitter rounded-circle"></i>
						<i class="bi bi-facebook rounded-circle"></i>
						<i class="bi bi-instagram rounded-circle"></i>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="about col-6">
					<h2>About</h2>
					<ul>
						<li>Shipping & Deliveries</li>
						<li>Returns & Exchanges</li>
						<li>Affiliates</li>
						<li>Brand Ambassadors</li>
						<li>Our Story</li>
						<li>FAQ/Help</li>
						<li>Terms of Service</li>
						<li>Refund Policy</li>
					</ul>
				</div>
				<div class="company col-6">
					<h2>Company</h2>
					<ul>
						<li>About Us</li>
						<li>Privacy Policy</li>
						<li>Terms & Conditions</li>
						<li>Contact Us</li>
						
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container pt-2">
		<div class="row d-flex align-items-center">
			<div class="col">
				<p>&copy;<?php bloginfo('name');?><?php echo date('Y');?> / Created by Alan Wei</p>
			</div>
			<div class="col h-25 d-inline-block text-end">
				<img src="<?php echo get_template_directory_uri();?>/img/payment.png" alt="payment" class='img-fluid' loading='lazy'>
			</div>
		</div>
	</div>

</div><!-- wrapper end -->

</div><!-- #page we need this extra closing tag here -->

<?php wp_footer(); ?>

</body>

</html>

