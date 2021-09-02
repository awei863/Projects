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
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@900&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Mr+De+Haviland&family=Playfair+Display&family=Source+Sans+Pro&display=swap" rel="stylesheet">
	
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/> -->
	<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
	
	
	<?php wp_head(); ?>
</head>

<body <?php body_class(); ?> <?php understrap_body_attributes(); ?>>
<?php do_action( 'wp_body_open' ); ?>
<div class="site" id="page">
	<div class="nav">

	
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light d-flex">
				<a class="navbar-brand" href="#">REAL ESTATE GROUP</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" href="#">BUY</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">SELL</a>
						</li>
						<li class="nav-item">
							<a class="nav-link d-block" href="#">LUXURY HOMES</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">FEATURED AREAS</a>
						</li>
						<li class="nav-item blog">
							<a class="nav-link" href="#">BLOG</a>
						</li>
						<li class="nav-item contact">
							<a class="nav-link" href="#">CONTACT</a>
						</li>
					</ul>
			</div>
			</nav>
		</div>
	</div>
</div>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script type="text/javascript">
    AOS.init();
</script>



