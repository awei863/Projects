const inputBox = document.querySelector('.add input');
const addBtn = document.querySelector('.add button');
const list = document.querySelector('.list');
const pendingNum = document.querySelector('.pendingNum');
const clearAll = document.querySelector('.footer button');

inputBox.onkeyup = () => {
    let userData = inputBox.value;
    if (userData.trim() != 0) {
        addBtn.classList.add('active');
    }
    else {
        addBtn.classList.remove('active');
    }

    
}

addBtn.addEventListener('click', function () {

    
    var listItem = document.createElement('li');

    listItem.innerText = inputBox.value;
    list.appendChild(listItem);
    inputBox.value = '';
    addBtn.classList.remove('active');

    if (list.children.length > 0) {
        clearAll.classList.add('active');
    }
    else {
        clearAll.classList.remove('active');
    }

    listItem.addEventListener('click', function () {
        list.removeChild(listItem);
    });

    clearAll.addEventListener('click', function () {
    
       // list.innerHTML = '';
        while(list.firstChild){
            list.removeChild(list.firstChild);
        }
        clearAll.classList.remove('active');
    })
    
    
})






////////////////////////////////////////////////////////////

// showTasks();

// addBtn.onclick = () =>{
//     let userData = inputBox.value;
//     let getLocalStorage = localStorage.getItem('New Todo');
//     if(getLocalStorage == null){
//         listArr = [];
//     }
//     else{
//         listArr = JSON.parse(getLocalStorage);
//     }
//     listArr.push(userData);
//     localStorage.setItem('New Todo', JSON.stringify(listArr));
//     showTasks();
//     addBtn.classList.remove('active');
// }

// function showTasks(){
//     let getLocalStorage = localStorage.getItem('New Todo');
//     if(getLocalStorage == null){
//         listArr = [];
//     }
//     else{
//         listArr = JSON.parse(getLocalStorage);
//     }
//     pendingNum.textContent = listArr.length;
//     if(listArr.length > 0){
//         clearAll.classList.add('active');
//     }
//     else{
//         clearAll.classList.remove('active');
//     }
//     let newItem = '';
//     listArr.forEach((element, index) =>{
//         newItem += `<li>${element}<span onclick='deleteTask(${index})'><i class="bi bi-trash-fill"></i></span></li>`
//     });
//     list.innerHTML = newItem;
//     inputBox.value='';
// }

// function deleteTask(index){
//     let getLocalStorage = localStorage.getItem('New Todo');
//     listArr = JSON.parse(getLocalStorage);
//     listArr.splice(index, 1);
//     localStorage.setItem('New Todo', JSON.stringify(listArr));
//     showTasks();
// }

// clearAll.onclick = () =>{
//     listArr = [];
//     localStorage.setItem('New Todo', JSON.stringify(listArr));
//     showTasks();
// }