import { productsHot } from "./data/products-popular.js";
import {productsSale} from "./data/products-sale.js"

const productListHot = document.getElementById("productListHot");
const productListSale = document.getElementById("productListSale");

const cartItems = JSON.parse(localStorage.getItem("tatcasanpham"))
console.log(cartItems);

// truy xuất dữ liệu
fetch('https://dpna.000webhostapp.com/api/product_information.php')
  .then(response => response.json())
  .then(data => {
    // Duyệt qua mỗi đối tượng trong mảng
    data.forEach((product, index) => {

        if(index <= 5) {
            const productHTML = `
                <div class="col-7 col-sm-5 col-lg-4 col-md-4">
                    <div class="sanpham">
                        <div class="img_sanpham">
                            <a class="product-link" href="html/chitietsanpham.html?id=${product.iddienthoai}"><img src="${product.linkdienthoai}" alt="" width="100%" height="100%"></a>
        
                            <div class="product-cart ${product.iddienthoai}">
                                <i title="Thêm vào giỏ hàng" class="fa-solid fa-cart-arrow-down"></i>               
                            </div>
                            <div class="product-heart">
                            </div>
                        </div>
                        <div class="tensanpham">
                            <a class="product-link" href="html/chitietsanpham.html?id=${product.iddienthoai}"><p>${product.tendienthoai}</p></a>
                        </div>
                        <div class="danhgia">
                            <i class="fa-solid fa-star"><span>4.2</span></i>
                        </div>
                        <div class="brand">
                            <p>NiKe</p>
                        </div>
                        <div class="giatien">
                            <p>${product.gia}</p>
                        </div>
                        <div class="buy-btn">
                            <a class="product-link" href="html/chitietsanpham.html?id=${product.iddienthoai}"><button>Mua ngay</button></a>
                        </div>
                    </div>
                </div>
            `;

            productListHot.innerHTML += productHTML;
        }

        const productHTML = `
            <div class="col-7 col-lg-2 col-md-4 col-sm-5">
                <div class="sanpham">
                    <div class="img_sanpham">
                        <a class="product-link" href="html/chitietsanpham.html?id=${product.iddienthoai}"><img src="${product.linkdienthoai}" alt="" width="100%" height="100%"></a>
                        <img class="sale" src="images/sale.png" alt="Sale" width="35%">
                    </div>
                    <div class="tensanpham">
                        <a class="product-link" href="html/chitietsanpham.html?id=${product.iddienthoai}"><p>${product.tendienthoai}</p></a>
                    </div>
                    <div class="danhgia">
                        <i class="fa-solid fa-star"><span>4.1</span></i>
                    </div>
                    <div class="brand-sale">
                        <p>NiKe</p>
                    </div>
                    <div class="giatien">
                        <p>${product.gia}</p>
                    </div>
                    <div class="buy-btn-sale">
                        <a class="product-link" href="html/chitietsanpham.html?id=${product.iddienthoai}"><button>Mua ngay</button></a>
                    </div>
                </div>
            </div>`;
            productListSale.innerHTML += productHTML;

        });
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



// cartItems.forEach((product, index) => {
//     if(index <= 5) {

//         const productHTML = `
//             <div class="col-7 col-sm-5 col-lg-4 col-md-4">
//                 <div class="sanpham">
//                     <div class="img_sanpham">
//                         <a class="product-link" href="html/chitietsanpham.html?id=${product.id}"><img src="${product.image}" alt="" width="100%" height="100%"></a>
    
//                         <div class="product-cart ${product.id}">
//                             <i title="Thêm vào giỏ hàng" class="fa-solid fa-cart-arrow-down"></i>               
//                         </div>
//                         <div class="product-heart">
//                             <i title="Thêm vào yêu thích" class="fa-solid fa-heart"></i>               
//                         </div>
//                     </div>
//                     <div class="tensanpham">
//                         <a class="product-link" href="html/chitietsanpham.html?id=${product.id}"><p>${product.name}</p></a>
//                     </div>
//                     <div class="danhgia">
//                         <i class="fa-solid fa-star"><span>${product.evaluate}</span></i>
//                     </div>
//                     <div class="brand">
//                         <p>NiKe</p>
//                     </div>
//                     <div class="giatien">
//                         <p>${product.price}</p>
//                     </div>
//                     <div class="buy-btn">
//                         <a class="product-link" href="html/chitietsanpham.html?id=${product.id}"><button>Mua ngay</button></a>
//                     </div>
//                 </div>
//             </div>
//         `;

//         productListHot.innerHTML += productHTML;
//     }
// });

// cartItems.forEach((product, index) => {
//     const productHTML = `
//     <div class="col-7 col-lg-2 col-md-4 col-sm-5">
//         <div class="sanpham">
//             <div class="img_sanpham">
//                 <a class="product-link" href="html/chitietsanpham.html?id=${product.id}"><img src="${product.image}" alt="" width="100%" height="100%"></a>
//                 <img class="sale" src="images/sale.png" alt="Sale" width="35%">
//             </div>
//             <div class="tensanpham">
//                 <a class="product-link" href="html/chitietsanpham.html?id=${product.id}"><p>${product.name}</p></a>
//             </div>
//             <div class="danhgia">
//                 <i class="fa-solid fa-star"><span>${product.evaluate}</span></i>
//             </div>
//             <div class="brand-sale">
//                 <p>NiKe</p>
//             </div>
//             <div class="giatien">
//                 <p>${product.price}</p>
//             </div>
//             <div class="buy-btn-sale">
//                 <a class="product-link" href="html/chitietsanpham.html?id=${product.id}"><button>Mua ngay</button></a>
//             </div>
//         </div>
//     </div>
//     `;
//     productListSale.innerHTML += productHTML;
// });

// Lấy các phần tử buy-btn
var buyBtn = document.querySelectorAll(".buy-btn");
// Thêm sự kiện resize để theo dõi kích thước màn hình
window.addEventListener("resize", function() {
    // Lấy chiều rộng của màn hình
    var windowWidth = window.innerWidth;

    // Kiểm tra điều kiện và thay đổi lớp tương ứng
    if (windowWidth < 1400) {
        // Nếu màn hình nhỏ hơn 1400px, thì thêm lớp buy-btn-sale và xóa lớp buy-btn
        // buyBtn.classList.add("buy-btn-sale");
        // buyBtn.classList.remove("buy-btn");
        buyBtn.forEach( btn => {
            btn.classList.add("buy-btn-sale")
            btn.classList.remove("buy-btn")

        })
    } else {
        // Nếu màn hình lớn hơn hoặc bằng 1400px, thì thêm lớp buy-btn và xóa lớp buy-btn-sale
        buyBtn.forEach( btn => {
            btn.classList.add("buy-btn")
            btn.classList.remove("buy-btn-sale")

        })
    }
});

// Gọi sự kiện resize lần đầu để xác định lớp ban đầu
window.dispatchEvent(new Event("resize"));

const buyBtn1 = document.querySelectorAll(".product-link button") 
buyBtn1.forEach((button, index) => {
    button.addEventListener("click", function() {
        localStorage.removeItem("total")
        localStorage.removeItem("chitietsanpham")
    })
})