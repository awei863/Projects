// Client ID
// 3Vip8HY3QuJFCwyrhOHSNA

// API Key
// WaRsULjxFitkkfEdFg0TDFxfPbfrvw1MidGN0j6pHN9FCDiwcWW6HdX4Z3CjZ77zFNwtX-fC31E8xKi-Aj_hNqs2X8rtbNNjwOYYih5eepS1kgtuILtLo6S3v1xnYXYx

const apiKey = 'WaRsULjxFitkkfEdFg0TDFxfPbfrvw1MidGN0j6pHN9FCDiwcWW6HdX4Z3CjZ77zFNwtX-fC31E8xKi-Aj_hNqs2X8rtbNNjwOYYih5eepS1kgtuILtLo6S3v1xnYXYx';

const Yelp = {
    search(term, location, sortBy){
        return fetch(`https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/search?term=${term}&location=${location}&sort_by=${sortBy}`, {
            headers:{
                Authorization: `Bearer ${apiKey}`
            }
        }).then((response)=>{
            return response.json();
        }).then((jsonResponse)=>{
            
            if(jsonResponse.businesses){
                return jsonResponse.businesses.map((business)=>{
                    console.log(business);
                    return {
                        id: business.id,
                        imageSrc: business.image_url,
                        name: business.name,
                        address: business.location.address1,
                        city: business.location.city,
                        state: business.location.state,
                        zipCode: business.location.zip_code,
                        category: business.categories[0].title,
                        rating: business.rating,
                        reviewCount: business.review_count
                    }
                })
            }
        });
        
    }
};

export default Yelp;