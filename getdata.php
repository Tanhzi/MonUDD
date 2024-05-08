<?php
//cho phep truy cap full du lieu
header('Access-Control-Allow-Origin: *');
//khai bao user, pass
$host="localhost";
$u="root";
$p="";
$db="a";
//thuc hien ket noi 
$con=new mysqli($host,$u,$p,$db);
//khai bao lenh truy van du lieu
$sql="select * from mytable";
//thuc thi truy van
$result=$con->query($sql);
//doc ket qua
while($row[]=$result->fetch_assoc())//doc theo dong
{
    $json=json_encode($row);//chuyen thanh json
}
//in ra man hinh
echo '{"products":'.$json.'}';
//dong ket noi
$con->close();