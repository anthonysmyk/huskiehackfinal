<?php
require "./conn.php";
$message=$_POST["message"];
$time= $_POST["time"];
echo $time;
echo mysqli_query($conn,"INSERT INTO messages (message,time) VALUES(\"{$message}\",\"{$time}\");");



?>