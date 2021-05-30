<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>เเสดงข้อมูลอัพเดทเพิ่มเติมของอาคาร</title>
</head>
<body bgcolor ="#FFFFCC">
<?php
   $connection = mysqli_connect("localhost","root", "" ,"adddata");
   $query = "SELECT * FROM data";
   $result = mysqli_query($connection,$query);
   if($result){
    echo "";
}
else{
 echo "Failed";
}
?>

<table border="0.5">
     <caption> Update Data New !! </caption>
     
     <thead>
     <tr></tr>     
     <tr></tr>
     <tr></tr>

         <tr bgcolor="#FF99CC">
             <th>no</th>
             <th>building</th>
             <th>floor</th>
             <th>room</th>
             <th>intendant</th>
             <th>capacity</th>
         </tr>
    </thead>
    <tbody>
        <?php foreach ($result as $row)  {  ?>
        <tr bgcolor="#FFCCFF">
             <td><?php echo $row['no'];?></td>
             <td><?php echo $row['building'];?></td>
             <td><?php echo $row['floor'];?></td>
             <td><?php echo $row['room'];?></td>
             <td><?php echo $row['intendant'];?></td>
             <td><?php echo $row['capacity'];?></td>

        </tr>
     <?php   }  ?>

    </tbody> 
</table>
    <?php mysqli_close($connection); ?>
</body>
</html>