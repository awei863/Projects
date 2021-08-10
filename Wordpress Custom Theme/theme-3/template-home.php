<?php
/**
 * Template Name: theme-3-template
 *
 * Template for displaying a page without sidebar even if a sidebar widget is published.
 *
 * @package UnderStrap
 */

// Exit if accessed directly.
defined( 'ABSPATH' ) || exit;

get_header();
?>

<div class="banner">
    
    <div class="container">
        
        <div class="row">
            
            <div class="text col-md-6">
                <h1>
                    One-click solution for your website.
                </h1>
                <button>Get A Quote</button>
            </div>
            <div class="img col-md-6">
                <img src="<?php echo get_template_directory_uri()?>/img/pic.png" alt="some-pic">
            </div>
        </div>
    </div>
</div>

<div class="services">
    <div class="container">
        <div class="row">
            <div class="text col-md-4 col-sm-12">
                <h1>
                    Hosting solution with benefits
                </h1>
                <p>Esse et voluptate nostrud in duis proident mollit magna.</p>
                <button>Read more</button>
            </div>
            <div class="grid col-md-4 col-sm-12">
                <div class="ssl row d-flex flex-column text-center justify-content-center align-items-center">
                    <div class='icon rounded-circle'>
                        <i class="bi bi-lock"></i>
                    </div>
                    <div class='free'>
                        FREE
                    </div>
                    <div class='title'>
                        SSL Certicifate
                    </div>
                    <div class='description'>
                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur
                    </div>
                    
                </div>
                <div class="code row d-flex flex-column text-center justify-content-center align-items-center">
                    <div class='icon rounded-circle'>
                        <i class="bi bi-code"></i>
                    </div>
                    
                    <div class='title'>
                        Code Editor
                    </div>
                    <div class='description'>
                    Duis aute irure dolor m dolore eu fugiat nulla pariatur
                    </div>
                    
                </div>
            </div>
            <div class="grid2 col-md-4 col-sm-12 ">
                <div class="domain row d-flex flex-column text-center justify-content-center align-items-center">
                    <div class='icon rounded-circle'>
                        <i class="bi bi-globe"></i>
                    </div>
                    
                    <div class='title'>
                        Personal Domain
                    </div>
                    <div class='description'>
                    Duis aute irure dolor m dolore eu fugiat nulla pariatur
                    </div>
                    
                </div>
                <div class="media row d-flex flex-column text-center justify-content-center align-items-center">
                    <div class='icon rounded-circle'>
                        <i class="bi bi-hdd-stack"></i>
                    </div>
                    <div class='free'>
                        FREE
                    </div>
                    <div class='title'>
                        Media Storage
                    </div>
                    <div class='description'>
                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>

<div class="about">
    <div class="container">
        <div class='box'>
            
        </div>
        <div class='img'>
            <img src="<?php echo get_template_directory_uri()?>/img/pic2.png" alt="pic2">
        </div>
        <div class='info'>
            <div>
                <h1>Create Amazing Website</h1>
                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Repudiandae minus voluptatibus saepe molestias veniam doloremque voluptatum vitae facere. Nisi impedit adipisci ullam saepe fugit vitae, doloribus quae! Perspiciatis, architecto maxime.</p>
                <button>Learn more</button>
            </div>
        </div>
    </div>
    
</div>

<div class="testimonials">
    <div class="container d-flex flex-column justify-content-center align-items-center text-center">
        <h2>TESTIMONIALS</h2>
        <h1>What Clients Say</h1>
        <p>Commodo ex id ex consecteturex consecteturex consecteturex consecteturex consecteturex consectetur sunt.</p>
        <div class="row">
            <div class="col-lg d-flex flex-column justify-content-center align-items-center">
                <i class="bi bi-person rounded-circle" style='font-size: 4rem'></i>
                <p class='text-center'>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem sint neque laudantium corrupti alias placeat nam deleniti tempora incidunt a reiciendis quas, molestiae dolorum iusto. Suscipit ut saepe sit cumque."</p>
                <h2>John Doe</h2>
                <h3>Sales Manager</h2>
            </div>
            <div class="col-lg d-flex flex-column justify-content-center align-items-center">
                <i class="bi bi-person rounded-circle" style='font-size: 4rem'></i>
                <p class='text-center'>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem sint neque laudantium corrupti alias placeat nam deleniti tempora incidunt a reiciendis quas, molestiae dolorum iusto. Suscipit ut saepe sit cumque."</p>
                <h2>John Doe</h2>
                <h3>Sales Manager</h2>
            </div>
            <div class="col-lg d-flex flex-column justify-content-center align-items-center">
                <i class="bi bi-person rounded-circle" style='font-size: 4rem'></i>
                <p class='text-center'>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem sint neque laudantium corrupti alias placeat nam deleniti tempora incidunt a reiciendis quas, molestiae dolorum iusto. Suscipit ut saepe sit cumque."</p>
                <h2>John Doe</h2>
                <h3>Sales Manager</h2>
            </div>
            <div class="col-lg d-flex flex-column justify-content-center align-items-center">
                <i class="bi bi-person rounded-circle" style='font-size: 4rem'></i>
                <p class='text-center'>"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem sint neque laudantium corrupti alias placeat nam deleniti tempora incidunt a reiciendis quas, molestiae dolorum iusto. Suscipit ut saepe sit cumque."</p>
                <h2>John Doe</h2>
                <h3>Sales Manager</h2>
            </div>
        </div>
    </div>    


