// import {productsList } from "./data/products-all.js";

// const cartItems = JSON.parse(localStorage.getItem("tatcasanpham"))
// console.log(cartItems);

// Truy vấn ô nhập liệu và nút tìm kiếm
const input = document.querySelector(".form-control")
const search_btn = document.querySelector(".glass-search")

// Hàm xóa dấu tiếng việt
function removeAccents(str) {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}

search_btn.addEventListener("click", function() {

    if(input.value.length == 0) {
        alert("Thông tin tìm kiếm không hợp lệ")
    } else {

        var result = removeAccents(input.value.toLocaleLowerCase())
        localStorage.setItem("ketquatimkiem", JSON.stringify(result))

        if(window.location.pathname == "/ShoeWeb/") {

            window.location.href = "./html/timkiem.html"

        }
        else if(window.location.pathname == "/ShoeWeb/index.html") {

            window.location.href = "./html/timkiem.html"

        }
        else if(window.location.pathname == "/") {

            window.location.href = "./html/timkiem.html"

        }else if(window.location.pathname == "/index.html") {

            window.location.href = "./html/timkiem.html"

        }else if(window.location.pathname == "/Shoe/") {

            window.location.href = "./html/timkiem.html"

        }else if(window.location.pathname == "/Shoe/index.html") {

            window.location.href = "./html/timkiem.html"

        } else {
            
            window.location.href = "timkiem.html"
        }
    }


})


// Xét sự kiện khi nhấn vào nút tìm kiếm
// search_btn.addEventListener("click", function() {
//     //Tạo mảng lưu trữ kết quả tìm kiếm
//     var rsSearch = [];
//     //Tạo mảng lưu trữ thông tin sản phẩm tìm kiếm
//     var productSearch = [];

//     // Đưa từ khóa tìm kiếm vào mảng kết quả
//     rsSearch.push(input.value)

//     // Duyệt qua mảng các sản phẩm
//     cartItems.forEach((product, index) => {
//         // Đưa các sản phẩm tìm được vào mảng sản phẩm
//         if(removeAccents(product.name.toLocaleLowerCase()).includes(removeAccents(input.value.toLocaleLowerCase()))) {
//             productSearch.push(cartItems[index])
//         }
//     })
//     // Đưa mảng sản phẩm vào mảng kết quả

//     rsSearch.push(productSearch)
    
//     // Đưa mảng kết quả lên bộ nhớ cục bộ
//     localStorage.setItem("searchResult", JSON.stringify(rsSearch))

//     //Chuyển đến trang tìm kiếm
//     if(rsSearch[0] == []) {
//         alert("Thông tin tìm kiếm không hợp lệ")
//     } else {
        // if(window.location.pathname == "/ShoeWeb/") {

        //     window.location.href = "./html/timkiem.html"

        // }
        // else if(window.location.pathname == "/ShoeWeb/index.html") {

        //     window.location.href = "./html/timkiem.html"

        // }
        // else if(window.location.pathname == "/") {

        //     window.location.href = "./html/timkiem.html"

        // }else if(window.location.pathname == "/index.html") {

        //     window.location.href = "./html/timkiem.html"

        // }else if(window.location.pathname == "/Shoe/") {

        //     window.location.href = "./html/timkiem.html"

        // }else if(window.location.pathname == "/Shoe/index.html") {

        //     window.location.href = "./html/timkiem.html"

        // } else {
            
        //     window.location.href = "timkiem.html"
        // }
//     }
// })

// console.log(window.location.href)

