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

    
$idgiohang = null; 
$tensp = $_POST['ten'];
$giasp = $_POST['gia']; //1
$soluong = $_POST['soluong']; //1
$mausac = $_POST['mausac'];
$bonho = $_POST['bonho']; 
$tongtien = $_POST['tongtien'];
$linksp = $_POST['anh'];
$idnguoidat = $_POST['idnguoidat'];

$format_giasp = str_replace('.', '', $giasp);

$new_tong_tien = intval($format_giasp) * intval($soluong);

$formatted_number = number_format($new_tong_tien, 0, ',', '.');

$query = "INSERT INTO cart 
VALUES (null,'$idnguoidat', '$tensp', '$giasp', '$soluong', '$mausac', '$bonho', '$formatted_number', '$linksp')";

$insert_result = mysqli_query($connect, $query);

if($insert_result) {
     echo json_encode("Thanh cong");
} else {
     echo json_encode("That bai");
}
    
    
?>
