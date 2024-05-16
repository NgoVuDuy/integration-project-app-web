
const cartContainer = document.querySelector(".cart-container")
const clearBtn = document.querySelector(".cart-clear-all")
// const cartItems = JSON.parse(localStorage.getItem("product"))
const total = document.querySelector(".total")
const ThanhToanBtn = document.querySelector(".thanhtoan")

console.log(window.location.pathname)

const thanhtoanArray = []
// Lấy dữ liệu và đổ vào giỏ hàng
function giohang() {

    const idTaiKhoan = JSON.parse(localStorage.getItem("id_User"))
    console.log(idTaiKhoan)

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/getCart.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: {
            idnguoidat: idTaiKhoan
        },

        success: function(data) {
            // Xử lý kết quả trả về từ server
            if(data != null && data.length != 0) {
                total.style.display = "block"
                    
                data.forEach((phone, index) => {
        
                    const productHTML = `
                        <div class="row mt-2">
                            <div class="col-lg-3 col-md-3">
                                <div class="cart-product">
                                    <img src="${phone.linksp}" alt="" width="25%">
                                    <p>${phone.tensp}</p>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-2 cart-flex">
                                <span class= "d-block d-lg-none d-md-none"><b>Đơn giá: </b></span>
                                <p>${phone.giasp}</p>
                            </div>
                            <div class="col-lg-2 col-md-2">
                            <div class="container-number">
                                <span class= "d-block d-lg-none d-md-none"><b>Số lượng: </b></span>
                                <input type="number" value="${phone.soluong}" min="1">
                            </div>
                            </div>
                            <div class="col-lg-2 col-md-2 cart-flex">
                                <span class= "d-block d-lg-none d-md-none"><b>Màu sắc: </b></span>
                                <p class="productCartColor">${phone.mausac}</p>
                            </div>
                            <div class="col-lg-2 col-md-2 cart-flex">
                                <span class= "d-block d-lg-none d-md-none"><b>Tổng tiền: </b></span>
                                <p class="sum">${phone.tongtien}</p>
                            </div>
                            <div class="col-lg-1 col-md-12">
                                <button class= "${phone.idgiohang} btn-delete-cart">Xóa</button>
                            </div>
                        </div>
                        <hr>
                    `;
                    cartContainer.innerHTML += productHTML;
                })
                // Xử lý xóa từng sản phẩm
                const deleteProduct = document.querySelectorAll(".btn-delete-cart")
                console.log(deleteProduct[0].classList[0])
                
                deleteProduct.forEach((deleteBtn, index) => {
                    deleteBtn.addEventListener("click", function() {
                        // if(cartItems != null || cartItems.length != 0) {
                        //     cartItems.splice(index, 1)
                        //     localStorage.setItem("product", JSON.stringify(cartItems));
                        //     // localStorage.setItem("chuyen-den-gio-hang", JSON.stringify(productCartArray));
                        //     location.reload()
                        // }
                        // if(productCartArray != null || productCartArray.length != 0) {
                        //     productCartArray.splice(index, 1)
                        // }
                                    
                        pushIDDelete(deleteBtn.classList[0])
                        window.location.reload()
                        
                    })
                })
        
                // Xử lý xóa toàn bộ sản phẩm trong giỏ hàng
                clearBtn.addEventListener("click", function() {
                    if(data === null || data.length == 0) {
                        Swal.fire({
                            icon: "error",
                            title: "Oops...",
                            text: "Bạn chưa có sản phẩm nào trong giỏ hàng",
                            footer: '<a href="sanpham.html">Bạn có muốn xem sản phẩm?</a>'
                        });
                    } else {
                        Swal.fire({
                            title: "Are you sure?",
                            text: "Bạn có chắc muốn xóa toàn bộ sản phẩm trong giỏ hàng",
                            icon: "warning",
                            showCancelButton: true,
                            confirmButtonColor: "#3085d6",
                            cancelButtonColor: "#d33",
                            confirmButtonText: "Yes, delete it!"
                        }).then((result) => {
                            if (result.isConfirmed) {
                                //Xóa toàn bộ sản phẩm trong giỏ hàng
                                // localStorage.removeItem("product")
                                // localStorage.removeItem("chuyen-den-gio-hang")
                                deleteAllCart(1)
        
                            Swal.fire({
                                title: "Deleted!",
                                text: "Bạn đã xóa thành công",
                                icon: "success"
                            }).then(() => {
                                    // Reload trang sau khi xác nhận xóa
                                    location.reload();
                                });
                            }
                        });
        
                    }
                })
        
                const inputNum = document.querySelectorAll(".mt-2 .col-lg-2 input")
                const sum = document.querySelectorAll(".sum")
        
                // var sumDefault = 0.0
                // sum.forEach((sumItems, index) => {
                //     sumDefault += parseFloat(sumItems.textContent)
                //     // console.log(sumItems.textContent)
                // })
                var tongmacdinh = 0
                sum.forEach((item, index) => {
                    tongmacdinh += parseInt(item.textContent.replace(/\./g, ""))
        
                })
                total.textContent = tongmacdinh.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
                
                console.log(inputNum)
                // Xử lý lại số tiền khi người dùng thay đổi số lượng sản phẩm
                inputNum.forEach((input, index) => {
        
                    // var format = sumDefault.toFixed(6).slice(0, -3) + "." + sumDefault.toFixed(6).slice(-3) + " VND"
                    // total.textContent = format
        
                    input.addEventListener('input', function(event) {
        
                        // console.log(data[index].giasp)
                        var tong = 0
        
        
                        // console.log(input.value)
                        // console.log(sum[index].textContent.replace(/\./g, ""))
        
                        var result = parseInt(data[index].giasp.replace(/\./g, "")) * input.value
                        var formattedResult = result.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
                        sum[index].textContent =  formattedResult
        
                        sum.forEach((item, index) => {
                            tong += parseInt(item.textContent.replace(/\./g, ""))
        
                        })
        
                        total.textContent = tong.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
                    })
                })
        
        
        
                const productsColor = document.querySelectorAll(".productCartColor")
                console.log(productsColor)
                
                // xử lý khi ấn vào nút button
                // Đưa mảng chứa thông tin các sản phẩm lên bộ nhớ cục bộ
                ThanhToanBtn.addEventListener("click", function(event) {
                    thanhtoanArray.push(total.textContent)
                    if(data != null && data.length != 0) {
                        localStorage.removeItem("chitietsanpham")
                        data.forEach((cartItem, index) => {
                            const valueProduct = {
                                id: cartItem.idgiohang,
                                name: cartItem.tensp,
                                img: cartItem.linksp,
                                sl: inputNum[index].value,
                                productCore: sum[index].textContent,
                                color: productsColor[index].textContent,
                                storage: cartItem.bonho
                            }
                            thanhtoanArray.push(valueProduct)
                            console.log(thanhtoanArray)
                    
                        })
                    } 
                
                
                    localStorage.setItem("total", JSON.stringify(thanhtoanArray))
                
                    if((data == null || data.length == 0)) {
                        event.preventDefault()
                    }
                
                })
            }
            else {
                total.style.display = "none"
                ThanhToanBtn.style.display = "none"
        
            }
        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
}
giohang()

// Thêm code lấy dữ liệu giỏ hàng
// fetch('https://dpna.000webhostapp.com/api/getCart.php')
// .then(response => response.json())
// .then(data => {
//     console.log(data)
//     if(data != null && data.length != 0) {
//         total.style.display = "block"
            
//         data.forEach((phone, index) => {

//             const productHTML = `
//                 <div class="row mt-2">
//                     <div class="col-lg-3 col-md-3">
//                         <div class="cart-product">
//                             <img src="${phone.linksp}" alt="" width="25%">
//                             <p>${phone.tensp}</p>
//                         </div>
//                     </div>
//                     <div class="col-lg-2 col-md-2 cart-flex">
//                         <span class= "d-block d-lg-none d-md-none"><b>Đơn giá: </b></span>
//                         <p>${phone.giasp}</p>
//                     </div>
//                     <div class="col-lg-2 col-md-2">
//                     <div class="container-number">
//                         <span class= "d-block d-lg-none d-md-none"><b>Số lượng: </b></span>
//                         <input type="number" value="${phone.soluong}" min="1">
//                     </div>
//                     </div>
//                     <div class="col-lg-2 col-md-2 cart-flex">
//                         <span class= "d-block d-lg-none d-md-none"><b>Màu sắc: </b></span>
//                         <p class="productCartColor">${phone.mausac}</p>
//                     </div>
//                     <div class="col-lg-2 col-md-2 cart-flex">
//                         <span class= "d-block d-lg-none d-md-none"><b>Tổng tiền: </b></span>
//                         <p class="sum">${phone.tongtien}</p>
//                     </div>
//                     <div class="col-lg-1 col-md-12">
//                         <button class= "${phone.idgiohang} btn-delete-cart">Xóa</button>
//                     </div>
//                 </div>
//                 <hr>
//             `;
//             cartContainer.innerHTML += productHTML;
//         })
//         // Xử lý xóa từng sản phẩm
//         const deleteProduct = document.querySelectorAll(".btn-delete-cart")
//         console.log(deleteProduct[0].classList[0])
        
//         deleteProduct.forEach((deleteBtn, index) => {
//             deleteBtn.addEventListener("click", function() {
//                 // if(cartItems != null || cartItems.length != 0) {
//                 //     cartItems.splice(index, 1)
//                 //     localStorage.setItem("product", JSON.stringify(cartItems));
//                 //     // localStorage.setItem("chuyen-den-gio-hang", JSON.stringify(productCartArray));
//                 //     location.reload()
//                 // }
//                 // if(productCartArray != null || productCartArray.length != 0) {
//                 //     productCartArray.splice(index, 1)
//                 // }
                            
//                 pushIDDelete(deleteBtn.classList[0])
//                 window.location.reload()
                
//             })
//         })

//         // Xử lý xóa toàn bộ sản phẩm trong giỏ hàng
//         clearBtn.addEventListener("click", function() {
//             if(data === null || data.length == 0) {
//                 Swal.fire({
//                     icon: "error",
//                     title: "Oops...",
//                     text: "Bạn chưa có sản phẩm nào trong giỏ hàng",
//                     footer: '<a href="sanpham.html">Bạn có muốn xem sản phẩm?</a>'
//                 });
//             } else {
//                 Swal.fire({
//                     title: "Are you sure?",
//                     text: "Bạn có chắc muốn xóa toàn bộ sản phẩm trong giỏ hàng",
//                     icon: "warning",
//                     showCancelButton: true,
//                     confirmButtonColor: "#3085d6",
//                     cancelButtonColor: "#d33",
//                     confirmButtonText: "Yes, delete it!"
//                 }).then((result) => {
//                     if (result.isConfirmed) {
//                         //Xóa toàn bộ sản phẩm trong giỏ hàng
//                         // localStorage.removeItem("product")
//                         // localStorage.removeItem("chuyen-den-gio-hang")
//                         deleteAllCart(1)

//                     Swal.fire({
//                         title: "Deleted!",
//                         text: "Bạn đã xóa thành công",
//                         icon: "success"
//                     }).then(() => {
//                             // Reload trang sau khi xác nhận xóa
//                             location.reload();
//                         });
//                     }
//                 });

//             }
//         })

//         const inputNum = document.querySelectorAll(".mt-2 .col-lg-2 input")
//         const sum = document.querySelectorAll(".sum")

//         // var sumDefault = 0.0
//         // sum.forEach((sumItems, index) => {
//         //     sumDefault += parseFloat(sumItems.textContent)
//         //     // console.log(sumItems.textContent)
//         // })
//         var tongmacdinh = 0
//         sum.forEach((item, index) => {
//             tongmacdinh += parseInt(item.textContent.replace(/\./g, ""))

//         })
//         total.textContent = tongmacdinh.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
        
//         console.log(inputNum)
//         // Xử lý lại số tiền khi người dùng thay đổi số lượng sản phẩm
//         inputNum.forEach((input, index) => {

//             // var format = sumDefault.toFixed(6).slice(0, -3) + "." + sumDefault.toFixed(6).slice(-3) + " VND"
//             // total.textContent = format

//             input.addEventListener('input', function(event) {

//                 // console.log(data[index].giasp)
//                 var tong = 0


//                 // console.log(input.value)
//                 // console.log(sum[index].textContent.replace(/\./g, ""))

//                 var result = parseInt(data[index].giasp.replace(/\./g, "")) * input.value
//                 var formattedResult = result.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
//                 sum[index].textContent =  formattedResult

//                 sum.forEach((item, index) => {
//                     tong += parseInt(item.textContent.replace(/\./g, ""))

//                 })

//                 total.textContent = tong.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
//             })
//         })



//         const productsColor = document.querySelectorAll(".productCartColor")
//         console.log(productsColor)
        
//         // xử lý khi ấn vào nút button
//         // Đưa mảng chứa thông tin các sản phẩm lên bộ nhớ cục bộ
//         ThanhToanBtn.addEventListener("click", function(event) {
//             thanhtoanArray.push(total.textContent)
//             if(data != null && data.length != 0) {
//                 localStorage.removeItem("chitietsanpham")
//                 data.forEach((cartItem, index) => {
//                     const valueProduct = {
//                         id: cartItem.idgiohang,
//                         name: cartItem.tensp,
//                         img: cartItem.linksp,
//                         sl: inputNum[index].value,
//                         productCore: sum[index].textContent,
//                         color: productsColor[index].textContent,
//                         storage: cartItem.bonho
//                     }
//                     thanhtoanArray.push(valueProduct)
//                     console.log(thanhtoanArray)
            
//                 })
//             } 
        
        
//             localStorage.setItem("total", JSON.stringify(thanhtoanArray))
        
//             if((data == null || data.length == 0)) {
//                 event.preventDefault()
//             }
        
//         })








//     }
//     else {
//         total.style.display = "none"
//         ThanhToanBtn.style.display = "none"

//     }
//   }
  
// ).catch(error => console.error('Error:', error));

function pushIDDelete(id) {
    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/deleteCart.php', // Đường dẫn của server endpoint
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

