<?php

$connection = mysqli_connect("localhost","root", "" ,"adddata");

$no = $_POST["no"];

$sql = "DELETE FROM data WHERE no='$no'";

$result = mysqli_query($connection,$sql);

if($result){
echo "Data Deleted";

}
else{
echo "Failed";
}
mysqli_close($connection);

?>