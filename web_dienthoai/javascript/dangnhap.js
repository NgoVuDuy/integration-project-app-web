// Lấy mảng chứa thông tin người dùng
const userArray = JSON.parse(localStorage.getItem("userLogin"))

//Truy vấn các ô nhập liệu
const inputNameLogin = document.getElementById("name-login")
const inputPwdLogin = document.getElementById("pwd-login")

// Truy vấn nút đăng nhập
const loginBtn = document.getElementById("btn-login")
// Tạo biến kiểm tra đăng nhập
// var checkLogin = false

loginBtn.addEventListener("click", function(event) {
    event.preventDefault()
    // if(userArray != null) {
    //     // userArray.forEach((user, index) => {
    //         // if(inputNameLogin.value == user.user && inputPwdLogin.value == user.password) {
    //         //     checkLogin = true
    //         // } 
    //         dangnhap()
    //     // });
    //     // if(checkLogin) {
    //     //     localStorage.setItem("checkLoginSuccess", checkLogin)
    //     //     localStorage.setItem("user-name", inputNameLogin.value)

    //     //     window.location.href = "../index.html"
    //     // } else {
    //     //     Swal.fire("Tài khoản hoặc mật khẩu không hợp lệ !", "", "error")
    //     // }
    
    // }
    dangnhap()
})

console.log(userArray)
// Truy vấn con mắt xem mật khẩu
const eyeBtn = document.querySelector(".fa-eye") 

// Tạo chức năng xem mật khẩu trong 1s
eyeBtn.addEventListener("click", function() {
    inputPwdLogin.type = "text"
    setTimeout(() => {
        inputPwdLogin.type = "password";
    }, 1000);
})

function dangnhap() {

    var checkLogin = false
    var idUser 

    var ten, email, sodienthoai;

    $.ajax({
        url: 'https://dpna.000webhostapp.com/api/dangnhap.php', // Đường dẫn của server endpoint
        method: 'POST', // Phương thức HTTP

        success: function(response) {
            // Xử lý kết quả trả về từ server
            console.log('Server response:', response);
            response.forEach((user, index) => {

                console.log(user)

                if(user.tentaikhoan == inputNameLogin.value && user.matkhau == inputPwdLogin.value) {
                    checkLogin = true

                    idUser = user.idtaikhoan

                    ten = user.tentaikhoan
                    email = user.email
                    sodienthoai = user.sodienthoai

                    
                }
            })
            if(checkLogin) {
                localStorage.setItem("checkLoginSuccess", checkLogin)
                localStorage.setItem("user-name", inputNameLogin.value)
                localStorage.setItem("id_User", idUser)

                //
                localStorage.setItem("fixtentaikhoan", ten)
                localStorage.setItem("fixemail", email)
                localStorage.setItem("fixsodienthoai", sodienthoai)


                window.location.href = "../index.html"
            } else {
                Swal.fire("Tài khoản hoặc mật khẩu không hợp lệ !", "", "error")
            }
        },
        error: function(xhr, status, error) {
            // Xử lý lỗi nếu có
            console.error('Error:', error);
        }
    });
}