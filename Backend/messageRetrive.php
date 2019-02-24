<?php
require "./conn.php";
$time = $_POST["time"];
$result = mysqli_query($conn,"SELECT * FROM messages WHERE time>\"{$time}\" ORDER BY time;");
//$result = mysqli_fetch_array($result,MYSQLI_ASSOC);
foreach($result as $current){
    echo $current["message"] . "~~" . $current["time"] . "\n";

}

?>