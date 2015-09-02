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
  						</tr> 
  				     </table>
  			</div><br>
  			
  
  	<c:choose>
	<c:when test="${BatchList != null}">				
			<div id="searchtable">
				<p>BATCH LIST&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Partner Info : ${PartnerID} &nbsp;&nbsp;${PartnerName},&nbsp;&nbsp;&nbsp;&nbsp; Sector Info : ${courseID} &nbsp;&nbsp;${sectorName}</p>
	  		 	<div class="box">
        	 	<div class="box-body">
        	 	<table id="example1" class="table table-bordered table-striped">
               	<thead>
               		<tr>
					   	<td><b>BATCH ID</b></td>
					   	<td><b>BATCH SIZE</b></td>
					   	<td><b>START DATE</b></td>
					   	<td><b>END DATE</b></td>
					   	<td><b>TEST DATE</b></td>
					   	<td><b>TEST CONDUCTED</b></td>
					   	<td><b>ACTION</b></td>
					   	<td><b>ACTION</b></td>
				      </tr>
                </thead>
        	 	<tbody>
        	 			<c:forEach items="${BatchList}" var="batch">
				    	<tr>
					    	<td>${batch.batchID}</td>
					    	<td>${batch.batchSize}</td>
					    	<td>${batch.startDate}</td>
					    	<td>${batch.endDate}</td>
					    	<td>${batch.testDate}</td>
					    	<td>${batch.testConducted}</td>
					    
					    	<td><button name="update" class="btnclass" onclick="updateSector('${batch.batchID}','${batch.batchSize}','${batch.startDate}','${batch.endDate}','${batch.testDate}','${batch.testConducted}')" >update</button></td>
					    	
					    	<td> <form action="studentinfo.html" method="post">
						    	<input type="hidden" name="batchID" value="${batch.batchID}"/>
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
function updateSector(batchId,bsize,startdate,endDate,testDate,status)
	{
		window.location.hash = 'update-batch-info';
		document.getElementById('update-batch-info').style.display = "block";
		
		document.getElementById('batchID').value = batchId ;
		document.getElementById('batchSize').value = bsize ;
		document.getElementById('startDate').value = startdate ;
		document.getElementById('endDate').value = endDate ;
		document.getElementById('testDate').value = testDate ;
		document.getElementById('testConducted').value = status ;
		
	}

	function confirm_update() 
	{
		  return confirm('Are you sure?');
	}	

</script>


<div id="update-batch-info" style="display: none;">

     <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE BATCH INFO</label><hr>    	
     	<form action="updatebatch.html" method="post" autocomplete="off" >
	<c:choose>
	<c:when test="${USER_ROLE == 'Super Admin'}">				
	
		<table class="tableforuser">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label>BATCH ID</label> </td>
				<td><input class="control" type="text" name="batchID" id="batchID" readonly="readonly" ></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >BATCH SIZE</label></td>
				<td><input class="control" type="text" name="batchSize" id="batchSize"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>START DATE</label></td>
				<td><input class="control" type="date" name="startDate" id="startDate"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>END DATE</label></td>
				<td><input type="date" class="control" name="endDate" id="endDate"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>TEST DATE</label></td>
				<td><input type="date" class="control" name="testDate" id="testDate"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>TEST CONDUCTED</label></td>
				<td><select name="testConducted" id="testConducted" class="control">
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
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Batch"  onclick="return confirm_update()"> </td>
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
				<td><label>BATCH ID</label> </td>
				<td><input class="control" type="text" name="batchID" id="batchID" readonly="readonly" ></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >BATCH SIZE</label></td>
				<td><input class="control" type="text" name="batchSize" id="batchSize" readonly="readonly"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>START DATE</label></td>
				<td><input class="control" type="date" name="startDate" id="startDate"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>END DATE</label></td>
				<td><input type="date" class="control" name="endDate" id="endDate"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>TEST DATE</label></td>
				<td><input type="date" class="control" name="testDate" id="testDate"></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>TEST CONDUCTED</label></td>
				<td><select name="testConducted" id="testConducted" class="control">
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
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Batch"  onclick="return confirm_update()"> </td>
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
 
 