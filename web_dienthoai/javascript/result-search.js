function timkiem() {
    
    // Lấy mảng kết quả tìm kiếm từ bộ nhớ cục bộ
    const result = JSON.parse(localStorage.getItem("ketquatimkiem"));
    console.log(result);
    
    const container = document.querySelector(".container .row");
    const title = document.querySelector("h2");

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/timKiem.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: { ketqua: result }, // Truyền đối tượng JavaScript chứa kết quả tìm kiếm lên server
        dataType: 'json', // Định dạng dữ liệu trả về từ server (nếu không xác định, jQuery sẽ cố gắng tự đoán)
        success: function(response) {
            // Xử lý kết quả trả về từ server
            console.log('Server response:', response);

            title.textContent = `Kết quả tìm kiếm cho '${result}' là:`

            response.forEach((data, index) => {

                var searchHTML = `
                <div class="col-6 col-lg-3 col-md-4">
                    <div class="sanpham">
                        <div class="img_sanpham">
                            <a class="product-link" href="chitietsanpham.html?id=${data.iddienthoai}">
                                <img src="${data.linkdienthoai}" alt="" width="100%" height="100%">
                            </a>  

                            <div class="product-cart ${data.iddienthoai}">
                                <i title="Thêm vào giỏ hàng" class="fa-solid fa-cart-arrow-down"></i>               
                            </div>
                        </div>
                        <div class="tensanpham">
                            <a class="product-link" href="chitietsanpham.html?id=${data.iddienthoai}"><p>${data.tendienthoai}</p></a>
                        </div>
                        <div class="danhgia">
                            <i class="fa-solid fa-star"><span>4.2</span></i>
                        </div>
                        <div class="brand">
                            <p>${data.hang}</p>
                        </div>
                        <div class="giatien">
                            <p>${data.gia}</p>
                        </div>
                        <div class="buy-btn-sale">
                            <a class="product-link" href="chitietsanpham.html?id=${data.iddienthoai}"><button>Mua ngay</button></a>
                        </div>
                    </div>
                </div>
            `
            container.innerHTML += searchHTML
            })

            // sự kiện thêm sản phẩm vào giỏ hàng

            const cartsIcon = document.querySelectorAll(".product-cart")
            // Lấy dữ liệu từ localStorage khi trang được tải hoặc tạo rỗng mảng
            const cartItems = JSON.parse(localStorage.getItem("product")) || [];

            function addToCart(index) {
            $.ajax({
                url: 'https://dpna.000webhostapp.com/api/addPhoneInCart.php', // Đường dẫn của server endpoint
                method: 'POST', // Phương thức HTTP
                data: { id: index}, // Dữ liệu gửi lên server (có thể là một đối tượng JavaScript)
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


        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
}

timkiem();


// // Kiểm tra và đổ dữ liệu vào trang tìm kiếm
// if(results != null) {
//     if(results[1].length == 0) {
//         title.textContent = `Không tìm thấy kết quả cho '${results[0]}' là:`
//     }
//     else {
//         title.textContent = `Kết quả tìm kiếm cho '${results[0]}' là:`
//         results[1].forEach((result, index) => {
            // var searchHTML = `
            //     <div class="col-6 col-lg-3 col-md-4">
            //         <div class="sanpham">
            //             <div class="img_sanpham">
            //                 <a class="product-link" href="chitietsanpham.html?id=${result.id}">
            //                     <img src="${result.image}" alt="" width="100%" height="100%">
            //                 </a>  
            //             </div>
            //             <div class="tensanpham">
            //                 <a class="product-link" href="chitietsanpham.html?id=${result.id}"><p>${result.name}</p></a>
            //             </div>
            //             <div class="danhgia">
            //                 <i class="fa-solid fa-star"><span>${result.evaluate}</span></i>
            //             </div>
            //             <div class="brand">
            //                 <p>NiKe</p>
            //             </div>
            //             <div class="giatien">
            //                 <p>${result.price}</p>
            //             </div>
            //             <div class="buy-btn-sale">
            //                 <a class="product-link" href="chitietsanpham.html?id=${result.id}"><button>Mua ngay</button></a>
            //             </div>
            //         </div>
            //     </div>
            // `
            // container.innerHTML += searchHTML
//         });
        
//     }
// }
