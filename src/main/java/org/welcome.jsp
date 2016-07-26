<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
	<script type="text/javascript">
		alert("${statusFlag}");
	</script>

</head>
<body>
	<br><br>
	<fieldset style="color: red;">
		<legend><h4>Employee Menu</h4></legend>
	<table>
		<thead>
			<td><form:form action="create.do" method="get"><input type="submit" value="Create Employee"></form:form> </td>
		</thead>
	</table>
	</fieldset>
	
	 <br>
	 	
				<c:if test="${!empty employeeList}">
				<fieldset style="color: red;">
					<legend><h4>Employee List</h4></legend>		
				<table border="1px" style="table-layout: auto; overflow: scroll; height: 100px;">
					<tr>
							<td>ID</td>
							<td>EMP CODE</td>
							<td>EMP NAME</td>
							<td>DOB</td>
							<td>IS ACTIVE</td>
							<td>DESIGNATION</td>
							<td>DEPARTMENT</td>
							<td>PRI_ADDRESS</td>
							<td>CORRS_ADDRESS</td>
							<td>ACTION</td>
					</tr>
					<c:forEach items="${employeeList}" var="emp">
					<tr>
							<td>${emp.empId}</td>
							<td>${emp.empCode}</td>
							<td>${emp.empName}</td>
							<td>${emp.empDob}</td>
							<td>${emp.isActive}</td>
							<td>${emp.designation.desgName}</td>
							<td>${emp.department.deptName}</td>
							<c:forEach items="${emp.address}" var="a">  
							<td>${a.primaryAddress}</td>
							<td>${a.corrsAddress}</td>
							</c:forEach>
							<td>
								<form:form action="showupdateform.do" method="post">
									<input type="hidden" name="empId" value="${emp.empId}">
									<input type="submit" value="Edit">
								</form:form>
							</td>
					</tr>
					</c:forEach>	
				</table>
				</fieldset>
				</c:if>
	</body>
</html>