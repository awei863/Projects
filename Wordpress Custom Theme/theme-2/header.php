<?php
/**
 * The header for our theme
 *
 * Displays all of the <head> section and everything up till <div id="content">
 *
 * @package UnderStrap
 */

// Exit if accessed directly.
defined( 'ABSPATH' ) || exit;

$container = get_theme_mod( 'understrap_container_type' );
?>
<!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
	<meta charset="<?php bloginfo( 'charset' ); ?>">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="profile" href="http://gmpg.org/xfn/11">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	<?php wp_head(); ?>
</head>

<body <?php body_class(); ?> <?php understrap_body_attributes(); ?>>
<?php do_action( 'wp_body_open' ); ?>
<div class="site" id="page">
	<div class="announcement-bar pt-2 pb-2">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<ul class='announcement-bar__list'>
						<li>
							<i class="bi bi-telephone rounded-circle"></i>
							<a href="#">(403) 123-4567</a>
						</li>
						<li>
							<i class="bi bi-envelope rounded-circle"></i>
							<a href="#">email@email.ca</a>
						</li>
					</ul>
				</div>
				<div class="col-md-8 d-flex justify-content-end">
					<ul class='announcement-bar__list'>
						<li>
							<i class="bi bi-truck rounded-circle"></i>
							FREE SHIPPING
						</li>
						<li>
							<i class="bi bi-clock-history rounded-circle"></i>
							30 DAYS MONEY BACK GUARANTEE
						</li>
						<li>
							<i class="bi bi-person rounded-circle"></i>
							24/7 CUSTOMER SUPPORT
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="container pt-2 pb-2">
		<div class="row align-items-center">
			<div class="col site-header__logo d-flex justify-content-center justify-content-md-start pb-2">
				<img src="<?php echo get_template_directory_uri();?>/img/whiskers-logo.png" alt="logo" width='80%'>
			</div>
			<div class="search col-sm-12 col-md-5 d-flex">
				<input type="text" placeholder="Search"> <i class="bi bi-search h3 pl-2 mt-1"></i>
			</div>
			<div class="col cart d-flex justify-content-center justify-content-md-end align-items-center pt-2">
				<a href="#">
					<i class="bi bi-bag-dash pr-2">
					
					</i>
					0 Items - $0.00
				</a>
				
			</div>
		</div>
	</div>

	<!-- ******************* The Navbar Area ******************* -->
	<div id="wrapper-navbar">
		
		<a class="skip-link sr-only sr-only-focusable" href="#content"><?php esc_html_e( 'Skip to content', 'understrap' ); ?></a>

		<nav id="main-nav" class="navbar navbar-expand-md" aria-labelledby="main-nav-label">
			<div class="container d-flex justify-content-center">
				<h2 id="main-nav-label" class="sr-only">
					<?php esc_html_e( 'Main Navigation', 'understrap' ); ?>
				</h2>

			

					<div class="row">
						<div class="col-12 d-flex justify-content-center">
							<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="<?php esc_attr_e( 'Toggle navigation', 'understrap' ); ?>">
								
								<i class='bi bi-list'></i>Menu
							</button>
						</div>
						<div class="col-12 text-center">
							<!-- The WordPress Menu goes here -->
							<?php
							wp_nav_menu(
								array(
									'theme_location'  => 'primary',
									'container_class' => 'collapse navbar-collapse',
									'container_id'    => 'navbarNavDropdown',
									'menu_class'      => 'navbar-nav',
									'fallback_cb'     => '',
									'menu_id'         => 'main-menu',
									'depth'           => 2,
									'walker'          => new Understrap_WP_Bootstrap_Navwalker(),
								)
							);
							?>
						</div>
					</div>

					

					
				<?php if ( 'container' === $container ) : ?>
				</div><!-- .container -->
				<?php endif; ?>
			</div>
			

		</nav><!-- .site-navigation -->

	</div><!-- #wrapper-navbar end -->
