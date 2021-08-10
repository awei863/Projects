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

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<p>Products</p>
				<ul>
					<li>Shared hosting</li>
					<li>Wordpress hosting</li>
					<li>VPS hosting</li>
					<li>Dedicated hosting</li>
					<li>Reseller hosting</li>
					<li>Hosting features</li>
				</ul>
			</div>
			<div class="col-md-3">
				<p>Programs</p>
				<ul>
					<li>Wordpress</li>
					<li>Affiliates</li>
					<li>Marketing Services</li>
					<li>Blueprint</li>
					
				</ul>
			</div>
			<div class="col-md-3">
				<p>Company</p>
				<ul>
					<li>About</li>
					<li>Contact</li>
					<li>Terms of service</li>
					<li>Privacy</li>
					<li>Chat</li>
					
				</ul>
			</div>
			<div class="col-md-3">
				<div class='socials'>Socials</div>
				<i class="icon bi-facebook mr-2"></i>
				<i class="icon bi-instagram mr-2"></i>
				<i class="icon bi-twitter mr-2"></i>
				<i class="icon bi-youtube"></i>
			</div>
		</div>
	</div>

</div><!-- wrapper end -->

</div><!-- #page we need this extra closing tag here -->

<?php wp_footer(); ?>

</body>

</html>

