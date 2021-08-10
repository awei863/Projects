<?php
/**
 * Template Name: template-home
 *
 * Template for displaying a page without sidebar even if a sidebar widget is published.
 *
 * @package UnderStrap
 */

// Exit if accessed directly.
defined( 'ABSPATH' ) || exit;

get_header();

?>

<div class="home-banner">
    <div class="container pb-5 pt-2">
        <!-- <img src="<?php echo get_template_directory_uri();?>/img/kitty-banner-2.jpg" class="d-block w-100" alt="kitty-banner"> -->
        <div class="row">
            <div class="col-6 message-container">
                <div class="message">
                    <h1>Toy Offers That Your Pets Will Love!</h1>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Recusandae quidem fuga ratione cupiditate</p>
                    <button>Shop Now</button>
                </div>
            </div>
            <div class="col-6 discount-container">
                <div class="discount rounded-circle">
                    <div class="container">
                        <p id='one'>UP TO</p>
                        <h1>50%</h1>
                        <p id='two'>OFF!</p>
                    </div>
                </div>
            </div>
            <button id='shop-mobile'>Shop Now</button>
        </div>
    </div>
</div>

<div class="products">
    <h1 class='text-center pt-5'>Popular Products</h1>
    <p class='text-center'>We offer a number of high quality toys to help keep your pets healthy and spoiled!</p>
    <div class="container">
        <div class="row pt-5 pb-5">
            <!-- <div class="col-md-3"></div> -->
            <div class="col-md-3 d-flex justify-content-center">
                <div class="card">
                    <img class="card-img-top" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="product">
                    <div class="card-body">
                        <h5 class="card-title">Cat Toy</h5>
                        <p class="card-text">$9.99</p>
                        <button>Add to cart</button>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex justify-content-center">
                <div class="card">
                    <img class="card-img-top" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="product">
                    <div class="card-body">
                        <h5 class="card-title">Cat Toy</h5>
                        <p class="card-text">$9.99</p>
                        <button>Add to cart</button>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex justify-content-center">
                <div class="card">
                    <img class="card-img-top" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="product">
                    <div class="card-body">
                        <h5 class="card-title">Cat Toy</h5>
                        <p class="card-text">$9.99</p>
                        <button>Add to cart</button>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex justify-content-center">
                <div class="card">
                    <img class="card-img-top" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="product">
                    <div class="card-body">
                        <h5 class="card-title">Cat Toy</h5>
                        <p class="card-text">$9.99</p>
                        <button>Add to cart</button>
                    </div>
                </div>
            </div>
            
            <!-- <div class="col-md-3"></div> -->
            
        </div>
    </div>
    
</div>

<section class="categories pt-5 pb-5">
			<div class="container">

				<h1 class="text-center pt-5">Categories</h1>
				<p class="text-center">We offer a number of high quality toys to help keep<br> your pets healthy and spoiled!</p>
			

			<div class="row pt-5">

				<div class="categories__col col-md-4 col-sm-12 mb-3">
					<a href="#" class="col-md-12 w-100 h-100 d-inline-block p-3 position-relative rounded overflow-hidden">
						<img class="position-absolute top-0 bottom-0 end-0 start-0" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="..." loading="lazy">
						<h2 class="position-absolute bottom-0 start-0 end-0 p-2 mb-0 text-center  text-white">Toys</h2>
					</a>
				</div>

				<div class="categories__col col-md-4 col-sm-12 mb-3">
					<a href="#" class="col-md-12 w-100 h-100 d-inline-block p-3 position-relative rounded overflow-hidden">
						<img class="position-absolute top-0 bottom-0 end-0 start-0" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="..." loading="lazy">
						<h2 class="position-absolute bottom-0 start-0 end-0 p-2 mb-0 text-center  text-white">Food</h2>
					</a>
				</div>

				<div class="categories__col col-md-4 col-sm-12 mb-3">
					<a href="#" class="col-md-12 w-100 h-100 d-inline-block p-3 position-relative rounded overflow-hidden">
						<img class="position-absolute top-0 bottom-0 end-0 start-0" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="..." loading="lazy">
						<h2 class="position-absolute bottom-0 start-0 end-0 p-2 mb-0 text-center text-white">Care</h2>
					</a>
				</div>

			</div>

			<div class="row mb-3">

				<div class="categories__col col-md-4 col-sm-12 mb-3">
					<a href="#" class="col-md-12 w-100 h-100 d-inline-block p-3 position-relative rounded overflow-hidden">
						<img class="position-absolute top-0 bottom-0 end-0 start-0" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="..." loading="lazy">
						<h2 class="position-absolute bottom-0 start-0 end-0 p-2 mb-0 text-center  text-white">Accessories</h2>
					</a>
				</div>

				<div class="categories__col sale col-md-8 col-sm-12 mb-3">
					<a href="#" class="col-md-12 w-100 h-100 d-inline-block p-3 position-relative rounded overflow-hidden">
						<div class="bg-sale position-absolute top-0 bottom-0 end-0 start-0" style="z-index: 1;"></div>
						<img class="position-absolute top-0 bottom-0 end-0 start-0" src="<?php echo get_template_directory_uri();?>/img/product.png" alt="..." loading="lazy"> 
						<h2 class="position-absolute bottom-0 start-0 end-0 p-2 mb-0 text-center text-white">Special Offers</h2>
			
					</a>
				</div>
			</div>
			</div>

</section>

<div class='shipping'>
            <div class="container">
                <div class="row">
                    <div class="shipping__col col-md-3 text-center">
                        <i class="bi bi-minecart-loaded "></i>
                        <h1>Curbside Pickup</h1>
                        <p>Order online and pick it up today</p>
                    </div>
                    <div class="shipping__col col-md-3 text-center">
                        <i class="bi bi-door-closed "></i>
                        <h1>FREE Same-Day Delivery</h1>
                        <p>Delivered to your doorsteps today!</p>
                    </div>
                    <div class="shipping__col col-md-3 text-center">
                        <i class="bi bi-truck "></i>
                        <h1>Ship to Home</h1>
                        <p>Free shipping on orders over $49</p>
                    </div>
                    <div class="autoship__col col-md-3 text-center">
                        <i class="bi bi-calendar2-week "></i>
                        <h1>Autoship</h1>
                        <p>Save 5% off all future autoship orders!</p>
                    </div>
                </div>
            </div>
            
</div>
        


<?php
get_footer();
