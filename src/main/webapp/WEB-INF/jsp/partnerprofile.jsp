 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Tables</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="tablecss/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/form/validateform.js"></script>
    <style type="text/css">
    	label{margin: 8px;}
    	.th{ font-size: 16px;  text-align:center; background-color:#3c8dbc; color: white;}
    	.td{text-align: center;}
    	</style>
</head>
  <body class="skin-blue sidebar-mini">
    <h4><b>Partner Profile</b></h4>
    
		    <table id="partnerprf" border="2px" width="100%">
			    <tr>
			    	<th class="th">Partner ID</th>
			    	<th class="th">Partner Name</th>
			    	<th class="th">Address</th>
			    	<th class="th">Contact No</th>
			    	<th class="th">Contact Person</th>
			    	<th class="th">Email</th>
			    	<th class="th">Pan No</th>
			    	<th class="th">Mou Signed</th>
			    	<th class="th">Tds</th>
			    	<th class="th">Share</th>
			
			    </tr>
			    <tr>
			    	<td class="td">${PARTNER_INFO.partnerID}</td>
			    	<td class="td">${PARTNER_INFO.partnerName}</td>
			    	<td class="td">${PARTNER_INFO.address}</td>
			    	<td class="td">${PARTNER_INFO.contactNumber}</td>
			    	<td class="td">${PARTNER_INFO.contactPerson}</td>
			    	<td class="td">${PARTNER_INFO.emailID}</td>
			    	<td class="td">${PARTNER_INFO.panNumber}</td>
			    	<td class="td">${PARTNER_INFO.mouSigned}</td>
			    	<td class="td">${PARTNER_INFO.tds}</td>
			    	<td class="td">${PARTNER_INFO.partnerShare}</td>
		
			    </tr>
	    </table>
	 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  </body>
</html>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 