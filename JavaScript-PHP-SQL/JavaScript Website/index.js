var google_key = "AIzaSyD-rDIv2jbmR2JhYBfgWtqFwYMzd_YyW_w";
var mobile_image_location = "images/square75/";
var desktop_image_location = "images/square150/";


var single_photo_view_mobile_image_location = "images/medium640/";
var single_photo_view_desktop_image_location = "images/medium800/";

//var countriesArray; //array of countries, retrieved from web
var country;
var citiesArray;
var city;
var imagesArray;
var image;
//var languagesArray; //language

//for tooltip
var credit = "";
var colors = "";
var colorsDivs = "";

//hide google map
document.getElementById("country_map_img").style.visibility = "hidden";

//get json from URL
var retrieveJSON = function(URL, callBackFunc){
	
	fetch(URL).then(function(response) {
		response.json().then(function(data) {
			callBackFunc(null, data);
		});		
	});
}

//retrieve contries		
//<ul>
var countriesUL = document.getElementById("countries");

//iterate countries
for(let i = 0; i < countriesArray.length; i++){		
	//create li node and append to ul
	var node = document.createElement("LI");  
	node.appendChild(document.createTextNode(countriesArray[i].name));  
	countriesUL.appendChild(node);
	
	(function(value){
	node.addEventListener("click", function() {
	   chooseCountry(countriesArray[i])//choose this country
	}, false);})(countriesArray[i]);
}

//filter countries
function filterCountries(){
	
	//countries filter select
	var countries_filter_select = document.getElementById("countries_filter_select");
	
	//countries filter 
	var countries_filter = document.getElementById("countries_filter");
	
	//<ul>
	var countriesUL = document.getElementById("countries");
	countriesUL.innerHTML = "";
	
	//hide google map
	document.getElementById("country_map_img").style.visibility = "hidden";
	
	//console.log(countries_filter_select.selectedIndex);
	
	//iterate countries
	for(let i = 0; i < countriesArray.length; i++){	

		var show = false; //show country i ?
	
		if (countries_filter_select.selectedIndex == 1){ //Continent
			if (countries_filter.value == "" || countries_filter.value.toLowerCase() == countriesArray[i].continent.toLowerCase()){
				show = true;
			}
		}else if (countries_filter_select.selectedIndex == 2){ //by name
			if (countries_filter.value == "" || countriesArray[i].name.toLowerCase().startsWith(countries_filter.value.toLowerCase())){
				show = true;
			}
		}else{
			show = true;//no filter
			countries_filter.value = "";
		}
		
		if (show == true){	
			//create li node and append to ul
			var node = document.createElement("LI");  
			node.appendChild(document.createTextNode(countriesArray[i].name));  
			countriesUL.appendChild(node);
			
			(function(value){
			node.addEventListener("click", function() {
			   chooseCity(countriesArray[i])//choose this country
			}, false);})(countriesArray[i]);
		}
	}		
	
	//clear cities <ul>
	var citiesUL = document.getElementById("cities");
	citiesUL.innerHTML = "";
	
	//clear cities filter 
	var cities_filter = document.getElementById("cities_filter");
	cities_filter.value = "";
}

//choose specific country
function chooseCountry(value){
	country = value;
	
	showCountryDetails();
	
	//clear city
	clearCityInfo();
	
	filterCities();
}

//filter cities
function filterCities(){
	
	//clear cities <ul>
	var citiesUL = document.getElementById("cities");
	citiesUL.innerHTML = "";
	
	//cities filter 
	var cities_filter = document.getElementById("cities_filter");
	
	//retrieve contries
	retrieveJSON('http://www.randyconnolly.com/funwebdev/3rd/api/travel/cities.php?iso=' + country.iso,
	
		function(err, cities) {		

			citiesArray = cities; //set global
			
			//iterate cities
			for(let i = 0; i < cities.length; i++){	
			
				var show = false; //show country i ?

				if (cities_filter.value == "" || cities[i].name.toLowerCase().startsWith(cities_filter.value.toLowerCase())){
					show = true;
				}
			
				if (show == true){	
					//create li node and append to ul
					var node = document.createElement("LI");  
					node.appendChild(document.createTextNode(cities[i].name));  
					citiesUL.appendChild(node);
					
					(function(value){
						node.addEventListener("click", function() {
						   chooseCity(cities[i])//choose this city
						}, false);})(cities[i]);
			
				}
			}
		}
	);	
}

//choose city
function chooseCity(value){
	city = value;
	
	//show country and city details
	showCityDetails();
}

