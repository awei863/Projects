<?php
/**
 * Template Name: my-theme-4
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
   <div class="jumbotron text-center">
       <div class="container" data-aos="fade-up" data-aos-duration="2000">
         <h1>There's No Place Like Home</h1>
         <button>Sell A Home</button>
         <button>Buy A Home</button>
       </div>
   </div> 
</div>

<div class="about">
   <div class="container"  data-aos="fade-right" data-aos-duration="2000">
      <div class="row">
         <div class="col-lg pic">
               <img src="<?php echo get_template_directory_uri();?>/imgs/realtor.jpg" alt="realtor">
         </div>
         <div class="col-lg text">
               <h1>A little about me...</h1>
               <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aperiam pariatur tempore repudiandae officiis voluptatem quis iste sit quo eos similique odit quibusdam, delectus magni beatae mollitia sed amet dolor nam!</p>
               <p>Non do culpa minim laborum id. Laboris aliqua sit reprehenderit esse cupidatat deserunt excepteur esse adipisicing. Cupidatat cillum do aliqua pariatur non velit culpa cupidatat Lorem est sint dolor. Fugiat et ipsum sit elit eiusmod.</p>
               <button>See More About Us</button>
         </div>
      </div>
   </div>
</div>

<div class="areas">
   <div class="row"  data-aos="fade-left">
      <div class="col-xl-3">
         <div class="container">
            <h2>FEATURED AREAS</h2>
            <h1>Explore the area with a local expert!</h1>
            <button>View All Areas</button>
         </div>
      </div>
      <div class="col-xl-9">
      <div id="multi-item-example" class="carousel slide carousel-multi-item" data-ride="carousel">

         <!--Controls-->
         <div class="controls">
            <a class="btn carousel-control-prev rounded-circle" href="#multi-item-example" data-slide="prev"><i class="fa fa-chevron-left"></i></a>
            <a class="btn carousel-control-next rounded-circle" href="#multi-item-example" data-slide="next"><i class="fa fa-chevron-right"></i></a>
         </div>
        
         <!--/.Controls-->

         <!--Indicators-->
         <ol class="carousel-indicators">
            <li data-target="#multi-item-example" data-slide-to="0" class="active"></li>
            <li data-target="#multi-item-example" data-slide-to="1"></li>
            <li data-target="#multi-item-example" data-slide-to="2"></li>
         </ol>
         
         <!--/.Indicators-->

         <!--Slides-->
         <div class="carousel-inner" role="listbox">

            <!--First slide-->
            <div class="carousel-item active">

               <div class="row">
                  <div class="col-md-4">
                     <div class="map1 mb-2">
                        <div class="container">
                           <h2>EXPLORE</h2>
                           <h1>Downtown</h1>
                           <button>View Area</button>
                        </div>
                        
                     </div>
                  </div>

                  <div class="col-md-4 clearfix d-none d-md-block">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h2>EXPLORE</h2>
                           <h1>Downtown</h1>
                           <button>View Area</button>
                        </div>
                     </div>
                  </div>

                  <div class="col-md-4 clearfix d-none d-md-block">
                     <div class="map1 mb-2">
                        <div class="container">
                           <h2>EXPLORE</h2>
                           <h1>Downtown</h1>
                           <button>View Area</button>
                        </div>
                     </div>
                  </div>
               </div>

            </div>
            <!--/.First slide-->

            <!--Second slide-->
            <div class="carousel-item">

               <div class="row">
                  <div class="col-md-4">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h2>EXPLORE</h2>
                           <h1>Downtown</h1>
                           <button>View Area</button>
                        </div>
                     </div>
                  </div>

                  <div class="col-md-4 clearfix d-none d-md-block">
                     <div class="map1 mb-2">
                        <div class="container">
                           <h2>EXPLORE</h2>
                           <h1>Downtown</h1>
                           <button>View Area</button>
                        </div>
                     </div>
                  </div>

                  <div class="col-md-4 clearfix d-none d-md-block">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h2>EXPLORE</h2>
                           <h1>Downtown</h1>
                           <button>View Area</button>
                        </div>
                     </div>
                  </div>
               </div>

            </div>
            <!--/.Second slide-->


         </div>
         <!--/.Slides-->

         </div>
         <!--/.Carousel Wrapper-->
      </div>
   </div>
</div>

<div class="listings">
      <div class="row title">
         <h2>My Listings</h2>
      </div>
      <div id="multi-item-example2" class="carousel slide carousel-multi-item" data-ride="carousel">

   <!--Controls-->
         <div class="controls">
            <a class="btn carousel-control-prev rounded-circle" href="#multi-item-example2" data-slide="prev"><i class="fa fa-chevron-left"></i></a>
            <a class="btn carousel-control-next rounded-circle" href="#multi-item-example2" data-slide="next"><i class="fa fa-chevron-right"></i></a>
         </div>

         <!--/.Controls-->

       

         <!--Slides-->
         <div class="carousel-inner" role="listbox">

            <!--First slide-->
            <div class="carousel-item active">

               <div class="row">
                  <div class="col-lg col-md col-sm">
                     <div class="map1 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                           
                        </div>
                        
                     </div>
                  </div>

                  <div class="col-lg col-md clearfix d-none d-md-block">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="col-lg clearfix d-none d-lg-block ">
                     <div class="map1 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="col-lg clearfix d-none d-lg-block  ">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>

            </div>
            <!--/.First slide-->

            <!--Second slide-->
            <div class="carousel-item">

               <div class="row">
                  <div class="col-lg col-md col-sm">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="col-lg col-md clearfix d-none d-md-block">
                     <div class="map1 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="col-lg clearfix d-none d-lg-block  ">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="col-lg clearfix d-none d-lg-block  ">
                     <div class="map2 mb-2">
                        <div class="container">
                           <h1>$1,000,000</h1>
                           <div>                              
                              <h2 class='font-weight-bold'>Downtown</h2>
                              <h2>123 Best Neighbourhood Street</h2>
                              <h2>4 <b>beds</b>, 4 <b>baths</b>, 3,000 <b>sqft</b></h2>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>

            </div>
            <!--/.Second slide-->


         </div>
         <!--/.Slides-->

         </div>
   <!--/.Carousel Wrapper-->
   <div class="row button">
      <button>See More</button>
   </div>
      
      </div>
      
   
</div>

<div class="info">
   <div class="container">
      <div class="row">
         <div class="col-md">
               <h1>Perfect Home Finder</h1>
               <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Excepturi, pariatur voluptatum hic nemo suscipit similique unde beatae necessitatibus odit aliquid tenetur repudiandae nisi ipsa labore ipsam sint. Accusamus, rem quis?</p>
               <button>Send Me The Listings</button>
         </div>
         <div class="col-md">
               <h1>What's My Home Worth?</h1>
               <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Excepturi, pariatur voluptatum hic nemo suscipit similique unde beatae necessitatibus odit aliquid tenetur repudiandae nisi ipsa labore ipsam sint. Accusamus, rem quis?</p>
               <button>Free Valuation</button>
         </div>
      </div>
   </div>
</div>

<div class="service">
   <div class="container">
      <h1 class='text-center'>How I deliver better results...</h1>
      <div class="row">
         <div class="col-md service-info d-flex flex-column align-items-center">
               <img src="https://assets.thesparksite.com/uploads/sites/2493/2019/11/value-1.svg" alt="pic" width="65px">
               <h2 class='text-center'>Customized Service</h2>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisic</p>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicing elit. voluptates eius tempora h</p>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores fugiat reprehenderit numquam quo omnis porro pariatu Debitis?</p>
         </div>
         <div class="col-md service-info d-flex flex-column align-items-center">
               <img src="https://assets.thesparksite.com/uploads/sites/2493/2019/11/value-2.svg" alt="pic" width="65px">
               <h2 class='text-center'>Quality Service</h2>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicinmpora harum error vero. Debitis?</p>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicing elit. vol</p>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores fugiat reprehenderit numquam quo omnis porro pariatu Debitis?</p>
         </div>
         <div class="col-md service-info d-flex flex-column align-items-center">
               <img src="https://assets.thesparksite.com/uploads/sites/2493/2019/11/value-3.svg" alt="pic" width="65px">
               <h2 class='text-center'>Professional Service</h2>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicinmpora harum error vero. Debitis?</p>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicing elit. voluptates eius tempora harum error vero. Debitis?</p>
               <p class='text-center'>Lorem ipsum dolor sit amet consectetur adipisicingbitis?</p>
         </div>
         
      </div>
      <div class='button1 text-center'>
         <button>See How I Can Help You!</button>
      </div>
   </div>
</div>

<div class="news d-flex flex-row align-items-center">
   <div class="container">
      <div class="row">
         <div class="col-md news-info d-flex flex-column justify-content-center">
            <h2>Recent News & Advice</h2>
            <hr class='sp-hr d-block my-4 mx-0'>
            <p>Ut eu id ad exercitation esse culpa consectetur velit aliqua commodo anim ex esse non.</p>
            <button>Read More</button>
         </div>
         <div class="col-lg card-info">
            <div class="card">   
               <div class="card-body">
                  <h5 class="card-title">Why It's Important To Work With A Realtor</h5>
                  <p class="card-text">Dolor proident sint sint magna reprehenderit do non. Dolor proident sint sint magna reprehenderit do non.</p>
               </div>
               <img class="card-img-bot" src="https://assets.thesparksite.com/uploads/sites/2493/2019/07/buying-500x300.jpg" alt="Card image cap">
            </div>
         </div>
         <div class="col-lg card-info">
            <div class="card">   
               <div class="card-body">
                  <h5 class="card-title">Things You Shouldn't Do</h5>
                  <p class="card-text">Dolor proident sint sint magna reprehenderit do non. Dolor proident sint sint magna reprehenderit do non.</p>
               </div>
               <img class="card-img-bot" src="https://assets.thesparksite.com/uploads/sites/2493/2018/09/buying-home-500x300.jpg" alt="Card image cap">
            </div>
         </div>
         <div class="col-lg card-info">
            <div class="card">   
               <div class="card-body">
                  <h5 class="card-title">Should I Rent Or Buy A Home?</h5>
                  <p class="card-text">Dolor proident sint sint magna reprehenderit do non. Dolor proident sint sint magna reprehenderit do non.</p>
               </div>
               <img class="card-img-bot" src="https://assets.thesparksite.com/uploads/sites/2493/2018/09/buy-rent-500x300.jpg" alt="Card image cap">
            </div>
         </div>
      </div>
   </div>
</div>

<div class="subscribe" data-aos="fade-up">
   <div class="container text-center">
      <h1>Subscribe To Our Newsletter</h1>
      <hr class='sp-hr'>
      <p>Commodo minim consectetur fugiat qui dolore quis veniam.</p>
      <input type="email" placeholder="Email *">
      <button>Subscribe</button>
   </div>
</div>

<?php
get_footer();


