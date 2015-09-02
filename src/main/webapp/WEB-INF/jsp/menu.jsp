<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
	#menubar{ background-color:#F5F5F5;}
</style>
</head>
<body id="menubar" >

<c:choose>

	<c:when test="${USER_ROLE == 'Super Admin'}">
		<table class="table table-bordered text-center"	>
			<tr>
				<td><form action="rooman.html" method="post"><button type="submit" class="btn btn-block btn-primary btn-flat">Rooman</button></form> </td>
			</tr>
			<tr>
				<td><form action="show-user-account.html" method="post"><button type="submit" class="btn btn-block btn-primary btn-flat">User Account</button></form> </td>
			</tr>
			<tr>
				<td><form action="show-data-upload-form.html" method="post"><button type="submit" class="btn btn-block btn-primary btn-flat">Data Upload</button></form> </td>
			</tr>
			<tr>
				<td><form action="show-report-download-form.html" method="post"><button type="submit" class="btn btn-block btn-primary btn-flat">Reports</button></form> </td>
			</tr>
		</table>
	</c:when>

	<c:when test="${USER_ROLE == 'Data Manager'}">

		<table class="table table-bordered text-center"	>
			<tr>
				<td><form action="rooman.html" method="post"><button type="submit" class="btn btn-block btn-primary btn-flat">Rooman</button></form> </td>
			</tr>
		</table>
	</c:when>
<c:when test="${USER_ROLE == 'Partner'}">
		<table class="table table-bordered text-center"	>
			<tr>
				<td><form action="partnerprofile.html" method="get"><button type="submit" class="btn btn-block btn-primary btn-flat">Profile</button></form> </td>
			</tr>
			<tr>
				<td><form action="partnercourses.html" method="post"><button type="submit" class="btn btn-block btn-primary btn-flat">Sectors</button></form> </td>
			</tr>
			
			<tr>
				<!-- <td><form action="partnerremits.jsp" method="post"><button type="submit" class="btn btn-block btn-primary btn-flat">My Remits</button></form> </td> -->
			</tr>
		</table>
	</c:when>
	
	</c:choose>