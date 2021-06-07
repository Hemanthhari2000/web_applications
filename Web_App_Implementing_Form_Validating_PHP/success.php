<?php
session_start();
$user=$_SESSION['user'];
?>
<!DOCTYPE html>
<html>
<body>
<h1 style="text-align: center">Welcome <?php echo $user; ?></h1>
</body>
</html>