//show country details
function showCountryDetails(){
	
	//show details
	document.getElementById("country_details_name").innerHTML = country.name;
	document.getElementById("country_details_area").innerHTML = country.details.area;
	document.getElementById("country_details_population").innerHTML = country.details.population;
	document.getElementById("country_details_capital").innerHTML = country.capital.cityName;
	document.getElementById("country_details_currency").innerHTML = country.details.currency;
	document.getElementById("country_details_domain").innerHTML = country.details.domain;
	document.getElementById("country_details_languages").innerHTML = country.details.languages;
	
	//show language
	var allLanguages = "";
	
	//retrieve languages
	var languageArr = country.details.languages.split(',');
	for(let i = 0; i < languageArr.length; i++){	
	
		var language = languageArr[i];
		if (language.search("-") >= 0){
			language = language.substring(0, language.search("-"));
		}
		var languageDetails = languagesArray.find(function(element) { 
			return element.iso == language; 
		}); 		
		
		if (languageDetails != null){
			
			if (allLanguages != ""){
				allLanguages += ", ";
			}
		
			allLanguages += languageDetails.name;
		}
	}	
	
	document.getElementById("country_details_languages").innerHTML = allLanguages;

	document.getElementById("country_details_neighbouring").innerHTML = country.details.neighbours;
	
	//for countries
	var allCountries = "";
	var countriesArr = country.details.neighbours.split(',');
	for(let i = 0; i < countriesArr.length; i++){	
	
		var aCountry = countriesArr[i];
		if (aCountry.search("-") >= 0){
			aCountry = aCountry.substring(0, aCountry.search("-"));
		}
		var countryDetails = countriesArray.find(function(element) { 
			return element.iso == aCountry; 
		}); 		
		
		if (countryDetails != null){
			
			if (allCountries != ""){
				allCountries += ", ";
			}
		
			allCountries += countryDetails.name;
		}
	}	
	document.getElementById("country_details_neighbouring").innerHTML = allCountries;
	
	document.getElementById("country_details_description").innerHTML = country.description;
	
	//show map
	document.getElementById("country_map_img").src = "https://maps.googleapis.com/maps/api/staticmap?zoom=6&size=800x600&key=" + google_key + "&center=" + country.name + "," + country.iso;
	document.getElementById("country_map_img").style.visibility = "visible";
	
	//get images
	retrieveImages();
}

//show city details
function showCityDetails(){
	
	if (city == null){
		return;
	}
	
	//show details
	document.getElementById("city_details_name").innerHTML = city.name;
	document.getElementById("city_details_population").innerHTML = city.population;
	document.getElementById("city_details_elevation").innerHTML = city.elevation;
	document.getElementById("city_details_timezone").innerHTML = city.timezone;
	
	//show map
	document.getElementById("country_map_img").src = "https://maps.googleapis.com/maps/api/staticmap?zoom=6&size=800x600&key=" + google_key + "&center=" + city.latitude + "," + city.longitude;
	document.getElementById("country_map_img").style.visibility = "visible";
	
	//get images
	retrieveImages();
}

//clear city
function clearCityInfo(){
	document.getElementById("city_details_name").innerHTML = "";
	document.getElementById("city_details_population").innerHTML = "";
	document.getElementById("city_details_elevation").innerHTML = "";
	document.getElementById("city_details_timezone").innerHTML = "";
}

//get image
function retrieveImages(){
	
	document.getElementById("allPicturesDiv").innerHTML = ""; //clear images
	
	var countryValue = "";
	var cityValue = "";
	
	if (country != null){
		countryValue = "&iso=" + country.iso;
	}
	if (city != null){
		cityValue = "&city=" + city.iso;
	}
	
	retrieveJSON('http://www.randyconnolly.com/funwebdev/3rd/api/travel/images.php?' + countryValue + cityValue,
	
		function(err, images) {	

			imagesArray	= images;
			
			var allPics = "";
			
			//iterate images
			for(let i = 0; i < images.length; i++){	
			
				var picDiv = '<picture style="margin: 5px;">';
				picDiv += '<source media="(min-width: 600px)"  srcset="' + desktop_image_location + images[i].filename + '">';
				picDiv += '<img id="' + images[i].id + '" src="' + mobile_image_location + images[i].filename + '" alt="photo">';
				picDiv += '</picture>';
				
				allPics += picDiv;
			
				
			}
			
			document.getElementById("allPicturesDiv").innerHTML = allPics;
		}
	);	
}

// apply event delegation for pictures
document.getElementById("allPicturesDiv").addEventListener("click",function(e) {
	
	// e.target was the clicked element
	if(e.target && e.target.nodeName == "IMG") {
		
		//iterate images
		for(let i = 0; i < imagesArray.length; i++){	
			if (imagesArray[i].id == e.target.id){
				image = imagesArray[i];
				break;
			}
		}
		
		//show single photo view
		showPhotoView();		
	}
});

