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

$iduser = $_POST['iduser'];

$query = "
DELETE FROM taikhoan 
WHERE idtaikhoan = $iduser";

$result = mysqli_query($connect, $query);

if($result) {
    echo json_encode("Thanh cong");

} else {
    echo json_encode("That bai");
}
?>
