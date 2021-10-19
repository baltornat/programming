<! doctype HTML>
<html>
    <head>
        <title>Magic site</title>
    </head>

    <body>
        <h1>Login</h1>

        <form action="" method="POST">
            Username: <input type="text" name="username">
            Password: <input type="password" name="password">
            <input type="submit">
        </form>

        <?php
            if(isset($_POST["username"]) && isset($_POST["password"])){
                if(md5($_POST["password"]) == "0e243290500679059135881845663163"){
                    echo "<b>You win!</b>";
                }else{
                    echo "Try again";
                }
            }
        ?>

        <br>
        <h6>Sicurezza e Privatezza lab.</h6>
    </body>
</html>