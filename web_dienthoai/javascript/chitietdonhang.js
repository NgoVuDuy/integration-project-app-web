const cartTrangThai = document.querySelector(".cart-trangthai")

const url = new URLSearchParams(window.location.search)
var idProduct = url.get("id")

console.log(idProduct)


function getchitietdon() {

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/getChitietDon.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: {
            id: idProduct
        }, // Dữ liệu gửi lên server (có thể là một đối tượng JavaScript)

        success: function(response) {
            // Xử lý kết quả trả về từ server
            console.log('Server response:', response);

            const cartContainer = document.querySelector(".cart-container")
            const tong = document.querySelector(".tong")

            tong.textContent =` ${response[0].tongtien}`
            if(response[0].trangthai == 'Đã nhận hàng') {
                cartTrangThai.style.display = "none"
            }

            response.forEach((phone, index) =>  {

                const productHTML = `
                <div class="row mt-2">
                    <div class="col-lg-5 col-md-5">
                        <div class="cart-product">
                            <img src="${phone.linkanh}" alt="" width="25%">
                            <p>${phone.ten}</p>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-2 cart-flex">
                        <span class= "d-block d-lg-none d-md-none"><b>Số lượng: </b></span>
                        <p>${phone.soluong}</p>
                    </div>
                    <div class="col-lg-2 col-md-2">
                    <div class="container-number">
                        <span class= "d-block d-lg-none d-md-none"><b>Màu sắc: </b></span>
                        <p>${phone.mausac}</p>
                    </div>
                    </div>
                    <div class="col-lg-2 col-md-2 cart-flex">
                        <span class= "d-block d-lg-none d-md-none"><b>Bộ nhớ: </b></span>
                        <p class="productCartColor">${phone.bonho}</p>
                    </div>
                    
                    
                </div>
                <hr>
            `;
            cartContainer.innerHTML += productHTML;
            })




        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
}
getchitietdon()


cartTrangThai.addEventListener("click", function() {

    Swal.fire({
        title: "Bạn đã nhận được hàng ?",
        // text: "Bạn có chắc muốn xóa toàn bộ sản phẩm trong giỏ hàng",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Đã nhận hàng"
    }).then((result) => {
        if (result.isConfirmed) {

            updateTrangThai()
             


        Swal.fire({
            title: "Thành công",
            text: "Đã cập nhật trạng thái đơn hàng",
            icon: "success"
        }).then(() => {
                // Reload trang sau khi xác nhận xóa
                // location.reload();
                window.location.href = "quanlydonhang.html"
            });
        }
    });


    // window.location.href = "quanlydonhang.html"
})


function updateTrangThai() {

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/updateTrangThaiDon.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP
        data: {
            id: idProduct
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