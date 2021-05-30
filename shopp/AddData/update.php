<?php

$connection = mysqli_connect("localhost","root", "" ,"adddata");

$no = $_POST["no"];
$building = $_POST["building"];
$floor = $_POST["floor"];
$room = $_POST["room"];
$intendant = $_POST["intendant"];
$capacity = $_POST["capacity"];

$sql = "UPDATE data SET building = '$building', floor = '$floor', room = '$room', intendant  = '$intendant', capacity = '$capacity'
 WHERE no = '$no' ";

 $result = mysqli_query($connection,$sql);

 if($result){
     echo "Data Updated";
 }
 else{
     echo "Failed";
 }

 mysqli_close($connection);

 ?>
