const form=document.querySelector('form');

form.addEventListener('submit',(e)=>{
    e.preventDefault();
    let aray=[];

    document.querySelectorAll('[type="checkbox"]').forEach(item=>{
        if (item.checked ===true){
            aray.push(item.value);
        }
    })

    console.log(aray);
})

function pages(){
    
}