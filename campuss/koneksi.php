<?php
$con = new mysqli("localhost","root","","campuss");

if ($con-> connect_errno) {
	echo "failed to Connet to MySQL:". $con->connet_error;
	exit();
} 
?>