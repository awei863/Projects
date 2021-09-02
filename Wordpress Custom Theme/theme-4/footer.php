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
			<div class="col-md">
				<h1>Company</h1>
				<ul>
					<li>Home</li>
					<li>Why Choose Me</li>
					<li>Blog</li>
					<li>Contact</li>
				</ul>
			</div>
			<div class="col-md">
				<h1>Real Estate</h1>
				<ul>
					<li>Feautured Areas</li>
					<li>Property Search</li>
					<li>Helpful Guides</li>					
				</ul>
			</div>
			<div class="col-md">
				<h1>Tools</h1>
				<ul>
					<li>Home Finder</li>
					<li>What's My Home Worth?</li>
					<li>Mortgage Calculator</li>
					
				</ul>
			</div>
		</div>
		<hr class='sp-hr'>
		<div class='contact text-center'>
			<h1>Address:</h1>
			<p>1234 ABC Street | Calgary | AB | T2B 1A3</p>
			<h1>Email Me:</h1>
			<p>bestemail@email.ca</p>
			<h1>Call Me:</h1>
			<p>(403) 969-8838</p>
			<i class="bi-facebook"></i>
			<i class="bi-twitter"></i>
			<i class="bi-linkedin"></i>
			<i class="bi-youtube"></i>
			<h1 class='logo'>REAL ESTATE GROUP</h1>
		</div>
	</div>

</div><!-- wrapper end -->

</div><!-- #page we need this extra closing tag here -->

<?php wp_footer(); ?>

</body>

</html>

