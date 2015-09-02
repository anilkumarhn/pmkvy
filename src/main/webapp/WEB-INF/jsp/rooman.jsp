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
   #title{ margin-bottom: -15px; font-size: 15px; text-indent: 20px; }
    </style>
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
		#cls_f{  position: absolute; top: -4px;  right: -4px;  background: #fbfb01;  border: 2px solid #e00;  border-radius: .4em;  padding: 2px;  font-size: 14px;  font-weight: 700;  cursor: pointer;}
	</style>
	
</head>
  <body class="skin-blue sidebar-mini" >
  			<div><table>
  						<tr>
  							<td><form action="partnerinfo.html" method="get"><button>Centre Selection</button> </form> </td>
   						</tr> 
  				     </table></div>
  			<br>
  			
  
  	<c:choose>
	<c:when test="${PartnerList != null}">				
			<div id="searchtable">
				<label>Center List</label>
				<div class="box">
        	 	<div class="box-body">
        	 	<table id="example1" class="table table-bordered table-striped">
               	<thead>
               		<tr>
               		   	<td><b>ID</b></td>
					   	<td><b>CENTER NAME</b></td>
					   	<td><b>ADDRESS</b></td>
					   	<td><b>CONTACT NO</b></td>
					   	<td><b>CONTACT PERSON</b></td>
					   	<td><b>EMAIL ID</b></td>
					   	<td><b>PAN NO</b></td>
					   	<td><b>MOU</b></td>
					   	<td><b>TDS</b></td>
					   	<td><b>SHARE</b></td>
					   	<td><b>ACTION</b></td>
					   	<td><b>ACTION</b></td>
				      </tr>
                </thead>
        	 	<tbody>
        	 			<c:forEach items="${PartnerList}" var="partner">
				    	<tr>
					    	<td>${partner.partnerID}</td>
					    	<td>${partner.partnerName}</td>
					    	<td>${partner.address}</td>
					    	<td>${partner.contactNumber}</td>
					    	<td>${partner.contactPerson}</td>
					    	<td>${partner.emailID}</td>
					    	<td>${partner.panNumber}</td>
					    	<td>${partner.mouSigned}</td>
					    	<td>${partner.tds}</td>
					    	<td>${partner.partnerShare}</td>
					    	<td><button name="update" class="btnclass"  onclick="updatepartner('${partner.partnerID}','${partner.partnerName}','${partner.address}','${partner.contactNumber}','${partner.contactPerson}','${partner.emailID}','${partner.panNumber}','${partner.mouSigned}','${partner.tds}','${partner.partnerShare}');">update</button> </td>
				    
				        	<td> <form action="sectorinfo.html" method="post">
						    	<input type="hidden" name="partnerID" value="${partner.partnerID}"/>
						    	<input type="hidden" name="partnerName" value="${partner.partnerName}"/>
						    	<input type="submit" class="btnclass" value="select" >
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
function updatepartner(pid,pname,address,contactno,contactperson,emailid,pannumber,mou,tds,pshare)
{
	window.location.hash = 'update-partner';
	document.getElementById('update-partner').style.display = "block";
	document.getElementById('partnerID').value = pid ;
	document.getElementById('partnerName').value = pname ;
	document.getElementById('address').value = address ;
	document.getElementById('contactNumber').value = contactno ;
	document.getElementById('contactPerson').value = contactperson ;
	document.getElementById('emailID').value = emailid ;
	document.getElementById('panNumber').value = pannumber ;
	document.getElementById('mouSigned').value = mou ;
	document.getElementById('tds').value = tds;
	document.getElementById('partnerShare').value = pshare ;
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

<div id="update-partner" style="display: none;">

     <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE PARTNER INFO</label><hr>    	
     	<form action="updatepartner.html" method="post" autocomplete="off"  name="update-partner">
	<c:choose>
	<c:when test="${USER_ROLE == 'Super Admin'}">				
	
		<table class="tableforuser">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label>PARTNER ID</label> </td>
				<td><input class="control" type="text" name="partnerID" id="partnerID" readonly="readonly" ></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >CENTER NAME</label></td>
				<td><input class="control" type="text" name="partnerName" id="partnerName" onkeyup="validatePartnerName(this.value,'vpartnerName'); return false;"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td id="vpartnerName" ></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>ADDRESS</label></td>
				<td><textarea class="control" rows="2" cols="50" id="address" name="address"></textarea> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>CONTACT NO</label></td>
				<td><input class="control" type="text" name="contactNumber" id="contactNumber"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>E-Mail ID</label></td>
				<td><input type="text" class="control" name="emailID" id="emailID"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>CONTACT PERSON</label></td>
				<td><input type="text" class="control" name="contactPerson" id="contactPerson"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>PAN NUMBER</label></td>
				<td><input type="text" class="control" name="panNumber" id="panNumber"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
	
			<tr> 
				<td></td>
				<td><label>MOU SIGNED</label></td>
				<td><select name="mouSigned" id="mouSigned" class="control">
							<option></option>
							<option value="yes">yes</option>
							<option value="no">no</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRoles"></a></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>TDS</label></td>
				<td><input type="text" class="control" name="tds" id="tds"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>PARTNER SHARE</label></td>
				<td><input type="text" class="control" name="partnerShare" id="partnerShare"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
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
				<td><input class="control"  type="submit" value="Update Partner" onclick= "return confirm_update()"	></td>
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
				<td><label>PARTNER ID</label> </td>
				<td><input class="control" type="text" name="partnerID" id="partnerID" readonly="readonly" ></td>
				<td></td>
				<td></td>
			</tr>
		
			<tr> 
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><label >CENTER NAME</label></td>
				<td><input class="control" type="text" name="partnerName" id="partnerName" onkeyup="validatePartnerName(this.value,'vpartnerName'); return false;"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td id="vpartnerName" ></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>ADDRESS</label></td>
				<td><textarea class="control" rows="2" cols="50" id="address" name="address"></textarea> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>CONTACT NO</label></td>
				<td><input class="control" type="text" name="contactNumber" id="contactNumber"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>E-Mail ID</label></td>
				<td><input type="text" class="control" name="emailID" id="emailID"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>CONTACT PERSON</label></td>
				<td><input type="text" class="control" name="contactPerson" id="contactPerson"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>PAN NUMBER</label></td>
				<td><input type="text" class="control" name="panNumber" id="panNumber" readonly="readonly" ></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
	
			<tr> 
				<td></td>
				<td><label>MOU SIGNED</label></td>
				<td><select name="mouSigned" id="mouSigned" class="control">
							<option></option>
							<option value="yes">yes</option>
							<option value="no">no</option>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorRoles"></a></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>TDS</label></td>
				<td><input type="text" class="control" name="tds" id="tds"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>PARTNER SHARE</label></td>
				<td><input type="text" class="control" name="partnerShare" id="partnerShare"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
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
				<td><input class="control"  type="submit" value="Update Partner" onclick= "return confirm_update()"	></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a id="errorInCreation"></a></td>
			</tr>
		</table>
		</c:when>
		</c:choose>
	</form><br><br>
	</div><!-- /.box-body -->
	<span id="cls_f">X</span>
   </div><!-- /.box -->
</div>
 <script src="tablecss/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="tablecss/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="tablecss/plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="tablecss/plugins/fastclick/fastclick.min.js"></script>
  	<script type="text/javascript" src="js/form/validateform.js"></script>
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
 
 