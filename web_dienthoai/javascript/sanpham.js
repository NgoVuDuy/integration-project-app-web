// import { productsList } from "./data/products-all.js";

const cartItems = JSON.parse(localStorage.getItem("tatcasanpham"))
console.log(cartItems);

const products = document.getElementById("products")

// truy xuất dữ liệu
fetch('https://dpna.000webhostapp.com/api/product_information.php')
  .then(response => response.json())
  .then(data => {
    // Duyệt qua mỗi đối tượng trong mảng
    data.forEach((product, index) => {
        // Thêm thông tin từ mỗi đối tượng vào mảng productsList
        //   productsList.push({
        //     id: phone.iddienthoai,
        //     name: phone.tendienthoai,
        //     price: phone.gia,
        //     screen: phone.manhinh,
        //     evaluate: "4.0",
        //     image: phone.linkdienthoai,
        //     brand:phone.hang,
        //   });
        const productHTML = `
        <div class="col-6 col-md-4 col-lg-3">
            <div class="sanpham">
                <div class="img_sanpham">
                    <a class="product-link" href="chitietsanpham.html?id=${product.iddienthoai}"><img src="${product.linkdienthoai}" alt="" width="100%" height="100%"></a>

                    <div class="product-cart ${product.iddienthoai}">
                        <i title="Thêm vào giỏ hàng" class="fa-solid fa-cart-arrow-down"></i>               
                    </div>
                    <div class="product-heart">
                    </div>
                </div>
                <div class="tensanpham">
                    <a class="product-link" href="chitietsanpham.html?id=${product.iddienthoai}"><p>${product.tendienthoai}</p></a>
                </div>
                <div class="danhgia">
                    <i class="fa-solid fa-star"><span>4.2</span></i>
                </div>
                <div class="brand-sale">
                    <p>${product.hang}</p>
                </div>
                <div class="giatien">
                    <p>${product.gia}</p>
                </div>
                <div class="buy-btn-sale">
                    <a class="product-link" href="chitietsanpham.html?id=${product.iddienthoai}"><button>Mua ngay</button></a>
                </div>
            </div>
        </div>
        `
        products.innerHTML += productHTML
    });
    // console.log(productsList);
    // localStorage.setItem("tatcasanpham", JSON.stringify(productsList));
    const cartsIcon = document.querySelectorAll(".product-cart")

    // Lấy dữ liệu từ localStorage khi trang được tải hoặc tạo rỗng mảng
    const cartItems = JSON.parse(localStorage.getItem("product")) || [];

    function addToCart(index) {

    const idTaiKhoan = JSON.parse(localStorage.getItem("id_User"))
    console.log(idTaiKhoan)
    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/addPhoneInCart.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: {
             id: index,
            idnguoidat: idTaiKhoan
        
        }, // Dữ liệu gửi lên server (có thể là một đối tượng JavaScript)
        success: function(response) {
            // Xử lý kết quả trả về từ server
            console.log('Server response:', response);
        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
    }

    // Thêm sự kiện click cho mỗi cartIcon
    cartsIcon.forEach((cartIcon, index) => {

    cartIcon.addEventListener("click", function() {
        // console.log(cartIcon.classList[1])

        const existingProduct = cartItems.find(item => item.id === index);
        var checkedLogin_addToCart = localStorage.getItem("checkLoginSuccess")

        console.log(checkedLogin_addToCart)

        if(checkedLogin_addToCart == "true") {
            //Kiểm tra tồn tại của sản phẩm
            if (existingProduct) {
            // Thông báo cho người dùng sản phẩm đã có trong giỏ hàng
            Toastify({
                text: "Sản phẩm này đã có sẵn trong giỏ hàng",
                duration: 3000,
                destination: "https://github.com/apvarun/toastify-js",
                newWindow: true,
                close: true,
                gravity: "top", 
                position: "right",
                stopOnFocus: true,
                style: {
                background: "linear-gradient(to right, #00b09b, #96c93d)",
                "margin-top": "80px",
                },
                onClick: function(){}
            }).showToast();
            }
        
            else {
        
            addToCart(cartIcon.classList[1])
        
            Toastify({
                text: "Chúc mừng bạn đã thêm sản phẩm vào giỏ hàng thành công.",
                duration: 3000,
                destination: "https://github.com/apvarun/toastify-js",
                newWindow: true,
                close: true,
                gravity: "top", 
                position: "right", 
                stopOnFocus: true, 
                style: {
                background: "linear-gradient(to right, #00b09b, #96c93d)",
                "margin-top": "80px",
                },
                onClick: function(){}
            }).showToast();
        
            }
        }else {
        Swal.fire('Vui lòng đăng nhập !', '', 'error')
        }

    });
    });
  }
  
).catch(error => console.error('Error:', error));


// Đỗ dữ liệu vào phần trang sản phẩm
// cartItems.forEach(product => {
//     const productHTML = `
//     <div class="col-6 col-md-4 col-lg-3">
//         <div class="sanpham">
//             <div class="img_sanpham">
//                 <a class="product-link" href="chitietsanpham.html?id=${product.id}"><img src="${product.image}" alt="" width="100%" height="100%"></a>

//                 <div class="product-cart ${product.id}">
//                     <i title="Thêm vào giỏ hàng" class="fa-solid fa-cart-arrow-down"></i>               
//                 </div>
//                 <div class="product-heart">
//                     <i title="Thêm vào yêu thích" class="fa-solid fa-heart"></i>               
//                 </div>
//             </div>
//             <div class="tensanpham">
//                 <a class="product-link" href="chitietsanpham.html?id=${product.id}"><p>${product.name}</p></a>
//             </div>
//             <div class="danhgia">
//                 <i class="fa-solid fa-star"><span>${product.evaluate}</span></i>
//             </div>
//             <div class="brand-sale">
//                 <p>${product.brand}</p>
//             </div>
//             <div class="giatien">
//                 <p>${product.price}</p>
//             </div>
//             <div class="buy-btn-sale">
//                 <a class="product-link" href="chitietsanpham.html?id=${product.id}"><button>Mua ngay</button></a>
//             </div>
//         </div>
//     </div>
//     `
//     products.innerHTML += productHTML
// });

const buyBtn = document.querySelectorAll(".product-link button") 

buyBtn.forEach((button, index) => {
    button.addEventListener("click", function() {
        localStorage.removeItem("total")
        localStorage.removeItem("chitietsanpham")
    })
})