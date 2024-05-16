<?php
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');
header('Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token');

$hostname = "localhost";
$username = "id21901405_minhg808";
$password = "Minhg@808";
$databasename = "id21901405_dienthoai";

$connect = mysqli_connect($hostname, $username, $password, $databasename);
mysqli_query($connect, "SET NAMES 'utf8'");

// Kiểm tra xem dữ liệu POST có tồn tại không
if (isset($_POST['id'])) {
    // Lấy giá trị id từ dữ liệu POST
    $ID = $_POST['id'];
    
    // Thực hiện truy vấn SQL
    $deleteCart = "DELETE FROM cart WHERE $ID";
    $result = mysqli_query($connect, $deleteCart);
    
    if($result) {
        echo json_encode("Thanh cong");
    } else {
        echo json_encode("That bai");
    }
    
} else {
    echo json_encode("Khong nhan duoc id");
}
?>