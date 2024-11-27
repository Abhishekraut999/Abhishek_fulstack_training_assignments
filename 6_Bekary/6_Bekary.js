let cart = [];
let totalPrice = 0;

function updateCart(itemName, itemPrice, itemWeight) {
    cart.push({ name: itemName, price: itemPrice, weight: itemWeight });

    totalPrice += itemPrice;

    let cartItemsDiv = document.getElementById('cart-items');
    if (cart.length === 0) {
        cartItemsDiv.innerHTML = '<p>No items in the cart.</p>';
    } else {
        cartItemsDiv.innerHTML = cart.map(item => 
            `<p>${item.name} (${item.weight}) - $${item.price}</p>`
        ).join('');
    }

    document.getElementById('total-price').innerText = totalPrice;
}

document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', () => {
        const itemName = button.getAttribute('data-item');
        const itemPrice = parseFloat(button.getAttribute('data-price'));
        const itemWeight = button.getAttribute('data-weight');

        updateCart(itemName, itemPrice, itemWeight);
    });
});
