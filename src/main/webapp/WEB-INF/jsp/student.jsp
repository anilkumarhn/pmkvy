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
  							<td><form action="partnerinfo.html" method="get"><button>Centre Selection</button> </form> </td>
  							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  							<td><form action="sectorinfo.html" method="post"><input type="hidden" name="partnerID" value="${PartnerID}"><input type="hidden"name="partnerName" value="${PartnerName}"><button >Sector Selection</button> </form></td>
  							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  							<td><form action="batchinfo.html" method="post"><input type="hidden" name="courseID" value="${courseID}"><input type="hidden"name="sectorName" value="${sectorName}"><button >Batch Selection</button> </form></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  							<td><form action="studentinfo.html" method="post"><input type="hidden" name="batchID" value="${batchID}"><button >Student Selection</button> </form></td>
  						</tr> 
  				     </table>
  			</div><br>
  			
  
  	<c:choose>
	<c:when test="${StudentList != null}">				
			<div id="searchtable">
				<p>STUDENT LIST&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Partner Info : ${PartnerID} &nbsp;&nbsp;${PartnerName},&nbsp;&nbsp;&nbsp;&nbsp; Sector Info : ${courseID} &nbsp;&nbsp;${sectorName},&nbsp;&nbsp;&nbsp;&nbsp;Batch ID: ${batchID}</p>
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
					    	<td><button name="update" class="btnclass" onclick="updateStudent('${student.candidateID}','${student.candidateName}','${student.enrollmentNo}','${student.contactNo}','${student.emailID}','${student.aadharNo}','${student.aadharValidated}','${student.address}')">update</button></td>
					    	
					    	<td> <form action="student-info.html" method="post">
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
	
</c:when>
</c:choose>

<script type="text/javascript">
function updateStudent(candidateID, candidateName, enrollmentNo, contactNo, emailID, aadharNo, aadharValidated, address)
{
		window.location.hash = 'update-student-info';
		document.getElementById('update-student-info').style.display = "block";
		document.getElementById('candidateID').value = candidateID;
		document.getElementById('candidateName').value = candidateName;
		document.getElementById('enrollmentNo').value = enrollmentNo;
		document.getElementById('contactNo').value = contactNo;
		document.getElementById('emailID').value = emailID;
		document.getElementById('aadharNo').value = aadharNo;
		document.getElementById('aadharValidated').value = aadharValidated;
		document.getElementById('address').value = address;
	}

	function confirm_update() 
	{
		  return confirm('Are you sure?');
	}	

</script>


<div id="update-student-info" style="display: none;">

     <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE CANDIDATE INFO</label><hr>    	
     	<form action="updatestudent.html" method="post" autocomplete="off" >
		<c:choose>
			<c:when test="${USER_ROLE == 'Super Admin'}">				
				<table class="tableforuser">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label>CANDIDATE ID</label> </td>
				<td><input class="control" type="text" name="candidateID" id="candidateID" readonly="readonly" ></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >CANDIDATE NAME</label></td>
				<td><input class="control" type="text" name="candidateName" id="candidateName"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>ENROLLMENT NO</label></td>
				<td><input class="control" type="text" name="enrollmentNo" id="enrollmentNo"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>CONTACT NO</label></td>
				<td><input type="text" class="control" name="contactNo" id="contactNo"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>EMAIL</label></td>
				<td><input type="email" class="control" name="emailID" id="emailID"></td>
				<td></td>
				<td></td>
			</tr>

			<tr> 
				<td></td>
				<td><label>AADHAR NO</label></td>
				<td><input type="text" class="control" name="aadharNo" id="aadharNo"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>AADHAR VALIDATED</label></td>
				<td><select name="aadharValidated" id="aadharValidated" class="control">
							<option></option>
							<option value="Yes">Yes</option>
							<option value="No">No</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRoles"></a></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>ADDRESS</label></td>
				<td><textarea name="address" id="address" rows="3" class="control"></textarea></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Candidate"  onclick="return confirm_update()"> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorInCreation"></a></td>
			</tr>
		</table>
				
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${USER_ROLE == 'Data Manager'}">				
				<table class="tableforuser">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label>CANDIDATE ID</label> </td>
				<td><input class="control" type="text" name="candidateID" id="candidateID" readonly="readonly" ></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >CANDIDATE NAME</label></td>
				<td><input class="control" type="text" name="candidateName" id="candidateName"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>ENROLLMENT NO</label></td>
				<td><input class="control" type="text" name="enrollmentNo" id="enrollmentNo"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>CONTACT NO</label></td>
				<td><input type="text" class="control" name="contactNo" id="contactNo"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>EMAIL</label></td>
				<td><input type="email" class="control" name="emailID" id="emailID"></td>
				<td></td>
				<td></td>
			</tr>

			<tr> 
				<td></td>
				<td><label>AADHAR NO</label></td>
				<td><input type="text" class="control" name="aadharNo" id="aadharNo" readonly="readonly"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>AADHAR VALIDATED</label></td>
				<td><select name="aadharValidated" id="aadharValidated" class="control">
							<option></option>
							<option value="Yes">Yes</option>
							<option value="No">No</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRoles"></a></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>ADDRESS</label></td>
				<td><textarea name="address" id="address" rows="3" class="control"></textarea></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Candidate"  onclick="return confirm_update()"> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorInCreation"></a></td>
			</tr>
		</table>
				
			</c:when>
		</c:choose>
		</form><br><br>
	</div><!-- /.box-body -->
   </div><!-- /.box -->
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
 
 