<?php
require "./conn.php";
$boardName = $_POST["boardName"];
if(mysqli_num_rows(mysqli_query($conn,"SELECT * FROM boards WHERE name = \"{$boardName}\";"))!=0){
    echo "Already exits";
}
else{
    echo "Data reached!";
echo mysqli_query($conn, "INSERT INTO boards (name) VALUES(\"{$boardName}\");");  

 echo mysqli_query($conn,"CREATE TABLE {$boardName} (message TEXT(600), time BigInt(8));");


}



?>