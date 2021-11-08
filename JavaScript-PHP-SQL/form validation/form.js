const form = document.getElementById('form');
const username = document.getElementById('username');
const password = document.getElementById('password');
const email = document.getElementById('email');
const password2 = document.getElementById('password-repeat');
const confirmation = document.getElementById('registered');
const letter = document.getElementById("letter");
const capital = document.getElementById("capital");
const number = document.getElementById("number");
const length = document.getElementById("length");

var numbers = /[0-9]/g;
var lowerCaseLetters = /[a-z]/g;
var upperCaseLetters = /[A-Z]/g;


form.addEventListener('submit', (e) => {
    e.preventDefault();

    checkInputs();
    submitSuccess();
});


function checkInputs() {
    // get values
    const usernameValue = username.value.trim();
    const passwordValue = password.value.trim();
    const emailValue = email.value.trim();
    const password2Value = password2.value.trim();

    validateUsername(usernameValue);

    validateEmail(emailValue);
  
    validatePassword(passwordValue);

    validatePassword2(password2Value);

    function validatePassword2(password2Value){
        if(password2Value === ''){
            setErrorFor(password2, 'Password cannot be empty');
        }
        else if(passwordValue !== password2Value){
            setErrorFor(password2, 'Passwords do not match');
        }
        else{
            setSuccessFor(password2);
        }
    }  
}

function validateUsername(usernameValue){
    if (usernameValue === '') {
        // show error & add error class
        setErrorFor(username, 'Username cannot be empty');
    }
    else {
        // add success class
        setSuccessFor(username);
        
    };
}

function validatePassword(passwordValue){
    
    
    if(passwordValue === ''){
        setErrorFor(password, 'Password cannot be empty');
    }
    else if(passwordValue.length < 8){
        setErrorFor(password, 'Password does not meet the requirements');
    }
    else if(!password.value.match(lowerCaseLetters)){
        setErrorFor(password, 'Password does not meet the requirements');
    }
    else if(!password.value.match(upperCaseLetters)){
        setErrorFor(password, 'Password does not meet the requirements');
    }
    else if(!password.value.match(numbers)){
        setErrorFor(password, 'Password does not meet the requirements');
    }
    else{
        setSuccessFor(password);
    }
}


function validateEmail(emailValue){
    if (emailValue === '') {
        setErrorFor(email, 'Email cannot be empty');
        //console.log('empty');
    }
    else if(!checkEmail(emailValue)){
        setErrorFor(email, 'Email is invalid');
        //console.log('invalid');
    }
 
    else{
        setSuccessFor(email);
        //console.log('success');
    };
}

// Show registered text when all inputs are correct and submitted
function submitSuccess(){
    const usernameSuccess = username.parentElement;
    const emailSuccess = email.parentElement;
    const passwordSuccess = password.parentElement;
    const password2Success = password2.parentElement;

    if(usernameSuccess.className === 'form-element success' &&
       emailSuccess.className === 'form-element success' &&
       passwordSuccess.className === 'form-element success' &&
       password2Success.className === 'form-element success'){
        
            confirmation.className = 'registered success';
    }
    
    
}

// show message box on focus
password.onfocus = function(){
    document.getElementById('message').style.display='block';
}
// remove message box on out of focus
password.onblur = function() {
    document.getElementById("message").style.display = "none";
}

password.onkeyup = function() {
    // Validate lowercase letters
   // var lowerCaseLetters = /[a-z]/g;
    if(password.value.match(lowerCaseLetters)) {  
      letter.classList.remove("invalid");
      letter.classList.add("valid");
    } else {
      letter.classList.remove("valid");
      letter.classList.add("invalid");
      
    }
    
    // Validate capital letters
    //var upperCaseLetters = /[A-Z]/g;
    if(password.value.match(upperCaseLetters)) {  
      capital.classList.remove("invalid");
      capital.classList.add("valid");
    } else {
      capital.classList.remove("valid");
      capital.classList.add("invalid");
    }
  
    // Validate numbers
    //var numbers = /[0-9]/g;
    if(password.value.match(numbers)) {  
      number.classList.remove("invalid");
      number.classList.add("valid");
    } else {
      number.classList.remove("valid");
      number.classList.add("invalid");
    }
    
    // Validate length
    if(password.value.length >= 8) {
      length.classList.remove("invalid");
      length.classList.add("valid");
    } else {
      length.classList.remove("valid");
      length.classList.add("invalid");
    }
  }



function setErrorFor(element, msg) {
    const formElement = element.parentElement;
    const small = formElement.querySelector('small');

    small.innerText = msg;
    formElement.className = 'form-element error';
}

function setSuccessFor(element){
    const formElement = element.parentElement;
    formElement.className = 'form-element success';
}



function checkEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  
}
