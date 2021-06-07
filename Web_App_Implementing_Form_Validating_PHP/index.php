<?php
 $scon=mysqli_connect('localhost','root','','sample');
    if(!$scon)
    {
        die('Error Connecting to Database');
    }
session_start();
if(isset($_POST['submit']))
{
$name=$_POST['uname'];
$_SESSION['user']=$name;
$pass=$_POST['pass'];
if(!empty($_POST['uname']) && !empty($_POST['pass']))
{
$row=mysqli_query($scon,"select * from login where username='$name'");
$res=mysqli_fetch_array($row);
$pass1=$res['password'];
if($pass==$pass1)
{
      header("Location: success.php");
        exit;
}
else
{
      $errMSG="Invalid data <br>";
       
}
}
}
if(isset($_POST['register']))
{
    header("Location: register.php");
        exit;
}
?>

<!DOCTYPE html>
<html>
            <style>
        form {
    width: 300px;
    margin: 0 auto;
}
    </style>
    <body>
         <form action="index.php" method="post">
            <h1 style="text-align: center">LOGIN FORM</h1>
            <table>
 <tr><td><label>NAME</label></td><td><input type="text" name="uname"> </td></tr> 
<tr><td><label>PASSWORD</label></td><td><input type="password" name= "pass"></td></tr></table><br>
            <center><input type="submit" name="submit" value="LOGIN"></center>
             <?php if(isset($errMSG)) echo '<script type="text/javascript">alert("Invalid userID or password");</script>'; ?><br>
             <center><input type="submit" name="register" style="height:20px;width:200px" value="REGISTER"></center>
        </form>
    </body>
</html>