//show single photo view
function showPhotoView(){
	//hide default view
	document.getElementById("leftside").style.display = "none";
	document.getElementById("righside").style.display = "none";
	document.getElementById("mainDefault").style.display = "none";
	
	//show single photo view
	document.getElementById("singlePhotoViewDiv").style.display = "block";	
	
	document.getElementById("leftside").className  = "leftside_photoview";
	document.getElementById("main").className  = "main_photoview";
	document.getElementById("righside").className  = "righside_photoview";
	
	//show data
	document.getElementById("image_srcset").srcset=single_photo_view_desktop_image_location + image.filename;
	document.getElementById("image_src").src=single_photo_view_mobile_image_location + image.filename;
	
	//details
	document.getElementById("photoTitle").innerHTML=image.title;
	document.getElementById("photoUserName").innerHTML=image.user.firstname + " " + image.user.lastname;
	document.getElementById("photoCountryCity").innerHTML=image.location.country + ", " + image.location.city;
	
	//tabs
	document.getElementById("descriptionContent").innerHTML=image.description;
	
	//exif information (model, exposure, aperture, focal length, iso), credit information, and colors information
	
	document.getElementById("photoDetailsModel").innerHTML= "Model: &nbsp;" + ((image.exif == null)?"":image.exif.model);
	document.getElementById("photoDetailsExposure").innerHTML="Exposure time: &nbsp;" + ((image.exif == null)?"":image.exif.exposure_time);
	document.getElementById("photoDetailsAperture").innerHTML="Aperture: &nbsp;" + ((image.exif == null)?"":image.exif.aperture);
	document.getElementById("photoDetailsFocalLength").innerHTML="Focal length: &nbsp;" + ((image.exif == null)?"":image.exif.focal_length);
	document.getElementById("photoDetailsIso").innerHTML="ISO: &nbsp;" + ((image.exif == null)?"":image.exif.iso);
	
	credit = "Credit:<br/>Actual: &nbsp;" + image.credit.actual +
	"<br/>Creator: &nbsp;<a href='" + image.credit.creator + "'/ alt='Creator'>Creator</a>";
	colors = "Colors: &nbsp;" + image.colors.join();
	
	document.getElementById("photoDetailsCreditInformation").innerHTML=credit
	document.getElementById("photoDetailsColorInformation").innerHTML=colors;
	
	colorsDivs = "";
	for (var i = 0; i < image.colors.length; i++) {
		colorsDivs += '<div class="color" style="background:' + image.colors[i] + '"></div>';
	}
	document.getElementById("photoDetailsColorsDiv").innerHTML=colorsDivs;
	
	//set map
	document.getElementById("city_map_img").src = "https://maps.googleapis.com/maps/api/staticmap?zoom=6&size=400x600&key=" + google_key + "&center=" + image.location.latitude + "," + image.location.longitude;
	"";
	
	//open default tab
	document.getElementById("defaultOpen").click();
	
}

var synth = window.speechSynthesis;

//speak
function photoSpeak(){
	
	var utterThis = new SpeechSynthesisUtterance(document.getElementById("descriptionContent").innerHTML);
	synth.speak(utterThis);
}

//open tab
//code from https://www.w3schools.com/howto/howto_js_tabs.asp
function openTab(evt, tabName){
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.className += " active";
}

//restore default view
function restoreDefaultView(){
	document.getElementById("leftside").style.display = "block";
	document.getElementById("righside").style.display = "block";
	document.getElementById("mainDefault").style.display = "block";
	
	document.getElementById("leftside").className  = "leftside";
	document.getElementById("main").className  = "main";
	document.getElementById("righside").className  = "righside";
	
	//hide single photo view
	document.getElementById("singlePhotoViewDiv").style.display = "none";	
	
	synth.cancel();
	
}

document.getElementById("singlePhotoViewDiv").style.display = "none";


//show single photo view
//showPhotoView();	

/*
code show tool tip from: https://stackoverflow.com/questions/37798967/tooltip-on-click-of-a-button
and is customized
*/
function showTooltip(e, tooltip)
{
	e = window.event ? window.event : e;
	tooltip = document.getElementById('dvTooltip');
	if(tooltip.style.display != "block")
		tooltip.style.display = "block";
	tooltip.style.left = (event.clientX + 10) + "px";
	tooltip.style.top = (event.clientY + 10) + "px";
	
	//data for tooltip
	document.getElementById("tooltipCreditInformation").innerHTML=credit;
	document.getElementById("tooltipColorInformation").innerHTML=colorsDivs;
}

function hideTooltip(e, tooltip)
{
	e = window.event ? window.event : e;
	tooltip = document.getElementById('dvTooltip');
	if(e.toElement == tooltip)
	{
		showTooltip(e, tooltip);
		return;
	}
	tooltip.style.display = "none";
}
