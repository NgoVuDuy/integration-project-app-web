// Dùng ajax
function getDonDat() {

    const idTaiKhoan = JSON.parse(localStorage.getItem("id_User"))
    console.log(idTaiKhoan)

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/getDonDat.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: {
            idnguoidat: idTaiKhoan
        },

        success: function(data) {
            // Xử lý kết quả trả về từ server
            const cartContainer = document.querySelector(".cart-container")

            console.log(data)
            if(data != null && data.length != 0) {
                    
                data.forEach((phone, index) => {
        
                    const productHTML = `
                        <div class="row mt-2">
        
                        <div class="col-lg-2 col-md-2">
                            <div class="container-number">
                                <span class= "d-block d-lg-none d-md-none"><b>Mã đơn: </b></span>
                                <p>${phone.iddon}</p>
                            </div>
                        </div>
        
                            <div class="col-lg-2 col-md-2">
                                <div class="container-number">
                                    <span class= "d-block d-lg-none d-md-none"><b>Tạm tính: </b></span>
                                    <p>${phone.tamtinh}</p>
                                </div>
                            </div>
        
                            <div class="col-lg-2 col-md-2 cart-flex">
                                <span class= "d-block d-lg-none d-md-none"><b>Phí vận chuyển: </b></span>
                                <p class="productCartColor">${phone.phivanchuyen}</p>
                            </div>
        
                            <div class="col-lg-2 col-md-2 cart-flex">
                                <span class= "d-block d-lg-none d-md-none"><b>Tổng tiền: </b></span>
                                <p class="sum">${phone.tongtien}</p>
                            </div>
        
                            
                            <div class="col-lg-2 col-md-2 cart-flex">
                                <span class= "d-block d-lg-none d-md-none"><b>Trạng thái: </b></span>
                                <p>${phone.trangthai}</p>
                            </div>
                            
                            <div class="col-lg-2 col-md-12">
                                <a href="chitietdonhang.html?id=${phone.iddon}"> <button class= "${phone.iddon} btn-delete-cart">Xem chi tiết</button></a>
                            </div>
                            </div>
                        <hr>
                    `;
                    cartContainer.innerHTML += productHTML;
                })
           }

        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
}
getDonDat()

// Thêm code lấy dữ liệu giỏ hàng
// fetch('https://dpna.000webhostapp.com/api/getDonDat.php')
//   .then(response => response.json())
//   .then(data => {

//     const cartContainer = document.querySelector(".cart-container")

//     console.log(data)
//     if(data != null && data.length != 0) {
            
//         data.forEach((phone, index) => {

//             const productHTML = `
//                 <div class="row mt-2">

//                 <div class="col-lg-2 col-md-2">
//                     <div class="container-number">
//                         <span class= "d-block d-lg-none d-md-none"><b>Mã đơn: </b></span>
//                         <p>${phone.iddon}</p>
//                     </div>
//                 </div>

//                     <div class="col-lg-2 col-md-2">
//                         <div class="container-number">
//                             <span class= "d-block d-lg-none d-md-none"><b>Tạm tính: </b></span>
//                             <p>${phone.tamtinh}</p>
//                         </div>
//                     </div>

//                     <div class="col-lg-2 col-md-2 cart-flex">
//                         <span class= "d-block d-lg-none d-md-none"><b>Phí vận chuyển: </b></span>
//                         <p class="productCartColor">${phone.phivanchuyen}</p>
//                     </div>

//                     <div class="col-lg-2 col-md-2 cart-flex">
//                         <span class= "d-block d-lg-none d-md-none"><b>Tổng tiền: </b></span>
//                         <p class="sum">${phone.tongtien}</p>
//                     </div>

                    
//                     <div class="col-lg-2 col-md-2 cart-flex">
//                         <span class= "d-block d-lg-none d-md-none"><b>Trạng thái: </b></span>
//                         <p>${phone.trangthai}</p>
//                     </div>
                    
//                     <div class="col-lg-2 col-md-12">
//                         <a href="chitietdonhang.html?id=${phone.iddon}"> <button class= "${phone.iddon} btn-delete-cart">Xem chi tiết</button></a>
//                     </div>
//                     </div>
//                 <hr>
//             `;
//             cartContainer.innerHTML += productHTML;
//         })
//    }}
  
// ).catch(error => console.error('Error:', error));