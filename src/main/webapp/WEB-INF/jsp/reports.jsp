<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Sector</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="tablecss/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/htmlctrl.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
   <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
   <style type="text/css">
   	.report{
   		width: 500px;
   		height: 30px;
   	}
   </style>
</head>
  <body class="skin-blue sidebar-mini" >
  		<div>
  			<div>
  				<form action="partnerReport.html" method="post">
  					Get Partners Details
  					<input type="submit" value="Get Report "> 
  				</form>
  			</div>
  			<div>
  				<form action="getBatchByTestStatus.html" method="POST">
  					Search By Test Status Or Start Date
  					<input type="text" name="testStatus"/>
  					<button>Get Batch Report</button>
  				</form>
  			</div>
  			<div>
  				<br>
  				<form action="getStudentByAadharVal.html" method="POST">
  					Search By AadharNumber Validated 
  					<input type="text" name="aadharVal"/>
  					<button>Get Student Report</button>
  				</form>
  			</div>
  			<%-- <div>
  				<br>
  				<form action="getStudentByBatch.html" method="POST">
  					Students List Based On Batch ID
  						<input type="text" name="studentByBatch"/>
  						<button>Get Student List Report</button>
  				</form>
  			</div> --%>
  		</div>        
  </body>
</html>
 
 