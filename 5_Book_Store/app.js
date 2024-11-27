
let books = {
    'Fiction': ['Book 1', 'Book 2', 'Book 3'],
    'Non-Fiction': ['Book A', 'Book B'],
    'Novels': ['Novel 1', 'Novel 2'],
    'Kids Education': ['Kids Book 1', 'Kids Book 2'],
    'Science': ['Science Book 1', 'Science Book 2'],
    'Technology': ['Tech Book 1', 'Tech Book 2'],
    'Magazines': ['Magazine 1', 'Magazine 2']
};

document.getElementById('registerBtn').addEventListener('click', function(e) {
    e.preventDefault();

    let selectedCategories = [];
    document.querySelectorAll('#categoryForm input[type="checkbox"]:checked').forEach(function(checkbox) {
        selectedCategories.push(checkbox.value);
    });

    if (selectedCategories.length > 0) {
        let queryString = selectedCategories.map(category => `category=${encodeURIComponent(category)}`).join('&');
        window.location.href = `selected_books.html?${queryString}`;
    } else {
        alert('Please select at least one category.');
    }
});