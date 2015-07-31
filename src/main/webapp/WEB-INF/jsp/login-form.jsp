<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	
<head>
<title>Login Form</title>
<style type="text/css">
html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,dl,dt,dd,ol,nav ul,nav li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,ruby,section,summary,time,mark,audio,video{margin:0;padding:0;border:0;font-size:100%;font:inherit;vertical-align:baseline;}
article, aside, details, figcaption, figure,footer, header, hgroup, menu, nav, section {display: block;}
ol,ul{list-style:none;margin:0px;padding:0px;}

a{text-decoration:none;}
.txt-rt{text-align:right;}/* text align right */
.txt-lt{text-align:left;}/* text align left */
.txt-center{text-align:center;}/* text align center */
.float-rt{float:right;}/* float right */
.float-lt{float:left;}/* float left */
.clear{clear:both;}/* clear float */
.pos-relative{position:relative;}/* Position Relative */
.pos-absolute{position:absolute;}/* Position Absolute */
.vertical-base{	vertical-align:baseline;}/* vertical align baseline */
.vertical-top{	vertical-align:top;}/* vertical align top */
nav.vertical ul li{	display:block;}/* vertical menu */
nav.horizontal ul li{	display: inline-block;}/* horizontal menu */
img{max-width:100%;}

body{
	background:#fff;
	font-family: 'Open Sans', sans-serif;

}
.wrap{
	margin: 0 auto;
	width: 80%;
}
body a,form li,input[type="submit"],input[type="text"],.sixth-login input[type="submit"],.third-login input[type="submit"]{
	transition: 0.1s all;
	-webkit-transition: 0.1s all;
	-moz-transition: 0.1s all;
	-o-transition: 0.1s all;
}

.login-10{
	background: url(../images/bg10.jpg)repeat;
	padding:6em 0;
}
.tenth-login {
	background: #f6f8f7;
	text-align: center;
	border-radius: 0.4em;
	-o-border-radius: 0.4em;
	-webkit-border-radius: 0.4em;
	-moz-border-radius: 0.4em;
	width: 32%;
	margin: 0 auto;
}
.tenth-login  h4{
	font-size: 1.2em;
	color: #646464;
	font-family: 'PT Sans', sans-serif;
	background: #eee;
	padding: 1.8em 0em;
	border-top-right-radius:0.4em;  
	-o-border-top-right-radius:0.4em;  
	-moz-border-top-right-radius:0.4em;  
	-webkit-border-top-right-radius:0.4em;  
	border-top-left-radius:0.4em; 
	-o-border-top-left-radius:0.4em; 
	-moz-border-top-left-radius:0.4em; 
	-webkit-border-top-left-radius:0.4em;  
}
form.ten {
	padding: 5% 0 7% 0;
}
.fb {
	text-align: center;
	transition: all 0.5s ease-out;
	-webkit-transition: all 0.3s ease-out;
	-moz-transition: all 0.3s ease-out;
	-ms-transition: all 0.3s ease-out;
	-o-transition: all 0.3s ease-out;
	background: #3b5998;
	border-radius:4px;
	-webkit-border-radius: 4px;
	-moz-border-radius:4px;
	-o-border-radius:4px;
	border:none;
	outline:none;
	width:80%;
	margin:0 auto;
}
.fb:hover {
background:#627EAB;
}
.fb a span {
	background: url(../images/icon10.png) no-repeat 2px 1px;
	height: 30px;
	width: 30px;
	display: inline-block;
	float: left;
	margin: 6px 0px 0px 12px;
}
form.ten p{
	font-size: 17px;
	color: #4d4d4d;
	padding: 12px 0 0px 0;
}
.fb lable {
	color: #fff;
	padding: 12px 10px;
	float: left;
	font-size: 17px;
	width: 51%;
	border-left: 1px solid #E0DEDE;
}
.fb:hover{
	background:#335FA4;
}
form.ten li{
	list-style: none;
	width:90%;
	background: #3b5998;
	border:none;
	margin:0 auto;
	border-radius: 0.3em;
	-o-border-radius: 0.3em;
	-moz-border-radius: 0.3em;
	-webkit-border-radius: 0.3em;
}
.icon5{
	height:30px;
	width:30px;
	display: block;
	float: left;
	margin:12px 0px 0px 1px;
}
.face{
	background: url(../images/icons5.png) no-repeat 6px 9px;
	
}
.icon10{
	height:30px;
	width:30px;
	display: block;
	float:left;
	margin:19px 1px 0px 12px;
}
.user10{
	background: url(../images/icon10.png) no-repeat 6px -37px;
	
}
.lock10{
background: url(../images/icon10.png) no-repeat 6px -77px;
}
form.ten li.cream{
	list-style: none;
	width:80%;
	background: #f2f2f2;
	border:none;
	margin: 9px auto;
}
.tenth-login input[type="text"],.tenth-login  input[type="password"] {
	width: 74%;
	padding: 0.8em 0.7em 1em 1em;
	color: #8f9091;
	font-size: 18px;
	outline: none;
	background: none;
	border: none;
	-webkit-appearance: none;
	font-weight: 400;
	font-family: 'PT Sans', sans-serif;
	border-left: 1px solid #fff;
}
.submit-ten{
	margin-top:0.8em;
}
.tenth-login input[type="submit"]{
	font-size:20px;
	font-weight:400;
	color: #fff;
	display: inline-block;
	padding:0.8em 0em;
	width: 80%;
	font-family: 'PT Sans', sans-serif;
	cursor: pointer;
	-webkit-appearance: none;
	border: none;
	outline: none;
	background:#4d4d4d;
	-o-border-radius:0.3em;  
	-moz-border-radius:0.3em;  
	-webkit-border-radius:0.3em;  
	border-radius:0.3em;  

}
.tenth-login input[type="submit"]:hover{
 background:#3b5998;
}


</style>
</head>
<body>
	<div class="login-10">
		<div class="tenth-login">
			<h4>LOGIN FORM</h4>
			<form class="ten" action="index.html">
				 <div class="fb"><a href="#"><span> </span> <lable>Sign in with Facebook</lable><div class="clear"></div></a></div>
						<p>Or<p>
				<li class="cream">
					<input type="text" class="text" name="userName" placeholder="maheshbabu5005@gmail.com" ><a href="#" class=" icon10 user10"></a>
				</li>
				<li class="cream">
					<input type="password" name="password" placeholder="**********"><a href="#" class=" icon10 lock10"></a>
				</li>
				<div class="submit-ten">
					<input type="submit" onclick="myFunction()" value="Log in" > 
				</div>
			</form>
		</div>
	</div>		 		
</body>
</html>