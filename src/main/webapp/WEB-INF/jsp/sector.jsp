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
    <link href="tablecss/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    
    <style type="text/css">
	   	#centerlist, #searchPartner{width: 350px; height: 25px; background-color: #F0F8FF; text-indent: 10px;} 
	    .selecttask{ text-align: right; color: #FF7F50; font-size: 20px; font-family: sans-serif; font-variant: small-caps; font-weight: bold;}
	 	.btns{ width: 80px; height: 25px; color: white; font-family: sans-serif; background-color: #3c8dbc; border: 2px;}
	    #update{ width: 100%; font-family: sans-serif;  } 
	    #selected{width: 350px;  border: none; background-color:#F5F5F5; color: #FF7F50;}
	    #cls_f{  position: absolute; top: -4px;  right: -4px;  background: #fbfb01;  border: 2px solid #e00;  border-radius: .4em;  padding: 2px;  font-size: 14px;  font-weight: 700;  cursor: pointer;}
	    .control{width: 400px; height: 25px; margin: 5px; font-family: sans-serif; text-indent: 10px; }
		#title{ margin-bottom: -15px; font-size: 15px; text-indent: 20px; }
	    .updatebtn, .btnclass{ width: 100%;}
    </style>
</head>
  <body class="skin-blue sidebar-mini" >
  				<div><table>
  						<tr>
  							<td><form action="partnerinfo.html" method="get"><button>Centre Selection</button> </form> </td>
  							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  							<td><form action="sectorinfo.html" method="post"><input type="hidden" name="partnerID" value="${PartnerID}"><input type="hidden"name="partnerName" value="${PartnerName}"><button >Sector Selection</button> </form></td>
  						</tr> 
  				     </table>
  				</div><br>
  
 	<c:choose>
	<c:when test="${CourseList != null}">				
			<div id="searchtable">
				<p>COURSE LIST &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Partner Info : ${PartnerID} &nbsp;&nbsp;${PartnerName}</p>
	  		 	<div class="box">
        	 	<div class="box-body">
        	 	<table id="example1" class="table table-bordered table-striped">
               	<thead>
               		<tr>
					   	<td><b>COURSE ID</b></td>
					   	<td><b>SECTOR NAME</b></td>
					   	<td><b>COURSE NAME</b></td>
					   	<td><b>ACTION</b></td>
					   	<td><b>ACTION</b></td>
				      </tr>
                </thead>
        	 	<tbody>
        	 			<c:forEach items="${CourseList}" var="course">
				    	<tr>
					    	<td>${course.courseID}</td>
					    	<td>${course.sectorName}</td>
					    	<td>${course.courseName}</td>
					    	<td><button name="update" class="btnclass" onclick="updateSector('${course.courseID}','${course.sectorName}','${course.courseName}')" >update</button></td>
					    	<td><form action="batchinfo.html" method="post">
						    	<input type="hidden" name="courseID" value="${course.courseID}"/>
						    	<input type="hidden" name="sectorName" value="${course.sectorName}"/>
						    	<input type="submit" value="select"  class="btnclass">
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

<div id="update-sector" style="display: none">
<div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE SECTOR COURSE INFO</label><hr>    	
     	<form action="updatesector.html" method="post" autocomplete="off">
	
		<table class="tableforuser">
			<tr> 
				<td></td>
				<td><label>SECTOR ID</label></td>
				<td><input type="text" class="control" name="courseID" id="courseID" readonly="readonly"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>SECTOR NAME</label></td>
				<td><select name="sectorName" id="sectorName" class="control">
							<option value="ESSCI">ESSCI</option>
							<option value="IT/ITeS">IT/ITeS</option>
							<option value="Telecom">Telecom</option>
							<option value="Retail">Retail</option>
							<option value="GJSCS">GJSCS</option>
							<option value="LSSSDC">LSSSDC</option>
							<option value="CGSC">CGSC</option>
							<option value="Business Correspondent">Business Correspondent</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRoles"></a></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>COURSE NAME</label></td>
				<td><select name="courseName" id="courseName" class="control">
							<option value="Field Technician Computing and Peripherals">Field Technician Computing and Peripherals</option>
							<option value="Field Technician Networking and Storage">Field Technician Networking and Storage</option>
							<option value="DTH Settop Box Installer and Service Technicain">DTH Settop Box Installer and Service Technicain</option>
							<option value="CCTV Installation Technician">CCTV Installation Technician</option>
							<option value="Field Engineer – RACW">Field Engineer RACW</option>
							<option value="Domestic Data entry operator">Domestic Data entry operator</option>
							<option value="Domestic IT Helpdesk Attendant">Domestic IT Helpdesk Attendant</option>
							<option value="Domestic Biometric Data Operator">Domestic Biometric Data Operator</option>
							<option value="In-Store Promoter">In-Store Promoter</option>
							<option value="Optical Fiber Technician">Optical Fiber Technician</option>
							<option value="Broadband Technician">Broadband Technician</option>
							<option value="Handset Repair Engineer (Level-2)">Handset Repair Engineer (Level-2)</option>
							<option value="Tower Technician">Tower Technician</option>
							<option value="Sales Executive (Broadband)">Sales Executive (Broadband)</option>
							<option value="Retail Sales Associate">Retail Sales Associate</option>
							<option value="BSC/Q0301">BSC/Q0301</option>
							<option value="Retail Jewellery Retail Sales Associate (Basic)">Retail Jewellery Retail Sales Associate (Basic)</option>
							<option value="Retail Jewellery Retail Sales Associate (Advance)">Retail Jewellery Retail Sales Associate (Advance)</option>
							<option value="Retail Store manager">Retail Store manager</option>
							<option value="Retail Floor Manager">Retail Floor Manager</option>
							<option value="Medical sales Representative">Medical sales Representative</option>
							<option value="CGSC CNC Operator – Vertical Machining Centre">CGSC CNC Operator – Vertical Machining Centre</option>
							<option value="CGSC CNC Operator Turning">CGSC CNC Operator Turning</option>
							<option value="CGSC CNC programmer">CGSC CNC programmer</option>
							<option value="CGSC CNC Setter cum operator Turning">CGSC CNC Setter cum operator – Turning</option>
							<option value="CGSC CNC Setter cum Operator – Vertical Machining Centre">CGSC CNC Setter cum Operator Vertical Machining Centre</option>
							<option value="Others">Others</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRoles"></a></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
	
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Sector" onclick= "return confirm_update()"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorInCreation"></a></td>
			</tr>
		</table>
	</form><br><br>
	</div><!-- /.box-body -->
	<span id="cls_f">X</span>
   </div><!-- /.box -->
</div>

<script type="text/javascript">
function updateSector(courseId,sectorName,courseName)
{
	window.location.hash = 'update-sector';
	document.getElementById('update-sector').style.display = "block";
	document.getElementById('courseID').value = courseId ;
	document.getElementById('sectorName').value = sectorName ;
	document.getElementById('courseName').value = courseName ;
	document.getElementById('cls_f').addEventListener('click', function()
			{
				this.parentNode.style.display = 'none';
			}, false);
}

function confirm_update() 
{
	  return confirm('Are you sure?');
}
</script>


 
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
 
 