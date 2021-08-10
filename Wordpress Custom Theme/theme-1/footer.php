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
    <div class="bg-image"></div>

    <div class="title-holder">
        <div class="container">
            <h2>
                <span>Contact</span>
                Send us a message below
            </h2>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-1"></div>
            <div class="col-lg-11">
                <?php echo do_shortcode('[contact-form-7 id="19" title="Footer Form"]') ?>
                <div class="copyright">© Copyright The Spaceship Outer Space Dining - All Rights Reserved // Website by Alan Wei</div>
            </div>
            
            
        </div>
    </div>
	

</div><!-- wrapper end -->
<div class="footer-warning">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-2 col-lg-2 col-xl-1">
                <img src="<?php echo get_template_directory_uri() ;?>/img/wine.png" alt="wineglasses" >
            </div>
            <div class="col-md-10 col-lg-10 col-xl-11">
                <h3>WARNING, Under the Liquor Control Act 1998, it is an offence:</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis expedita sunt nemo? Rem consectetur, odit id et recusandae molestiae at tempora quasi aliquid velit quidem possimus eaque dicta labore nulla.</p>
            </div>
        </div>
        
        
    </div>
</div>
</div><!-- #page we need this extra closing tag here -->

<?php wp_footer(); ?>
    
</body>

</html>

