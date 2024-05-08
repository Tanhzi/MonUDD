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
//insert
$sql="update mytable set search_image='1 update' where styleid='2'";
//thuc thi truy van
$result=$con->query($sql);
if($result==true)
{
    echo "cap nhat thanh cong";
}
$con->close();