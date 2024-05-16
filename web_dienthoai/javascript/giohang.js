

const cartsIcon = document.querySelectorAll(".product-cart")
// Lấy dữ liệu từ localStorage khi trang được tải hoặc tạo rỗng mảng
const cartItems = JSON.parse(localStorage.getItem("product")) || [];

// code thêm dữ liệu vào giỏ hàng
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