<?php
 $scon=mysqli_connect('localhost','root','','sample');
if(isset($_POST['submit']))
{
    $nameErr="";
$name=$_POST['uname'];
$no=$_POST['phone'];
$email=$_POST['email'];
$pass=$_POST['pass'];
$flag=1;
if(!preg_match("/^[a-zA-Z ]*$/",$name)) {
    echo '<script type="text/javascript">alert("Invalid name format");</script>';
$flag=0;}
if(!preg_match("/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/",$email)) {
    echo '<script type="text/javascript">alert("Invalid email format");</script>';  
    $flag=0;
}
    if(!preg_match("/^[0-9]+$/",$no)) {
    echo '<script type="text/javascript">alert("Invalid phone number format");</script>';  
    $flag=0;
}
if($flag==1)
{
$sql="insert into login values('$name','$pass','$email','$no')";
if(mysqli_query($scon,$sql))
        {
        header("Location: index.php");
        exit;
    }
}
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
         <form action="register.php" method="post">
            <h1 style="text-align: center">REGISTRATION FORM</h1><?php
             $nameErr="";?>
            <table>
<tr><td><label>NAME</label></td><td><input type="text" name="uname"> <?php echo $nameErr; ?></td></tr> 
<tr><td><label>EMAIL</label></td><td><input type="text" name="email"> </td></tr>
<tr><td><label>PHONE NO</label></td><td><input type="text" name= "phone"></td></tr> 
<tr><td><label>PASSWORD</label></td><td><input type="password" name= "pass"></td></tr></table><br>
            <center><input type="submit" name="submit"></center>
        </form>
    </body>
</html>
