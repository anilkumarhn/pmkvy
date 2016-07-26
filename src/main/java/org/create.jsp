<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create</title>
</head>
<body><br><br>
	<center>
		<fieldset style="border-color: green;">
			<legend><h3 style="color: red;">Employee Registration Form</h3></legend>
		
		<form:form modelAttribute="employee" autocomplete="off" action="saverecord.do" method="post">
		<table width="400px" height="500px">
		
			<tr>
				<td>Employee Code</td>
				<td><input type="text" name="empCode" id="empCode" style="width: 200px;"></td>
			</tr>
			
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName" id="empName" style="width: 200px;"></td>
			</tr>
			
			<tr>
				<td>Employee DOB</td>
				<td><input type="date" name="empDob" id="empDob" style="width: 200px;"></td>
			</tr>
			
			<tr>
				<td>Is Active</td>
				<td> <div>Yes<input type="checkbox" name="isActive" id="isActive" style="width: 200px;"> 
					</div>	
				</td>
			</tr>
			
			<tr>
				<td>Designation</td>
				<td><select name="designation" id="designation" style="width: 200px;">
					<option value=""></option>
					<option value="developer">developer</option>
					<option value="tester">tester</option> 
				</td>
			</tr>
			
			<tr>
				<td>Department</td>
				<td><select name="department" id="department" style="width: 200px;">
					<option value=""></option>
					<option value="development">development</option>
					<option value="support">support</option>
				</select> </td>
			</tr>
			
			<tr>
				<td>Primary Address</td>
				<td><textarea rows="4" cols="26" name="primaryAddress" id="primaryAddress"></textarea> </td>
			</tr>

			<tr>
				<td>Corrs Address</td>
				<td><textarea rows="4" cols="26" name="corrsAddress" id="corrsAddress" ></textarea> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create" style="width: 200px; background-color: orange;"> </td>
			</tr>
		</table>
		</form:form>
		</fieldset>
	</center>

</body>
</html>