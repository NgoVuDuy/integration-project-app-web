<?php

header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

$hostname = "localhost";
$username = "id21901405_minhg808";
$password = "Minhg@808";
$databasename = "id21901405_dienthoai";

$connect = mysqli_connect($hostname, $username, $password, $databasename);

mysqli_query($connect,"SET NAMES 'utf8'");

$idnguoidat = $_POST['idnguoidat'];

$query = "SELECT * FROM cart WHERE idnguoidat = $idnguoidat";

$data = mysqli_query($connect, $query);

$Array = array();

while($row = mysqli_fetch_assoc($data)){

    $Array[] = $row;
}
echo json_encode($Array);

?>