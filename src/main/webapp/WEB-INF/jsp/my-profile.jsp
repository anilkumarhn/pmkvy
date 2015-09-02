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
    <script type="text/javascript" src="js/form/validateform.js"></script>
    <style type="text/css">
    	.cu{ width: 300px; text-indent: 10px; font-family: sans-serif;}
    	label{margin: 8px;}
    	#th{ font-size: 16px; text-align: center; background-color:#3c8dbc; color: white;}
    	#update{ width: 100%; }
    	#val{font-family: sans-serif; text-align: center;}
    	#cpwd{width: 260px; text-indent: 10px; height: 25px;}
    	#savechanges{background-color: #3c8dbc; width: 100%;height: 25px; border: 2px; border-color: black; color: white; font-family: sans-serif;}
    	</style>
</head>
  <body class="skin-blue sidebar-mini">
    <h4><b>My Profile</b></h4>
    
    	<c:choose>
		   	<c:when test="${SUCCESS_MSG == 'YES'}">
				<script>alert("Profile Updated Successfully");SUCCESS_MSG = '';	 </script>
			</c:when>
	   	</c:choose>
	
		<c:choose>
		   	<c:when test="${SUCCESS_MSG == 'NO'}">
				<script>alert("Profile Updatedation Failed");</script>
			</c:when>
	   	</c:choose>
	
    
    
	   <div class="box">
	   <div class="box-body" align="left">
		    <table id="tableprf" border="2px" width="100%">
			    <tr>
			    	<td id="th">User ID</td>
			    	<td id="th">First Name</td>
			    	<td id="th">Last Name</td>
			    	<td id="th">Email ID</td>
			    	<td id="th">Password</td>
			    	<td id="th">User Role</td>
			    	<td id="th">Action</td>
			    </tr>
			    <tr>
			    	<td id="val">${MY_PROFILE.id}</td>
			    	<td id="val">${MY_PROFILE.firstName}</td>
			    	<td id="val">${MY_PROFILE.lastName}</td>
			    	<td id="val">${MY_PROFILE.userName}</td>
			    	<td id="val">************</td>
			    	<td id="val">${MY_PROFILE.role.userRole}</td>
			    	<td><input id="update" type="submit" value="update" onclick="updateprofile('${MY_PROFILE.id}','${MY_PROFILE.firstName}','${MY_PROFILE.lastName}','${MY_PROFILE.userName}','${MY_PROFILE.password}','${MY_PROFILE.role.userRole}')" > </td>
			    </tr>
		    </table>
		</div>
	</div>     
	
	<script type="text/javascript">
	function updateprofile(id, firstName, lastName ,userName, password, role ) 
	{
		document.getElementById("updateprofile").style.display="none";
		document.getElementById('acceptpwd').style.display = "block";
		document.getElementById('id').value = id;
		document.getElementById('firstName').value = firstName;
		document.getElementById('lastName').value = lastName;
		document.getElementById('userName').value = userName;
		document.getElementById('cpassword').value = password;
		document.getElementById('role').value = role;
	}
</script>	
	
	<div class="box" id="acceptpwd" style="display:none;">
	   <div class="box-body" align="left">	     
		     <table>
			    <tr>
			    	<td id="pd"><label>Enter Your Current Password&nbsp;&nbsp;&nbsp;&nbsp;</label> </td>
			    	<td id="pd"><input type="password" name="cpwd" id="cpwd" required="required" onkeyup="validateCurPwd(this.value,'errorPwd','${MY_PROFILE.password}'); return false;" > </td>
			    	<td>&nbsp;&nbsp;</td>
			    	<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorPwd"></a></td>	 	
			     </tr>
		    </table>
		</div>
	</div>     
			     
		<div class="box" id="updateprofile"  style="display:none;">
	   <div class="box-body" align="left">	         
 		     
		     <form action="update-my-profile.html" method="post" autocomplete="off" >
				   <br>
				   
				   <table>
					   	<tr>
						   	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						   	<td><label>User ID</label> </td>
							<td><input class="cu" type="number" name="id" id="id" readonly="readonly" value="${USER.id}"></td>
							<td></td>
					   	</tr>
						<tr><td></td></tr><tr></tr>				
					   	<tr>
						   	<td></td>
						   	<td><label>First Name</label> </td>
							<td><input class="cu" type="text" name="firstName" id="firstName" value="${USER.firstName}" required="required" onkeyup="validateFirstName(this.value,'errorFirstName'); return false;" onmouseover="validateFirstName(this.value,'errorFirstName'); return false;"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorFirstName"></a> </td>
					   	</tr>
					
					   	<tr>
						   	<td></td>
						   	<td> <label>Last Name</label> </td>
							<td><input class="cu" type="text" name="lastName" id="lastName" value="${USER.lastName}" required="required" onkeyup="validateLastName(this.value,'errorLastName'); return false;" onmouseover="validateLastName(this.value,'errorLastName'); return false;"> </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorLastName"></a> </td>
					   	</tr>
					
					   	<tr>
						   	<td></td>
						   	<td><label>Email ID</label> </td>
							<td><input type="email" class="cu" name="userName" id="userName" value="${USER.userName}" readonly="readonly"></td>
							<td></td>
					   	</tr>
					
					   	<tr>
						   	<td></td>
						   	<td><label>Cur Password</label> </td>
							<td><input type="password" class="cu" name="cpassword" id="cpassword" value="${USER.password}" readonly="readonly"></td>
							<td></td>
					   	</tr>
					
					   	<tr>
						   	<td></td>
						   	<td><label>New Password</label> </td>
							<td><input type="password" class="cu" name="password" id="password" required="required" onkeyup="validatePassword(this.value,'errorNewPwd'); return false;" onmouseover="validatePassword(this.value,'errorNewPwd'); return false;"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorNewPwd"></a></td>
					   	</tr>
					
					   	<tr>
					      	<td></td>
						   	<td><label>User Role</label> </td>
							<td><input type="text" class="cu" name="role" id="role" value="${USER.role.userRole}" readonly="readonly"></td>
							<td></td>
					   	</tr>
					   
					    	<tr>
						   	<td></td>
						   	<td><label></label> </td>
							<td></td>
							<td></td>
					   	</tr>
					   	
					   	<tr>
						   	<td></td>
						   	<td><label></label> </td>
							<td><input type="submit" id="savechanges" value="Save Changes"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errormsg"></a></td>
					   	</tr>
				   </table>
			</form>       <br>
   </div><!-- /.box-body -->
   </div><!-- /.box --> 
 
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  </body>
 
 
 
 
</html>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 