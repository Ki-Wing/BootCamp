document.addEventListener('DOMContentLoaded', function () {
    const productList = document.getElementById('product-list');

    const products = [
        {
            name: '상품명1',
            description: '상품 설명1',
            price: '9.99',
            imgSrc: 'https://via.placeholder.com/150'
        },
        {
            name: '상품명2',
            description: '상품 설명2',
            price: '19.99',
            imgSrc: 'https://via.placeholder.com/150'
        },
        {
            name: '상품명3',
            description: '상품 설명3',
            price: '29.99',
            imgSrc: 'https://via.placeholder.com/150'
        },
    ];

    products.forEach(product => {
        const productCard = document.createElement('div');
        productCard.classList.add('col-md-4');
        productCard.innerHTML = `
            <div class="card mb-4 shadow-sm">
                <img src="${product.imgSrc}" class="card-img-top" alt="${product.name}">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">${product.description}</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <span class="price">$${product.price}</span>
                        <a href="#" class="btn btn-sm btn-outline-primary">장바구니에 담기</a>
                    </div>
                </div>
            </div>
        `;
        productList.appendChild(productCard);
    });
});
