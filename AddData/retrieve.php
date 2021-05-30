<?php

$connection = mysqli_connect("localhost","root", "" ,"adddata");

$result = array();
$result['data'] = array();
$select = "SELECT *from data";
$response = mysqli_query($connection,$select);

while($row = mysqli_fetch_array($response))
{
   $index['no']         = $row['0'];
   $index['building']    = $row['1'];
   $index['floor']       = $row['2'];
   $index['room']        = $row['3'];
   $index['intendant']   = $row['4'];
   $index['capacity']    = $row['5'];


   array_push($result['data'],$index);
}

    $result["Success"] = "1";
    echo json_encode($result);
    mysqli_close($connection);

?>
