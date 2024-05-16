// import { productsList } from "./data/products-all.js";

const containerProduct = document.querySelector(".buy-container")
const totalProduct = document.querySelectorAll(".buy-total-value")

const productArray = JSON.parse(localStorage.getItem("chitietsanpham"))
console.log(productArray)

const url = new URLSearchParams(window.location.search)
var idProduct = url.get("id")

// const idTaiKhoan = JSON.parse(localStorage.getItem("id_User"))
// console.log(idTaiKhoan)

// Lấy dữ liệu từ localStorage khi trang được tải hoặc tạo rỗng mảng
// const cartItems = JSON.parse(localStorage.getItem("tatcasanpham")) || [];

// if(cartItems != null) {
//     console.log(cartItems)
// }

function datHangDon() {

    const idTaiKhoan = JSON.parse(localStorage.getItem("id_User"))
    console.log(idTaiKhoan)

    console.log(productArray[0].ID)
    console.log("Khong ten")
    console.log(productArray[0].sl)
    console.log(productArray[0].color)
    console.log(productArray[0].size)
    console.log(totalProduct[0].textContent)
    console.log("0 VND")
    console.log(totalProduct[1].textContent)
    console.log(productArray[0].img)


    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/dathangdon.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: { 
            idnguoidat: idTaiKhoan,
            id: productArray[0].ID ,
            tendon: productArray[0].name,
            soluong: productArray[0].sl,
            mausac: productArray[0].color,
            bonho: productArray[0].size,
            tamtinh: totalProduct[0].textContent,
            phivanchuyen: "0 VND",
            tongtien: totalProduct[1].textContent,
            linkanh: productArray[0].img

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

//Đổ dữ liệu phần chi tiết sản phẩm
if(productArray != null) {
    // cartItems.forEach((product, index) => {
        // if(productArray[0].ID == product.id) {
            var priceTotal = parseFloat(productArray[0].gia) * parseFloat(productArray[0].sl)
            var formatTotal =  priceTotal.toFixed(6).slice(0, -3) + "." + priceTotal.toFixed(6).slice(-3) 

            totalProduct[0].textContent = formatTotal
            totalProduct[1].textContent = formatTotal
            var productHTML = `
                <div class= "row mt-4">
                    <div class="col-12 col-lg-6 col-md-6 col-sm-6 buy-flex">
                        <img src="${productArray[0].img}" alt="" width="20%">
                        <p>${productArray[0].name}</p>
                    </div>
                    <div class="col-12 col-lg-2 col-md-2 col-sm-2 cart-flex">
                        <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Đơn giá: </b></span>
                        <p>${productArray[0].gia}</p>
                    </div>
                    <div class="col-12 col-lg-1 col-md-1 col-sm-1 cart-flex">
                        <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Số lượng: </b></span>
                        <p>${productArray[0].sl}</p>
                    </div>
                    <div class="col-12 col-lg-2 col-md-2 col-sm-2 cart-flex">
                        <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Màu sắc: </b></span>
                        <p>${productArray[0].color}</p>
                    </div>
                    <div class="col-12 col-lg-1 col-md-1 col-sm-1 cart-flex">
                        <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Kích thước: </b></span>
                        <p>${productArray[0].size}</p>
                    </div>
                
                
                </div>
                
            `
                containerProduct.innerHTML += productHTML
        // }
    // })
}


// Truy vấn các thẻ cần thiết để đổ dữ liệu mua hàng cho người dùng
const name_user = document.getElementById("buy-name")
const email_user = document.getElementById("buy-email")
const sdt_user = document.getElementById("buy-sdt")
const  address_user = document.getElementById("buy-address")

// Lấy mảng chứa thông tin người dùng
const userArray = JSON.parse(localStorage.getItem("userLogin"))

console.log(userArray)

//
const nameUser = document.querySelector(".header-user-name")

// var checkedLogin_BuyProduct = localStorage.getItem("checkLoginSuccess")
//Truy vấn ô mã giảm giá

const codeSale = document.getElementById("code-sale")
const buyBtn = document.querySelector(".buy-btn-order")

var checkedLogin_BuyProduct = localStorage.getItem("checkLoginSuccess")

// Xử lý sự kiện đặt hàng cho một đơn hàng
buyBtn.addEventListener("click", function() {


    var checkedLogin_BuyProduct1 = localStorage.getItem("checkLoginSuccess")

    if(checkedLogin_BuyProduct1 == "true") {
        if(codeSale.value.length > 0) {
            Swal.fire('Mã giảm giá không hợp lệ !', '', 'error')
        } else {
            Swal.fire({
                title: 'Bạn có chắc muốn đặt hàng không ?',
                showDenyButton: true,
                showCancelButton: true,
                confirmButtonText: 'Có',
                denyButtonText: `Không`,
              }).then((result) => {
                /* Read more about isConfirmed, isDenied below */
                if (result.isConfirmed) {
                    Swal.fire('Đặt hàng thành công', '', 'success').then((result) => {
                        if(result.isConfirmed)
                        localStorage.removeItem("total")
                        // location.reload()
                        if(productArray != null) {
                            datHangDon()

                        } else {
                            datHangNhieu()
                            deleteAllCart(1)
                        }
                        // window.location.href ="../index.html"
                        window.location.href ="quanlydonhang.html"

                    })
                } else if (result.isDenied) {
                  Swal.fire('Đặt hàng thất bại !', '', 'error')
                }
            })

        }

    } else {
        Swal.fire('Vui lòng đăng nhập !', '', 'error')
    }
})

// Kiểm tra người dùng đăng nhập trước khi đăng nhập
if(checkedLogin_BuyProduct == "true") {
    // userArray.forEach(user => {
    //     if(user.user == nameUser.textContent) {
            // name_user.value = user.user
            // email_user.value = user.email
            // sdt_user.value = user.phoneNumber
    
    //     }
    // });
    var ten = localStorage.getItem("fixtentaikhoan");
    var email = localStorage.getItem("fixemail");
    var sodienthoai = localStorage.getItem("fixsodienthoai");

    name_user.value = ten
    email_user.value = email
    sdt_user.value = sodienthoai



}

// đây là phần cho giỏ hàng
var thanhtoanArray = JSON.parse(localStorage.getItem("total"))
// const containerProduct = document.querySelector(".buy-container")
// const totalProduct = document.querySelectorAll(".buy-total-value")

console.log(thanhtoanArray)
//Đổ dữ liệu phần giỏ hàng
if(thanhtoanArray != null) {
    totalProduct[0].textContent = thanhtoanArray[0]
    totalProduct[1].textContent = thanhtoanArray[0]

    thanhtoanArray.forEach((product, index) => {
        if(index > 0) {
            var productHTML = `
            <div class= "row mt-4">
                <div class="col-12 col-lg-6 col-md-6 col-sm-6 buy-flex">
                    <img src="${product.img}" alt="" width="20%">
                    <p>${product.name}</p>
                
                </div>
                <div class="col-12 col-lg-2 col-md-2 col-sm-2 cart-flex">
                    <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Đơn giá: </b></span>
                    <p>${product.productCore}</p>
                </div>
                <div class="col-12 col-lg-1 col-md-1 col-sm-1 cart-flex"> 
                    <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Số lượng: </b></span>
                    <p>${product.sl}</p>
                </div>
                <div class="col-12 col-lg-2 col-md-2 col-sm-2 cart-flex">
                    <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Màu sắc: </b></span>
                    <p>${product.color}</p>
                </div>
                <div class="col-12 col-lg-1 col-md-1 col-sm-1 cart-flex">
                    <span class= "d-block d-lg-none d-md-none d-sm-none"><b>Size: </b></span>
                    <p>${product.storage}</p>
                </div>
            
            </div>
            
            `
            containerProduct.innerHTML += productHTML
        }
    })
}
console.log(thanhtoanArray)

function datHangNhieu() {

    const idTaiKhoan = JSON.parse(localStorage.getItem("id_User"))
    console.log(idTaiKhoan)

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/dathang.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: {
            data: JSON.stringify(thanhtoanArray),
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

function deleteAllCart(id) {
    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/deleteAllCart.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: { id: id }, // Dữ liệu gửi lên server (có thể là một đối tượng JavaScript)
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