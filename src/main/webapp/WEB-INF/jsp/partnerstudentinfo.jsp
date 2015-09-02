 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Student Info</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="tablecss/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/form/validateform.js"></script>
    <style type="text/css">
    	.cu{ width: 300px; text-indent: 10px; font-family: sans-serif;}
    	label{margin: 8px;}
    	#th{ font-size: 16px; text-align: center; background-color:#3c8dbc; color: white;}
    	#update{ width: 100%; }
    	#val{font-family: sans-serif; text-align: center;}
    	#cpwd{width: 260px; text-indent: 10px; height: 25px;}
    	#savechanges{background-color: #3c8dbc; width: 100%;height: 25px; border: 2px; border-color: black; color: white; font-family: sans-serif;}
        .control{width: 400px; height: 25px; margin: 5px; font-family: sans-serif; text-indent: 10px; }
		#title{ margin-bottom: -15px; font-size: 15px; text-indent: 20px; }
	</style>
</head>
  <body class="skin-blue sidebar-mini">
    <div>
  			<table>
  						<tr>
  							<td><form action="partnerbatches.html" method="post">
								    	<input type="hidden" name="courseID" value="${pcourseID}"/>
								    	<input type="hidden" name="sectorName" value="${psectorName}"/>
								    	<input type="submit" value="Batch Selection" >
					    	</form></td>
					    	<td>&nbsp;&nbsp;&nbsp;</td>
  							<td>
  								<form action="partnerstudents.html" method="post">
	  								<input type="hidden" name="batchID" value="${pbatchID}">
	  								<button class="btnprev">Student Selection</button>
  								</form></td>
  					
  						</tr> 
  				     </table>
  			</div><br>
  		
    <p>Bank Account&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sector Info : ${pcourseID} &nbsp;&nbsp;${psectorName},&nbsp;&nbsp;&nbsp;&nbsp;Batch ID: ${pbatchID},&nbsp;&nbsp;&nbsp;&nbsp;Candidate ID: ${pcandidateID}</p>
       <div class="box">
	   <div class="box-body" align="left">
		    <table id="tableprf" border="1px" width="100%">
			    <tr>
			    	<td id="th">Account No</td>
			    	<td id="th">Bank Name</td>
			    	<td id="th">Branch</td>
			    	<td id="th">IFSC Code</td>
			    	<td id="th">Bank Group</td>
			    </tr>
			    <tr>
			    	<td id="val">${AccountInfo.accountNo}</td>
			    	<td id="val">${AccountInfo.bankName}</td>
			    	<td id="val">${AccountInfo.branchName}</td>
			    	<td id="val">${AccountInfo.ifscCode}</td>
			    	<td id="val">${AccountInfo.bankGroup}</td>
			    </tr>
			</table>
		</div>
	</div>
	
	 <p>Assessment Fee</p>
       <div class="box">
	   <div class="box-body" align="left">
		    <table id="tableprf" border="2px" width="100%">
			    <tr>
			    	<td id="th">Assessment ID</td>
			    	<td id="th">Assessment Fee</td>
			    	<td id="th">Paid By</td>
			    	<td id="th">Column 1</td>
			    	<td id="th">Column 2</td>
			    </tr>
			    <c:forEach items="${AssessmentFees}" var="fees">
			    <tr>
			    	<td id="val">${fees.assessmentID}</td>
			    	<td id="val">${fees.assesssmentFee}</td>
			    	<td id="val">${fees.paidBy}</td>
			    	<td id="val">-</td>
			    	<td id="val">-</td>
			    </tr>
			    </c:forEach>
		    </table>
		</div>
	</div>     
	
	
	
	 <p>Assessment Result</p>
       <div class="box">
	   <div class="box-body" align="left">
		    <table id="tableprf" border="2px" width="100%">
			    <tr>
			    	<td id="th">Assmt ID</td>
			    	<td id="th">Assmt Result</td>
			    	<td id="th">Certificate Issued By NSDC</td>
			    	<td id="th">Certificate Issued to Student</td>
			    	<td id="th">NSDC Processed</td>
			    	<td id="th">Disbursement List</td>
			    </tr>
			    <c:forEach items="${AssessmentResults}" var="asstresult">
			    <tr>
			    	<td id="val">${asstresult.assessmentID}</td>
			    	<td id="val">${asstresult.result}</td>
			    	<td id="val">${asstresult.certIssuedByNSDC}</td>
			    	<td id="val">${asstresult.certIssuedToStudent}</td>
			    	<td id="val">${asstresult.nsdcProcessed}</td>
			    	<td id="val">${asstresult.disbursementList}</td>
			    </tr>
			    </c:forEach>
		    </table>
		</div>
	</div>     
	
	<p>Govt Remits</p>
		<div class="box">
	   <div class="box-body" align="left">
		    <table id="tableprf" border="2px" width="100%">
			    <tr>
			    	<td id="th">Trans ID</td>
			    	<td id="th">Transacted Date	</td>
			    	<td id="th">Description</td>
			    	<td id="th">Cheque No</td>
			    	<td id="th">Credit/Debit</td>
			    	<td id="th">Amount INR</td>
			    </tr>
				<c:forEach items="${GovtRemits}" var="remits">
			    <tr>
			    	<td id="val">${remits.transactionID}</td>
			    	<td id="val">${remits.transactionDate}</td>
			    	<td id="val">${remits.description}</td>
			    	<td id="val">${remits.chequeNo}</td>
			    	<td id="val">${remits.creditDebit}</td>
			    	<td id="val">${remits.amountINR}</td>
			    </tr>
			    </c:forEach>
			    <tr> <td></td></tr>
		    </table><br>
		  <%--   <form action="remitrequest.html" method="post">
			<input type="hidden" name="transactionID" value="${remits.transactionID}">
			<input type="submit" class="btn btn-block btn-primary btn-flat" value="Request For Remit">
	</form> --%>
		</div>
	</div>	
 </body>
</html>
