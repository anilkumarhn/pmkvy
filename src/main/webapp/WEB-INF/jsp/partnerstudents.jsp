<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Student Info</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="tablecss/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/htmlctrl.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
	 <style type="text/css"> .updatebtn, .btnclass{ width: 100%;} </style>
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
    
    <style type="text/css">
   	#centerlist, #searchPartner{width: 350px; height: 25px; background-color: #F0F8FF; text-indent: 10px;} 
    .selecttask{ text-align: right; color: #FF7F50; font-size: 20px; font-family: sans-serif; font-variant: small-caps; font-weight: bold;}
 	.btns{ width: 80px; height: 25px; color: white; font-family: sans-serif; background-color: #3c8dbc; border: 2px;}
    #update{ width: 100%; font-family: sans-serif;  } 
    #selected{width: 350px;  border: none; background-color:#F5F5F5; color: #FF7F50;}
    </style>
</head>
  <body class="skin-blue sidebar-mini" >
  			<div>
  			<table>
  						<tr>
  							<td><form action="partnerbatches.html" method="post">
						    	<input type="hidden" name="courseID" value="${pcourseID}"/>
						    	<input type="hidden" name="sectorName" value="${psectorName}"/>
						    	<input type="submit" value="Batch Selection" >
					    	</form></td>
  						</tr> 
  				     </table>
  			</div><br>
  			
  
	
  		<div id="searchtable">
				<p>STUDENT LIST&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sector Info : ${pcourseID} &nbsp;&nbsp;${psectorName},&nbsp;&nbsp;&nbsp;&nbsp;Batch ID: ${pbatchID}</p>
	  		 	<div class="box">
        	 	<div class="box-body">
        	 	<table id="example1" class="table table-bordered table-striped">
               	<thead>
               		<tr>
					   	<td><b>ID</b></td>
					   	<td><b>STUDENT NAME</b></td>
					   	<td><b>ENROLLMENT</b></td>
					   	<td><b>CONTACT NO</b></td>
					   	<td><b>EMAIL</b></td>
					   	<td><b>AADHAR NO</b></td>
					   	<td><b>VALIDATED</b></td>
					   	<td><b>ADDRESS</b></td>
					   	<td><b>ACTION</b></td>
					  </tr>
                </thead>
        	 	<tbody>
        	 			<c:forEach items="${StudentList}" var="student">
				    	<tr>
					    	<td>${student.candidateID}</td>
					    	<td>${student.candidateName}</td>
					    	<td>${student.enrollmentNo}</td>
					    	<td>${student.contactNo}</td>
					    	<td>${student.emailID}</td>
					    	<td>${student.aadharNo}</td>
					    	<td>${student.aadharValidated}</td>
					    	<td>${student.address}</td>
					    	<td> <form action="partnerstudentinfo.html" method="post">
					    		<input type="hidden" name="candidateID" value="${student.candidateID}">
						    	<input type="submit" value="select" class="btnclass">
					    	</form>
					    	</td>
				    	</tr>
				    	</c:forEach>
        	 	</tbody>
        	 	</table>
        </div>
     </div>			
	</div>
 
   <script src="tablecss/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="tablecss/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="tablecss/plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/fastclick/fastclick.min.js"></script>
    <script src="tablecss/dist/js/app.min.js" type="text/javascript"></script>
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
</html>
 
 