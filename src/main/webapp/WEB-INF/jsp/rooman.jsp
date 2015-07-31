<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rooman Technology</title>

<style> 
#body
{
	background:url(images/tech.jpg);
	background-size:1500px 800px;
	background-repeat:no-repeat;
}
</style>


<script type="text/javascript">

function selectCentre(selected)
{
    var selection = document.getElementById("centre");
    selection.value = selected.value;
}

function selectSector(selected)
{
    var selection = document.getElementById("sector");
    selection.value = selected.value;
}

</script>


</head>

<body>

	<form action="batchs.html" method="post">	<div >
	<label>Select Centre :</label>
	<select onchange="selectCentre(this)">
	<option></option>
	<c:forEach items="${CentreList}" var="centre">
		<option value="${centre.centreID}">${centre.centreName}</option>
	</c:forEach>
	</select> 
	<br>
	
	
	<label>Select Sector :</label>
	<select onchange="selectSector(this)">
	<option></option>
	<c:forEach items="${SectorList}" var="sector">
		<option value="${sector.sectorID}">${sector.sectorName}</option>
	</c:forEach>
	</select> 
		</div>
		<input type="hidden" name="centre" id="centre" />
     	<input type="hidden" name="sector" id="sector" />
		<input type="submit" value="Next  &raquo;"  />
	</form>

</body>
</html>