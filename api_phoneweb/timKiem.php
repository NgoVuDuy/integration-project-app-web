<?php

function removeAccents($str) {
    return preg_replace('/[\x{0300}-\x{036f}]/u', '', Normalizer::normalize($str, Normalizer::FORM_D));
}

header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

$hostname = "localhost";
$username = "id21901405_minhg808";
$password = "Minhg@808";
$databasename = "id21901405_dienthoai";

$connect = mysqli_connect($hostname, $username, $password, $databasename);
mysqli_query($connect,"SET NAMES 'utf8'");

$ketqua = $_POST['ketqua'];
// $ketqua = "iphone";

$ketqua = removeAccents($ketqua); // Xử lý chuỗi tìm kiếm trước khi sử dụng

$ketqua = mysqli_real_escape_string($connect, $ketqua); // Đảm bảo an toàn trước khi sử dụng trong truy vấn SQL

$query = "SELECT * FROM phone WHERE tendienthoai LIKE '%$ketqua%'"; // Sử dụng LIKE để so sánh chuỗi tìm kiếm với tên sản phẩm

$data = mysqli_query($connect, $query);

$Array = array();

while($row = mysqli_fetch_assoc($data)){

    $Array[] = $row;
}
echo json_encode($Array);

?>
