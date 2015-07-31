<!-- <img src="images/tech.jpg" style="height: 450px;width: 1100px"/> -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Home</title>
    <script type="text/javascript" src="../../resources/script.js"></script>
</head>

<body>

	<form method="post" action="upload-student-partner-details.html" enctype="multipart/form-data">
		<table>
		<tr>
			<td>Select Student File :</td>
			<td><input type="file" name="file"/></td>
			<td><input type="submit" value="Upload"/></td>
		</tr>
		</table>
	</form>
	
	<form method="post" action="upload-centre-details.html" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select Centre Details File :</td>
				<td><input type="file" name="file"/></td>
				<td><input type="submit" value="Upload"/></td>
			</tr>
		</table>
	</form>
	
	<form method="post" action="upload-sector-details.html" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select Sector Details File :</td>
				<td><input type="file" name="file"/></td>
				<td><input type="submit" value="Upload"/></td>
			</tr>
		</table>
	</form>

</body>
</html>  