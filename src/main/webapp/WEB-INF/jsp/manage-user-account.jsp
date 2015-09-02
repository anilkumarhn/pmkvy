
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Tables</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="tablecss/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		.control
		{
			width: 300px;
			height: 25px;
			margin: 5px;
			font-family: sans-serif;
			text-indent: 10px;	        
		}
		.updatebtn{ width: 100%;}
		#title{ margin-bottom: -15px; font-size: 15px; text-indent: 20px; }
	</style>
	
</head>
  <body class="skin-blue sidebar-mini">
    		<H4><b>User Account List</b></H4>
              <div class="box">
                <div class="box-body">
                  <table id="example1" class="table table-bordered table-striped">
               <thead>
                  	<tr>
                  	    <td><b>USER ID</b></td>
                	    <td><b>FIRST NAME</b></td>
	                    <td><b>LAST NAME</b></td>
	                    <td><b>USER NAME</b></td>
	                    <td><b>PASSWORD</b></td>
	                    <td><b>USER_ROLE</b></td>
	                    <td><b>ACTION</b></td>
	                    <td><b>ACTION</b></td>
	              	</tr>
               </thead>
               
               <tbody>
                  <c:forEach items="${userList}" var="user">
                     <tr >
				            <td>${user.id}</td>
				            <td>${user.firstName}</td>
				            <td>${user.lastName}</td>
				            <td>${user.userName}</td>
				            <td>${user.password}</td>
				            <td>${user.role.userRole}</td>
							<td><input type="button" class="updatebtn" name="update" value="update" onclick="showUpdateUser('${user.id}','${user.firstName}','${user.lastName}','${user.userName}','${user.password}','${user.role.userRole}')" /> </td>	        		       
	        		    	<td><input type="button" class="updatebtn" name="update" value="reset pwd" onclick="showResetPwd('${user.id}','${user.firstName}','${user.lastName}','${user.userName}','${user.password}','${user.role.userRole}')" ></td>
	        		       </tr>
			  		   </c:forEach>
                </tbody>
                </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
       
       <a href="#" onclick="showCreateForm(this)">click here to create new user account</a>
	
	 <div style="display:none;" id="create-user">
     <div class="box">
     <div class="box-body" align="left"><br>	
     	<label id="title">CREATE NEW USER ACCOUNT</label><hr>    	
      	<form action="create-user-account.html" method="post" autocomplete="off" >
		<table class="tableforuser">
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >First Name</label></td>
				<td><input class="control"  type="text" name="firstName" placeholder="Enter first name" onkeyup="validateFirstName(this.value,'errorFirstName'); return false;" onblur="validateFirstName(this.value,'errorFirstName'); return false;" ></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorFirstName"></a></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Last  Name</label></td>
				<td><input class="control"  type="text" name="lastName" placeholder="Enter last name" onkeyup="validateLastName(this.value,'errorLastName'); return false;" onblur="validateLastName(this.value,'errorLastName'); return false;"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorLastName"></a></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>E-Mail ID</label></td>
				<td><input class="control" type="text"  name="userName" placeholder="Enter user name" onkeyup="validateEmail(this.value,'errorEmail'); return false;" onblur="validateEmail(this.value,'errorEmail'); return false;" ></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorEmail"></a></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Password</label></td>
				<td><input class="control" type="password" name="password" placeholder="Enter password" onkeyup="validatePassword(this.value,'errorPwd'); return false;" onblur="validatePassword(this.value,'errorPwd'); return false;"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorPwd"></a></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Select Role</label></td>
				<td><select class="control" name="role" id="roles"  onblur="validateSelector('errorRole'); return false;" onmouseover="validateSelector('errorRole'); return false;" onchange="validateSelector('errorRole'); return false;" >
							<option></option>
							<option value="Super Admin">Super Admin</option>
							<option value="Admin">Admin</option>
							<option value="Data Manager">Data Manager</option>
							<option value="Partner">Partner</option>
							<option value="Account Manager">Account Manager</option>
							</select></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRole"></a></td>
			</tr>
	
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Create Account" ></td>
				<td></td>
				<td></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorInCreation"></a></td>
			</tr>
		</table>
	</form><br><br>
   </div><!-- /.box-body -->
   </div><!-- /.box -->	
