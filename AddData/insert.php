<?php
   $connection = mysqli_connect("localhost","root", "" ,"adddata");

   $building = $_POST["building"];
   $floor = $_POST["floor"];
   $room = $_POST["room"];
   $intendant = $_POST["intendant"];
   $capacity = $_POST["capacity"];




   $sql = "INSERT INTO data(building,floor,room,intendant,capacity) VALUES ('$building','$floor','$room','$intendant','$capacity')";
   
   $result = mysqli_query($connection,$sql);

   if($result){
       echo "Data Inserted";
   }
else{
    echo "Failed";
}
mysqli_close($connection);

?>