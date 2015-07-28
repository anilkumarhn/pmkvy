<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
</head>

<body>
<form:form action="batchs.html" method="POST">
	
	<fieldset id="body">
								<legend align="left">Rooman Info</legend>
								<table width="900px" height="400px">
								
									<tr>
	<form:label path="">Branch :</form:label>
	<form:select path="">
		<form:option value="0">--------Select--------</form:option>
		<form:option value="1">Rajajinagar</form:option>
		<form:option value="2">Jayanagar</form:option>
		<form:option value="3">Mattikere</form:option>
		<form:option value="4">Shivajinagar</form:option>
		<form:option value="5">Kormangala</form:option>
		<form:option value="6">Electron City</form:option>
		<form:option value="7">Vijaynagar</form:option>
		<form:option value="8">Basavanagudi</form:option>
		<form:option value="9">Domlur</form:option>
	</form:select>
	
	<form:label path="">Sector :</form:label>
	<form:select path="">
		<form:option value="0">--------Select--------</form:option>
		<form:option value="1">Agriculture Sector Skill Council of India</form:option>
								<form:option value="2">ALL SSCALL SSC</form:option>
								<form:option value="3">Apparel Sector Skill Council</form:option>
								<form:option value="4">Automotive Skills Development Council</form:option>
								<form:option value="5">Beauty and Wellness Sector Skill Council</form:option>
								<form:option value="6">BFSI Sector Skill Council of India</form:option>
								<form:option value="7">Capital Goods Skill Council of India</form:option>
								<form:option value="8">Construction Skill Development Council of India</form:option>
								<form:option value="9">Electronics Sector Skills Council of India</form:option>
								<form:option value="10">Gems  Jewellery Skill Council of India</form:option>
								<form:option value="11">Healthcare Sector Skill Council</form:option>
								<form:option value="12">Indian Plumbing Skills Council</form:option>
								<form:option value="13">Iron And Steel Sector Skill Council</form:option>
								<form:option value="14">Leather Sector Skill Council</form:option>
								<form:option value="15">Life Sciences Sector Skill Council</form:option>
								<form:option value="16">Logistics Sector Skill Council</form:option>
								<form:option value="17">Media  Entertainment Skills Council</form:option>
								<form:option value="18">Mining Sector Skill Council</form:option>
								<form:option value="19">Retailers Association’s Skill Council of India</form:option>
								<form:option value="20">Rubber Skill Development Council</form:option>
								<form:option value="21">Security Sector Skill Development Council</form:option>
								<form:option value="22">Telecom Sector Skill Council</form:option>
								<form:option value="23">Textiles  Handloom Sector Skill Council</form:option>
								<form:option value="24">Tourism and Hospitality Services Sector Skill Council</form:option>
	</form:select>
	
	<form:input type="submit" value="Next"  path=""/>
	</tr>
	</table>
	</fieldset>
</form:form>
</body>
</html>