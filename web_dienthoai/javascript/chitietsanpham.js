// import { productsList } from "./data/products-all.js"

const linkProduct = document.querySelector(".product-link")
const productName = document.querySelector(".product-name")
const productPrice = document.querySelector(".product-price span")
const productBrand = document.querySelector(".product-brand b")
const productColor = document.querySelectorAll(".product-color span")
const productImg = document.querySelectorAll(".col-lg-6 img")
const productIntro = document.querySelector(".product-intro")
const productSize = document.querySelectorAll(".product-size span")
const productNumber = document.querySelector(".product-number")
const productScreen = document.querySelector(".product-screen b")
const productStorage = document.querySelectorAll(".product-stogare span")

const hedieuhanh = document.querySelector(".product-os b")
const camtruoc = document.querySelector(".product-camera-front b")
const camsau = document.querySelector(".product-camera-behind b")
const chip = document.querySelector(".product-chip b")
const ram = document.querySelector(".product-ram b")
const sim = document.querySelector(".product-sim b")
const pin = document.querySelector(".product-pin b")


const allProduct = JSON.parse(localStorage.getItem("tatcasanpham"))
console.log(productColor[3].value);

// var checkedLogin_addToCart = localStorage.getItem("checkLoginSuccess")


// const productBuy = document.querySelector(".product-buy-container")
var checkClickedImg = false
var checkClickedSize = false

var soluongProduct
var imgProduct
var sizeProduct


var productArray = []

// var productCartArray

// productCartArray = JSON.parse(localStorage.getItem("chuyen-den-gio-hang")) || []

// Lấy dữ liệu từ localStorage khi trang được tải hoặc tạo rỗng mảng
const cartItems = JSON.parse(localStorage.getItem("product")) || [];

if(cartItems != null) {
    console.log(cartItems)
}


// Lấy id từ tham số truy vấn trong URL
const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get("id");

