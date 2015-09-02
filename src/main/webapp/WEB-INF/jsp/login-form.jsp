<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="tablecss/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="tablecss/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <style type="text/css"> #errormsg{color: red;}  </style>
    </head>
  <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="../../index2.html"><b>Login</b>Form</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
		<br>
	   <form class="three" action="authentication.html" method="post" autocomplete="off">
	
	   	<c:choose>
		   	<c:when test="${ERROR_MSG == 'EF'}">
			<marquee direction="down" height="20" behavior="slide"> 
				<a id="errormsg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Invalid User Name or Password</a>
			</marquee>
				
			</c:when>
			   	<c:when test="${ERROR_MSG == 'NF'}">
			   	<marquee direction="down" height="20" behavior="slide"> 
		      		<a id="errormsg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter User Name and Password</a>
			   </marquee>
		    </c:when>
	   	</c:choose>
	
		   <div class="form-group has-feedback">
		   <label>User Name</label>
            <input type="email" class="form-control" name="userName" value="mahesh@gmail.com" placeholder="example@rooman.net" required="required"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
          <label>Password</label>
            <input type="password" name="password" value="sadanandr" class="form-control" placeholder="Password" required="required"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span><br>
          
		 
              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
         </div>
        </form>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="tablecss/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="tablecss/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="tablecss/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>