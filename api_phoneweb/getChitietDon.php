<?php

header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

$hostname = "localhost";
$username = "id21901405_minhg808";
$password = "Minhg@808";
$databasename = "id21901405_dienthoai";

$connect = mysqli_connect($hostname, $username, $password, $databasename);
mysqli_query($connect,"SET NAMES 'utf8'");

$iddon = $_POST['id'];

$query = "
SELECT chitietdon.ten, chitietdon.soluong, chitietdon.mausac, chitietdon.bonho, dondat.tongtien, chitietdon.linkanh, dondat.trangthai
FROM `chitietdon` 
INNER JOIN `dondat`
ON chitietdon.iddon = dondat.iddon
WHERE dondat.iddon = $iddon";

$data = mysqli_query($connect, $query);

$Array = array();

while($row = mysqli_fetch_assoc($data)){

    $Array[] = $row;
}
echo json_encode($Array);

?>