<?php

header('Content-Type: application/json');

// Cho phép truy cập từ tất cả các domain
header('Access-Control-Allow-Origin: *');

// Cho phép các phương thức yêu cầu khác nhau
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');

// Cho phép các tiêu đề tùy chỉnh
header('Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token');

$hostname = "localhost";
$username = "id21901405_minhg808";
$password = "Minhg@808";
$databasename = "id21901405_dienthoai";

$connect = mysqli_connect($hostname, $username, $password, $databasename);

mysqli_query($connect,"SET NAMES 'utf8'");

// Lấy giá trị id từ dữ liệu GET
$ID = $_POST['id'];

$query = "
SELECT * 
FROM `color` 
INNER JOIN `phone`
ON color.iddienthoai = phone.iddienthoai
WHERE phone.iddienthoai = $ID";

$result = mysqli_query($connect, $query);

if($result) {
    // Trả về kết quả dưới dạng JSON
    $rows = mysqli_fetch_all($result, MYSQLI_ASSOC);
    echo json_encode($rows);
} else {
    // Trả về thông báo lỗi
    echo json_encode(array('error' => 'Query execution failed'));
}

?>
