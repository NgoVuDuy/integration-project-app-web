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

$id = $_POST['id'];
$tendon = $_POST['tendon'];
$soluong = $_POST['soluong'];
$mausac = $_POST['mausac'];
$bonho = $_POST['bonho'];
$tamtinh = $_POST['tamtinh'];
$phivanchuyen = $_POST['phivanchuyen'];
$tongtien = $_POST['tongtien'];
$linkanh = $_POST['linkanh'];
$idnguoidat = $_POST['idnguoidat'];

$query = "INSERT INTO dondat VALUES (null,'$idnguoidat','$tongtien','0','$tongtien', 'Chưa nhận hàng')";
$result = mysqli_query($connect, $query);

// Kiểm tra và xử lý lỗi nếu có
// if(!$result) {
//     echo json_encode(array('error' => 'Error inserting data into dondat table'));
// }
$inserted_id = mysqli_insert_id($connect);

// Thêm dữ liệu vào bảng chitietdon
$query1 = "INSERT INTO chitietdon VALUES (null,'$inserted_id', '$id', '$tendon', '$soluong', '$mausac', '$bonho', '$linkanh')";
$result1 = mysqli_query($connect, $query1);

?>
