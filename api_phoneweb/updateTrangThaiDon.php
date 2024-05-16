<?php

header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

$hostname = "localhost";
$username = "id21901405_minhg808";
$password = "Minhg@808";
$databasename = "id21901405_dienthoai";

$connect = mysqli_connect($hostname, $username, $password, $databasename);

mysqli_query($connect,"SET NAMES 'utf8'");

$id = $_POST['id'];

$query = "
UPDATE dondat 
SET dondat.trangthai = 'Đã nhận hàng'
WHERE dondat.iddon = $id
";

$data = mysqli_query($connect, $query);

if($data) {
    echo json_encode("Thanh cong");
} else {
    echo json_encode("That bai");
}

// $Array = array();

// while($row = mysqli_fetch_assoc($data)){

//     $Array[] = $row;
// }
// echo json_encode($Array);

?>