function getColor() {
    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/getColorPhoneById.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: { id: id }, // Dữ liệu gửi lên server (có thể là một đối tượng JavaScript)
        success: function(response) {
            // Xử lý kết quả trả về từ server
            console.log('Server response:', response);
            response.forEach((item, index) => {
                productImg[index].src = item?.linkmausac
                productColor[index].textContent = item?.mausac
            })
        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
}
getColor()

function getStogare() {
    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/getStogarePhoneById.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: { id: id }, // Dữ liệu gửi lên server (có thể là một đối tượng JavaScript)
        success: function(response) {
            // Xử lý kết quả trả về từ server
            console.log('Server response:', response);
            response.forEach((item, index) => {
                productStorage[index].textContent = item?.bonho
            })
            productSize.forEach((size, index) => {
                if(size.textContent == '') {
                    size.style.display = "none"
                }
            })
        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
    
}
getStogare()

// allProduct.forEach(product => {
//     if(id == product.id) {
//         productName.textContent = product.name
//         productPrice.textContent = product.price
//         productBrand.textContent = product.brand
//         productScreen.textContent = product.screen

//     }
// })

fetch('https://dpna.000webhostapp.com/api/product_information.php')
  .then(response => response.json())
  .then(data => {
    // Duyệt qua mỗi đối tượng trong mảng
    data.forEach((product, index) => {
        if(id == product.iddienthoai) {

            productName.textContent = product.tendienthoai
            productPrice.textContent = product.gia
            productBrand.textContent = product.hang
            productScreen.textContent = product.manhinh

            hedieuhanh.textContent = product.hedieuhanh
            camtruoc.textContent = product.cameratruoc
            camsau.textContent = product.camerasau
            chip.textContent = product.chip
            ram.textContent = product.ram
            sim.textContent = product.sim
            pin.textContent = product.pin
    
        }

    });


    const productBtn = document.querySelector(".product-buy-now")
    const productAddCart = document.querySelector(".product-add-cart")

    // xử lý khi ấn vào nút mua hàng
    productBtn.addEventListener("click", function() {

        var checkedLogin_addToCart = localStorage.getItem("checkLoginSuccess") 

        if(checkedLogin_addToCart == "true") {

            if(!checkClickedImg) {
                Swal.fire('Vui lòng chọn màu điện thoại!','Ấn vào ảnh để chọn', 'errors')
            } else if(!checkClickedSize) {
                Swal.fire('Vui lòng chọn dung lượng lưu trữ !','', 'errors')
            }
            else {
                const product = {
                    img: imgProduct,
                    size: sizeProduct,
                    color: productColor[vitri].textContent,
                    sl: productNumber.value,
                    ID: id ,
                    name: productName.textContent,
                    gia: productPrice.textContent
                }
                productArray.push(product)
                // console.log(productArray)
                localStorage.removeItem("total")
                localStorage.setItem("chitietsanpham", JSON.stringify(productArray))
                window.location.href = "../html/muahang.html"
            }
        } else {
        Swal.fire('Vui lòng đăng nhập !', '', 'error')
        }

    })

  }
  
).catch(error => console.error('Error:', error));






let vitri = null
// Xử lý khi nhẫn vào ảnh
productImg.forEach((img, index) => {
    img.addEventListener("click", function() {
        checkClickedImg = true

        vitri = index
        console.log(vitri)

        imgProduct = img.src
        productImg.forEach((otherImg) => {
            otherImg.style.border = "none";
        });

        img.style.border = "2px blue solid"
        img.style.borderRadius = "20px"

        productColor.forEach((otherColor) => {
            otherColor.style.border = "none";
        });
        productColor[index].style.border = "2px blue solid"
        productColor[index].style.borderRadius = "2px"
        
    })
})

// Xử lý khi nhấn vào size
productSize.forEach((size, index) => {
    size.addEventListener("click", function() {
        sizeProduct = size.textContent
        checkClickedSize = true
        productSize.forEach((sizeOther, index) => {
            sizeOther.style.border = "1px black solid"
        })
        size.style.border = "2px blue solid"

    })
})


// const productBtn = document.querySelector(".product-buy-now")

// // xử lý khi ấn vào nút mua hàng
// productBtn.addEventListener("click", function() {

//     var checkedLogin_addToCart = localStorage.getItem("checkLoginSuccess") 

//     if(checkedLogin_addToCart == "true") {

//         if(!checkClickedImg) {
//             Swal.fire('Vui lòng chọn màu điện thoại!','Ấn vào ảnh để chọn', 'errors')
//         } else if(!checkClickedSize) {
//             Swal.fire('Vui lòng chọn dung lượng lưu trữ !','', 'errors')
//         }
//         else {
//             const product = {
//                 img: imgProduct,
//                 size: sizeProduct,
//                 color: productColor[vitri].textContent,
//                 sl: productNumber.value,
//                 ID: id ,
//                 name: productName.textContent,
//                 gia: productPrice.textContent
//             }
//             productArray.push(product)
//             // console.log(productArray)
//             localStorage.removeItem("total")
//             localStorage.setItem("chitietsanpham", JSON.stringify(productArray))
//             window.location.href = "../html/muahang.html"
//         }
//     } else {
//        Swal.fire('Vui lòng đăng nhập !', '', 'error')
//     }

// })

// xử lý khi ấn thêm sản phẩm vào giỏ hàng

const productAddCart = document.querySelector(".product-add-cart")

productAddCart.addEventListener("click", function() {

    var checkedLogin_addToCart = localStorage.getItem("checkLoginSuccess")

    console.log(checkedLogin_addToCart)

    if(checkedLogin_addToCart == "true") {

        if(!checkClickedImg) {
            Swal.fire('Vui lòng chọn màu điện thoại!','Ấn vào ảnh để chọn', 'errors')
        } else if(!checkClickedSize) {
            Swal.fire('Vui lòng chọn dung lượng lưu trữ !','', 'errors')
        }
        else {
    
            addToCart()
            Swal.fire('Thêm vào giỏ hàng thành công','', 'success')
    
    
        }
    } else {
       Swal.fire('Vui lòng đăng nhập !', '', 'error')
    }

})

//xử lý khi ấn thêm sản phẩm vào yêu thích
// const heartItems = JSON.parse(localStorage.getItem("like")) || [];
// const productLikeBtn = document.querySelector(".product-add-like")
// productLikeBtn.addEventListener("click", function() {

//     var checkedLogin_addToCart = localStorage.getItem("checkLoginSuccess")

//     if(checkedLogin_addToCart == "true") {
//         const productData = {
//             id: urlParams.get("id"),
//             name: productName.textContent,
//             img: productImg[0].src,
//             price: productPrice.textContent,
//             evaluate: "4.8"
//         };
//         // Thêm dữ liệu mới vào mảng cũ
//         heartItems.push(productData);
        
//         // Lưu mảng vào localStorage
//         localStorage.setItem("like", JSON.stringify(heartItems));
//         Swal.fire('Thêm vào yêu thích thành công','', 'success')
        
//     } else {
//        Swal.fire('Vui lòng đăng nhập !', '', 'error')
//     }

    

// })
// hàm thêm sản phẩm vào giỏ hàng
function addToCart() {

    const idTaiKhoan = JSON.parse(localStorage.getItem("id_User"))
    console.log(idTaiKhoan)

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/addPhoneToCartCT.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: { 
            idnguoidat: idTaiKhoan,
            anh: imgProduct,
            bonho: sizeProduct,
            mausac: productColor[vitri].textContent,
            soluong: productNumber.value,
            id: id ,
            ten: productName.textContent,
            gia: productPrice.textContent,
            tongtien: productPrice.textContent
    
        }, // Dữ liệu gửi lên server (có thể là một đối tượng JavaScript)
        success: function(response) {
            // Xử lý kết quả trả về từ server
            console.log('Server response:', response);
            // response.forEach((item, index) => {
            //     // productImg[index].src = item?.linkmausac
            //     // productColor[index].textContent = item?.mausac
            // })
        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
  }