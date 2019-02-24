<?php
require "./conn.php";
$id = $_POST["id"];
$type = $_POST["type"];
$data = $_POST["data"];
$retrive = $_POST["retrive"];
if(mysqli_num_rows(mysqli_query($conn,"SELECT * FROM users WHERE id = \"{$id}\";"))==0){
    if($retrive=="true"){
        echo "User not yet added...Cannot retrive";
        return;
    }
  echo  mysqli_query($conn,"INSERT INTO users (id) VALUES(\"{$id}\");") ."\n";

}
if($retrive=="true"){
$result = mysqli_query($conn,"SELECT * FROM users WHERE id=\"{$id}\";");
foreach($result as $current){
    echo  $current[$type];
}

}
else{

if($type=="mood"){

echo mysqli_query($conn,"UPDATE users SET mood={$data} WHERE id=\"{$id}\";");
}

else{
    echo mysqli_query($conn,"UPDATE  users SET boards=\"{$data}\" WHERE id=\"{$id}\";");
    }

}








?>