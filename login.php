<?php
// https://www.youtube.com/watch?v=4e8be8xseqE
    $dp = "CRUD_5";
    $user = $_POST["nombre"];
    $pass = $_POST["contrasena"];
    $host = "localhost";

    $conn = mysqli_connect($host, $user, $pass, $db);
    if($conn){
        $q = "select * from user where nombre like '$user' and contrasena like '$pass'";
        $result = mysqli_query($conn, $q);

        if(mysqli_num_rows($result) > 0){
            echo "login exitoso";
        }else{
            echo "usuario o contraseña equivocada";
        }
    }
    else{
        echo "conexion fracasada";
    }
?>