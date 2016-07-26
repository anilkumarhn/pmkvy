<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
	</head>
<body>
	<center>
			<fieldset>
				<legend><div style="color:red; font-size: 20px;">Update Employee</div></legend>
					<form action="updateEmployee.do" method="post">
	<table width="400px" height="500px">
			<tr>
				<td>Id</td>
				<td><input type="text" name="empId" id="empId" style="width: 200px;" value="${employeeObj.empId}" readonly="readonly"></td>
			</tr> 
			<tr>
				<td>Employee Code</td>
				<td><input type="text" name="empCode" id="empCode" style="width: 200px;" value="${employeeObj.empCode}" ></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName" id="empName" style="width: 200px;" value="${employeeObj.empName}" ></td>
			</tr>
			
			<tr>
				<td>Employee DOB</td>
				<td><input type="date" name="empDob" id="empDob" style="width: 200px;"></td>
			</tr>
	 
			<tr>
				<td>Is Active</td>
				<td>Yes<input type="checkbox" name="isActive" id="isActive" style="width: 200px;">
			</tr>
			
			<tr style="display: none;">
				<td>Desg Id</td>
				<td><input type="text" name="desgId" id="desgId" style="width: 200px;" value="${designationObj.desgId}"></td>
			</tr>
			
			<tr>
				<td>Designation</td>
				<td><select name="designation" id="designation" style="width: 200px;">
					<option value=""></option>
					<option value="developer">developer</option>
					<option value="tester">tester</option> 
				</td>
			</tr>
			
			<tr style="display: none;">
				<td>Dept Id</td>
				<td><input type="text" name="deptId" id="deptId" style="width: 200px;" value="${departmentObj.deptId}"></td>
			</tr>
		
			
			
			<tr>
				<td>Department</td>
				<td><select name="department" id="department" style="width: 200px;">
					<option value=""></option>
					<option value="development">development</option>
					<option value="support">support</option>
				</select> </td>
			</tr>
		
			<tr style="display: none;">
				<td>Address Id</td>
				<td><input type="text" name="addressId" id="addressId" style="width: 200px;" value="${addressObj.addressId}"></td>
			</tr>
		
			<tr>
				<td>Primary Address</td>
				<td><textarea rows="4" cols="26" name="primaryAddress" id="primaryAddress" >${addressObj.primaryAddress}</textarea> </td>
			</tr>

			<tr>
				<td>Corrs Address</td>
				<td><textarea rows="4" cols="26" name="corrsAddress" id="corrsAddress" >${addressObj.corrsAddress}</textarea> </td>
			</tr>
		 	<tr>
				<td></td>
				<td><input type="submit" value="Update" style="width: 200px; background-color: olive;"> </td>
			</tr>
		</table>
	
			</form>
		</fieldset>	
	</center>
</body>
</html>