</div>


  <div style="display:none;" id="update-user">
     <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE USER ACCOUNT</label><hr>    	
     	<form action="update-user-account.html" method="post" autocomplete="off" >
	
		<table class="tableforuser">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label>ID</label> </td>
				<td><input class="control" type="text" name="id" id="id" readonly="readonly" ></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >First Name</label></td>
				<td><input class="control" type="text" name="firstName" id="firstName" readonly="readonly"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Last  Name</label></td>
				<td><input class="control" type="text" name="lastName" id="lastName" readonly="readonly"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>E-Mail ID</label></td>
				<td><input type="text" class="control" name="userName" id="userName" readonly="readonly"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Password</label></td>
				<td><input type="password" class="control" name="password" id="password" readonly="readonly"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Select Role</label></td>
				<td><select name="role" id="role" class="control" onblur="validateSelUser('errorRoles'); return false;" onmouseover="validateSelUser('errorRoles'); return false;" onchange="validateSelUser('errorRoles'); return false;">
							<option></option>
							<option value="Super Admin">Super Admin</option>
							<option value="Admin">Admin</option>
							<option value="Data Manager">Data Manager</option>
							<option value="Partner">Partner</option>
							<option value="Account Manager">Account Manager</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRoles"></a></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Account" ></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorInCreation"></a></td>
			</tr>
		</table>
	</form><br><br>
	</div><!-- /.box-body -->
   </div><!-- /.box -->
</div>
	  
<!-- RESET PASSWORD FORM  -->

<div style="display:none;" id="reset-pwd">
	     <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">RESET USER PASSWORD</label><hr>    	
     	<form action="reset-user-password.html" method="post" autocomplete="off" >
	
		<table class="tableforuser">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label>ID</label> </td>
				<td><input class="control" type="text" name="id" id="idPwd" readonly="readonly" ></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >First Name</label></td>
				<td><input class="control" type="text" name="firstName" id="firstNamePwd" readonly="readonly"></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Last  Name</label></td>
				<td><input class="control" type="text" name="lastName" id="lastNamePwd" readonly="readonly"></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>E-Mail ID</label></td>
				<td><input type="text" class="control" name="userName" id="userNamePwd" readonly="readonly"></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Password</label></td>
				<td><input type="password" class="control" name="password" id="passwordPwd" readonly="readonly"></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>Select Role</label></td>
				<td><input name="role" id="rolePwd" class="control" type="text" readonly="readonly" ></td>
			</tr>
	
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Reset Password" ></td>
				<td></td>
			</tr>
		</table>
	</form><br><br>
	</div><!-- /.box-body -->
   </div><!-- /.box -->
	

</div>
	  
    <script src="tablecss/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="tablecss/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="tablecss/plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/fastclick/fastclick.min.js"></script>
    <script src="tablecss/dist/js/app.min.js" type="text/javascript"></script>
    <script src="js/form/validateform.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(function () {
        $("#example1").dataTable();
        $('#example2').dataTable({
          "bPaginate": true,
          "bLengthChange": false,
          "bFilter": false,
          "bSort": true,
          "bInfo": true,
          "bAutoWidth": false
        });
      });
    </script>

  </body>
      <script type="text/javascript">
		function showCreateForm() 
		{
			document.getElementById('update-user').style.display = "none";
			document.getElementById('reset-pwd').style.display = "none";
			document.getElementById('create-user').style.display = "block";
	
		}
		
		function showResetPwd(id,firstName,lastName,userName,pwd,role) 
		{
			document.getElementById('update-user').style.display = "none";
			document.getElementById('create-user').style.display = "none";
			document.getElementById('reset-pwd').style.display = "block";
			
			document.getElementById("idPwd").value = id;
			document.getElementById("firstNamePwd").value = firstName;
			document.getElementById("lastNamePwd").value = lastName;
			document.getElementById("userNamePwd").value = userName;
			document.getElementById("passwordPwd").value = userName ;
			document.getElementById("rolePwd").value = role;
		}
		
		function showUpdateUser(id,firstName,lastName,userName,password,role) 
		{
			document.getElementById('reset-pwd').style.display = "none";
			document.getElementById('create-user').style.display = "none";
			document.getElementById('update-user').style.display = "block";
			
			document.getElementById("id").value = id;
			document.getElementById("firstName").value = firstName;
			document.getElementById("lastName").value = lastName;
			document.getElementById("userName").value = userName;
			document.getElementById("password").value = password;
			document.getElementById("role").value = role;
		}
	
	</script>
</html>
 