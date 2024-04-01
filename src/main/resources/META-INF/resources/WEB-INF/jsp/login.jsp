<html>
        <title>Login Page</title>
    <link rel="stylesheet" href="webjars\bootstrap\5.1.3\css\bootstrap.min.css">

    <body>
        <div class="container">
           <h1>Login to your account </h1>
            <pre>${ErrorMsg}</pre>
            <form class="form" method="POST">
            <fieldset>
                Name : <input type="text" name="name">
                Password : <input type="password" name="password">
                <input type="submit" class ="btn btn-success">
            </fieldset>
            </form>
        </div>

    </body>
    <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.min.js"></script>

    </html>