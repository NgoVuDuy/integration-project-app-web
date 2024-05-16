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

// Kiểm tra xem dữ liệu đã được gửi từ client chưa
if(isset($_POST['data'])) {

    // Nhận dữ liệu dưới dạng JSON từ client và chuyển đổi thành mảng PHP
    $data = json_decode($_POST['data'], true);
    
    $idnguoidat = $_POST['idnguoidat'];

    // Kiểm tra xem dữ liệu đã được chuyển đổi thành mảng thành công hay không
    if($data !== null && is_array($data)) {
        // Lấy dữ liệu
        
        $tongtien = $data[0]; // Ví dụ: Lấy giá
        
        // Chuẩn bị câu truy vấn SQL và thực thi
        $query = "INSERT INTO dondat VALUES (null,'$idnguoidat','$tongtien','0','$tongtien', 'Chưa nhận hàng')";
        $result = mysqli_query($connect, $query);
        
        // Kiểm tra và xử lý lỗi nếu có
        if(!$result) {
            echo json_encode(array('error' => 'Error inserting data into dondat table'));
            exit();
        }
        
        $inserted_id = mysqli_insert_id($connect);
        

        foreach($data as $key => $item) {
            if($key == 0) {
                // // Nếu vị trí số 0 là kiểu chuỗi, bạn có thể xử lý nó ở đây
                // $tongtien = $item; // Ví dụ: Lấy giá
                
                // // Chuẩn bị câu truy vấn SQL và thực thi
                // $query = "INSERT INTO dondat VALUES (null,'$tongtien','0','$tongtien', 'false')";
                // $result = mysqli_query($connect, $query);
                
                // // Kiểm tra và xử lý lỗi nếu có
                // if(!$result) {
                //     echo json_encode(array('error' => 'Error inserting data into dondat table'));
                //     exit();
                // }
                
                // Lấy ID vừa được tạo ra
                // $inserted_id = mysqli_insert_id($connect);
            } else {
                // Xử lý dữ liệu từ các phần tử khác
                $id = $item['id'];
                $tendon = $item['name'];
                $soluong = $item['sl'];
                $mausac = $item['color'];
                $bonho = $item['storage'];
                $linkanh = $item['img'];
                
                // Thêm dữ liệu vào bảng chitietdon
                $query1 = "INSERT INTO chitietdon VALUES (null,'$inserted_id', '$id', '$tendon', '$soluong', '$mausac', '$bonho', '$linkanh')";
                $result = mysqli_query($connect, $query1);
                
                // Kiểm tra và xử lý lỗi nếu có
                if(!$result) {
                    echo json_encode(array('error' => 'Error inserting data into chitietdon table'));
                    exit();
                }
            }
        }

        echo json_encode(array('success' => true)); // Phản hồi về client
    } else {
        echo json_encode(array('error' => 'Invalid JSON data')); // Phản hồi về client nếu dữ liệu không hợp lệ
    }

} else {
    echo json_encode(array('error' => 'Missing data from client')); // Phản hồi về client nếu dữ liệu không tồn tại
}
?>
