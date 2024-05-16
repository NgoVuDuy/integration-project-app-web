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
    $idnguoidat = $_POST['idnguoidat'];
    
    // Thực hiện truy vấn SQL
    $laydienthoai = "SELECT * FROM phone WHERE iddienthoai = $ID";
    $result = mysqli_query($connect, $laydienthoai);
    
    
    while($row = mysqli_fetch_assoc($result)) {
        
        $idgiohang = null; // Giá trị tùy thuộc vào cách bạn thiết kế cột idgiohang
        $tensp = $row['tendienthoai']; // Lấy giá trị từ cột 'tensp'
        $giasp = $row['gia']; // Lấy giá trị từ cột 'giasp'
        $soluong = "1"; // Mặc định số lượng là 1, bạn có thể thay đổi tùy theo logic của mình
        $mausac = $row['mausacdf']; // Lấy giá trị từ cột 'mausac'
        $bonho = $row['bonhodf']; // Lấy giá trị từ cột 'bonho'
        $tongtien = $row['gia']; // Tính tổng tiền (giá sản phẩm * số lượng)
        $linksp = $row['linkdienthoai']; // Lấy giá trị từ cột 'linksp'
        
        $query = "INSERT INTO cart 
        VALUES (null,'$idnguoidat', '$tensp', '$giasp', '$soluong', '$mausac', '$bonho', '$tongtien', '$linksp')";
        
        $insert_result = mysqli_query($connect, $query);
        
        if($insert_result) {
             echo json_encode("Thanh cong");
        } else {
             echo json_encode("That bai");
        }
        
}
    
}
?>