</div>

<div class="purchase">
    <div class="container">
        <h1>Purchase</h1>
        <div class="first row">
            <div class="col-md-6">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut accusantium, saepe omnis provident odio cupiditate necessitatibus error quasi ipsa veritatis voluptates voluptatibus quos aperiam rerum illo beatae cumque consequuntur minus?</p>
            </div>
            <div class="col-md-3">
                <ul>
                    <li><i class="bi-check-lg"></i>Unlimited Pages</li>
                    <li><i class="bi-check-lg"></i>Unlimited Forms</li>
                    <li><i class="bi-check-lg"></i>Unlimited HTTPS</li>
                </ul>                
            </div>
            <div class="col-md-3">
                <ul>
                    <li><i class="bi-check-lg"></i>Free Sub-Domain</li>
                    <li><i class="bi-check-lg"></i>Unlimited Data</li>
                    <li><i class="bi-check-lg"></i>24/7 Support</li>
                </ul> 
            </div>
        </div>
        <div class="second row d-flex justify-content-center">
            <div class="starter col-lg d-flex flex-column justify-content-center ">
                <h2>Starter Plan</h2>
                <h1>Free</h1>
                <button>Get Started Free<i class='bi-arrow-right ml-2'> </i></button>
                <p>Free static domain included.</p>
            </div>
            <div class="yearly col-lg d-flex flex-column justify-content-center">
                <div class='d-flex flex-row align-items-center'><h2>Yearly Plan</h2> <h3>Save 25%</h3></div>
                <h1>$9<span style='font-size:1.5rem;'>/month</span></h1>
                <button>Proceed Annually<i class='bi-arrow-right ml-2'> </i></button>
                <p>Billed $108 per website annually.</p>
            </div>
            <div class="monthly col-lg d-flex flex-column justify-content-center ">
                <h2>Monthly Plan</h2>
                <h1>$12<span style='font-size:1.5rem;'>/month</span></h1>
                <button>Proceed Annually<i class='bi-arrow-right ml-2'> </i></button>
                <p>Billed $12 per website monthly.</p>
            </div>
        </div>
    </div>
</div>

<div class="get-started">
    <div class="container">
        <div class="row">
            <div class="pic col-7">
                <div class="box">
                    
                </div>
                <div class="img">
                <img src="<?php echo get_template_directory_uri()?>/img/pic3.png" alt="pic2">

                </div>
            </div>
            <div class="info col-5">
                <div class="container">
                    <h1>Get started with the simpliest static page</h1>
                    <button>Get Started Now</button>
                </div>
                
            </div>
        </div>
        <div class="info-sm">
            <div class="container">
                <h1>Get started with the simpliest static page</h1>
                <button>Get Started Now</button>
            </div>
                
        </div>
    </div>
</div>

<div class="contact">
    <div class="box">
        
    </div>
    <div class="container">

        <div class="form">
            <div class="row">
                <div class="info col d-flex flex-column">
                    <h1>Contact Info</h1>
                    <h2><i class="icon bi-telephone"></i>+1 (403) 123-4567</h2>
                    <h2><i class="icon bi-envelope"></i>email@email.ca</h2>
                    <h2><i class="icon bi-geo-alt"></i>999 Best Street SE, Calgary</h2>
                    <h1>
                        <i class="bi-facebook mr-2"></i>
                        <i class="bi-instagram mr-2"></i>
                        <i class="bi-twitter mr-2"></i>
                        <i class="bi-youtube"></i>
                    </h1>
                </div>
                <div class="input-info col d-flex flex-column">
                    <input type="text" placeholder="Enter your Name">
                    <input type="text" placeholder="Enter your Email">
                    <input class='message' type="text" placeholder="Enter your Message">
                    <button>SUBMIT</button>
                </div>
            </div>
        </div>
    </div>
</div>

<?php
get_footer();
