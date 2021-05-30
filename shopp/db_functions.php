<?php

class DB_Functions{
    private  $conn;

    function  __construct()
    {
        require_once 'db_connect.php';
        $db = new DB_Connect();
        $this->conn = $db->connect();

    }

    function __destruct()
    {


    }

    /*check user exists*/

    function  checkExistsUser($phone)
    {
        $stmt = $this->conn->prepare("SELECT * FROM User Where Phone=?");
        $stmt->bind_param("s",$phone);
        $stmt->execute();
        $stmt->store_result();

        if($stmt->num_rows > 0)
        {
            $stmt->close();
            return  true;
        }
        else{
            $stmt->close();
            return  false;

        }
    }

    /* register new user
    return show error msg */

    public function  registerNewUser($phone,$name,$birthdate,$address)
    {
        $stmt = $this->conn->prepare("INSERT INTO User(Phone,Name,Birthdate,Address) VALUES(?,?,?,?)");
        $stmt->bind_param("ssss",$phone,$name,$birthdate,$address);
        $result=$stmt->execute();
        $stmt->close();

        if($result)
        {
            $stmt=$this->conn->prepare("SELECT * FROM User WHERE Phone = ?");
            $stmt->bind_param("s",$phone);
            $stmt->execute();
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();
            return $user;
        }
        else
            return false;
    }


    //get user infor
    public function getUserInformation($phone)
    {
        $stmt = $this->conn->prepare("SELECT * FROM User WHERE Phone=?");
        $stmt->bind_param("s",$phone);

        if($stmt->execute())
        {
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();

            return $user;
        }
        else
            return NULL;
    }


    public function getBanners()
    {
       $result = $this->conn->query("SELECT * FROM Banner ORDER BY ID LIMIT 2");

       $banners = array();

       while($item = $result->fetch_assoc())
           $banners[] = $item;
       return $banners;
    }



}


?>