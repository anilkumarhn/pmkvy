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
  			
    <p>Bank Account&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Partner Info : ${PartnerID} &nbsp;&nbsp;${PartnerName},&nbsp;&nbsp;&nbsp;&nbsp; Sector Info : ${courseID} &nbsp;&nbsp;${sectorName},&nbsp;&nbsp;&nbsp;&nbsp;Batch ID: ${batchID},&nbsp;&nbsp;&nbsp;&nbsp;Candidate ID: ${candidateID}</p>
       <div class="box">
	   <div class="box-body" align="left">
		    <table id="tableprf" border="1px" width="100%">
			    <tr>
			    	<td id="th">Account No</td>
			    	<td id="th">Bank Name</td>
			    	<td id="th">Branch</td>
			    	<td id="th">IFSC Code</td>
			    	<td id="th">Bank Group</td>
			    	<td id="th">&nbsp;&nbsp;Action&nbsp;&nbsp;</td>
			    </tr>
			    <tr>
			    	<td id="val">${AccountInfo.accountNo}</td>
			    	<td id="val">${AccountInfo.bankName}</td>
			    	<td id="val">${AccountInfo.branchName}</td>
			    	<td id="val">${AccountInfo.ifscCode}</td>
			    	<td id="val">${AccountInfo.bankGroup}</td>
			    	<td><input id="update" type="submit" value="update" onclick="updateAccount('${AccountInfo.accountNo}','${AccountInfo.bankName}','${AccountInfo.branchName}','${AccountInfo.ifscCode}','${AccountInfo.bankGroup}')" > </td>
			    </tr>
			</table>
		</div>
	</div>

	<script type="text/javascript">
		function updateAccount(accountNo, bankName, branchName, ifscCode, bankGroup)
		{
			window.location.hash = 'update-sector';
			document.getElementById('updateAccount').style.display = "block";
			document.getElementById('accountNo').value = accountNo;
			document.getElementById('bankName').value = bankName;
			document.getElementById('branchName').value = branchName;
			document.getElementById('ifscCode').value = ifscCode;
			document.getElementById('bankGroup').value = bankGroup;
		}
		
		function confirm_update() 
		{
			  return confirm('Are you sure?');
		}
	</script>
	
	 <div id="updateAccount" style="display: none;">
	 <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE ACCOUNT INFO</label><hr>    	
     	<form action="updateAccount.html" method="post" autocomplete="off">
			<c:choose>
				<c:when test="${USER_ROLE == 'Super Admin'}">				
					<table class="tableforuser">
			<tr> 
				<td></td>
				<td><label>ACCOUNT NO</label></td>
				<td><input type="text" class="control" name="accountNo" id="accountNo" ></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>BANK NAME</label></td>
				<td><select name="bankName" id="bankName" class="control">
							<option value="State Bank of India">State Bank of India</option>
							<option value="State Bank of Mysore">State Bank of Mysore</option>
							<option value="Canera Bank">Canera Bank</option>
							<option value="Indian Bank">Indian Bank</option>
							<option value="Vijaya Bank">Vijaya Bank</option>
							<option value="Federal Bank">Federal Bank</option>
							<option value="Other">Other</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>BRANCH NAME</label></td>
				<td><textarea name="branchName" id="branchName" class="control" rows="3"></textarea></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>IFSC CODE</label></td>
				<td><input type="text" class="control" name="ifscCode" id="ifscCode"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>BANK GROUP</label></td>
				<td><input type="text" class="control" name="bankGroup" id="bankGroup"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Account" onclick= "return confirm_update()"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>	
				</c:when>
				<c:when test="${USER_ROLE == 'Data Manager'}">				
					<table class="tableforuser">
			<tr> 
				<td></td>
				<td><label>ACCOUNT NO</label></td>
				<td><input type="text" class="control" name="accountNo" id="accountNo" readonly="readonly"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>BANK NAME</label></td>
				<td><select name="bankName" id="bankName" class="control">
							<option value="State Bank of India">State Bank of India</option>
							<option value="State Bank of Mysore">State Bank of Mysore</option>
							<option value="Canera Bank">Canera Bank</option>
							<option value="Indian Bank">Indian Bank</option>
							<option value="Vijaya Bank">Vijaya Bank</option>
							<option value="Federal Bank">Federal Bank</option>
							<option value="Other">Other</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>BRANCH NAME</label></td>
				<td><textarea name="branchName" id="branchName" class="control" rows="3"></textarea></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
	
			<tr> 
				<td></td>
				<td><label>IFSC CODE</label></td>
				<td><input type="text" class="control" name="ifscCode" id="ifscCode"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>BANK GROUP</label></td>
				<td><input type="text" class="control" name="bankGroup" id="bankGroup"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Account" onclick= "return confirm_update()"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
				</c:when>
			</c:choose>
		</form><br><br>
	</div>
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
			    	<td id="th">Column 3</td>
			    	<td id="th">Action</td>
			    </tr>
			    <c:forEach items="${AssessmentFees}" var="fees">
			    <tr>
			    	<td id="val">${fees.assessmentID}</td>
			    	<td id="val">${fees.assesssmentFee}</td>
			    	<td id="val">${fees.paidBy}</td>
			    	<td id="val">-</td>
			    	<td id="val">-</td>
			    	<td id="val">-</td>
			    	<td><input id="update" type="submit" value="update" onclick="updateAssmtFee('${fees.assessmentID}','${fees.assesssmentFee}','${fees.paidBy}')"> </td>
			    </tr>
			    </c:forEach>
		    </table>
		</div>
	</div>     
	
	<script type="text/javascript">
		function updateAssmtFee(assessmentID, assesssmentFee, paidBy)
		{
			window.location.hash = 'updateAssmtFee';
			document.getElementById('updateAssmtFee').style.display = "block";
			document.getElementById('assessmentID').value = assessmentID;
			document.getElementById('assesssmentFee').value = assesssmentFee;
			document.getElementById('paidBy').value = paidBy;
		}
	</script>
	
	 <div id="updateAssmtFee" style="display: none;">
	 <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE ASSESSMENT FEE INFO</label><hr>    	
     	<form action="updateassmtfee.html" method="post" autocomplete="off">
	
		<table class="tableforuser">
			<tr> 
				<td></td>
				<td><label>ASSESSMENT ID</label></td>
				<td><input type="text" class="control" name="assessmentID" id="assessmentID" readonly="readonly"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>ASSESSMENT FEE</label></td>
				<td><input type="text" class="control" name="assesssmentFee" id="assesssmentFee"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			
			<tr> 
				<td></td>
				<td><label>PAID BY</label></td>
				<td><select name="paidBy" id="paidBy" class="control">
							<option value="Rooman">Rooman</option>
							<option value="Student">Student</option>
							<option value="Partner">Partner</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update AssessmentFee" onclick= "return confirm_update()"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
	</form><br><br>
	</div>
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
			    	<td id="th">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Action&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			    </tr>
			    <c:forEach items="${AssessmentResults}" var="asstresult">
			    <tr>
			    	<td id="val">${asstresult.assessmentID}</td>
			    	<td id="val">${asstresult.result}</td>
			    	<td id="val">${asstresult.certIssuedByNSDC}</td>
			    	<td id="val">${asstresult.certIssuedToStudent}</td>
			    	<td id="val">${asstresult.nsdcProcessed}</td>
			    	<td id="val">${asstresult.disbursementList}</td>
			    	<td><input id="update" type="submit" value="update" onclick="updateAssmtResult('${asstresult.assessmentID}','${asstresult.result}','${asstresult.certIssuedByNSDC}','${asstresult.certIssuedToStudent}','${asstresult.nsdcProcessed}','${asstresult.disbursementList}')"></td>
			    </tr>
			    </c:forEach>
		    </table>
		</div>
	</div>     
	
	
	<script type="text/javascript">
		function updateAssmtResult(assessmentID, result, certIssuedByNSDC, certIssuedToStudent, nsdcProcessed, disbursementList)
		{
			window.location.hash = 'updateAssmtResult';
			document.getElementById('updateAssmtResult').style.display = "block";
			document.getElementById('assessmentId').value = assessmentID;
			document.getElementById('result').value = result;
			document.getElementById('certIssuedByNSDC').value = certIssuedByNSDC;
			document.getElementById('certIssuedToStudent').value = certIssuedToStudent;
			document.getElementById('nsdcProcessed').value = nsdcProcessed;
			document.getElementById('disbursementList').value = disbursementList;
		}
	</script>
	
	 <div id="updateAssmtResult" style="display: none;">
	 <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE ASSESSMENT RESULT INFO</label><hr>    	
     	<form action="updateassmtresult.html" method="post" autocomplete="off">
	
		<table class="tableforuser">
			<tr> 
				<td></td>
				<td><label>ASSESSMENT ID</label></td>
				<td><input type="text" class="control" name="assessmentID" id="assessmentId" readonly="readonly"></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>ASSMT RESULT</label></td>
				<td><select name="result" id="result" class="control">
							<option value="Pass">Pass</option>
							<option value="Fail">Fail</option>
							<option value="Not Applicable">Not Applicable</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>CERT ISSUED BY NSDC</label></td>
				<td><select name="certIssuedByNSDC" id="certIssuedByNSDC" class="control">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
							<option value="Not Applicable">Not Applicable</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>CERT ISSUED TO STUDENT</label></td>
				<td><select name="certIssuedToStudent" id="certIssuedToStudent" class="control">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
							<option value="Not Applicable">Not Applicable</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			
			
			<tr> 
				<td></td>
				<td><label>NSDC PROCESSED</label></td>
				<td><select name="nsdcProcessed" id="nsdcProcessed" class="control">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
							<option value="Not Applicable">Not Applicable</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>DISBURSEMENT LIST</label></td>
				<td><input type="text" class="control" name="disbursementList" id="disbursementList"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Assessment Result" onclick= "return confirm_update()"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
	</form><br><br>
	</div>
    </div>			
	</div>
	
	
 	<p>Govt Remits</p>
       <div class="box">
	   <div class="box-body" align="left">
		    <table id="tableprf" border="2px" width="100%">
			    <tr>
			    	<td id="th">Transaction ID</td>
			    	<td id="th">Transacted Date</td>
			    	<td id="th">Description</td>
			    	<td id="th">Cheque No</td>
			    	<td id="th">Credit / Debit</td>
			    	<td id="th">Amount INR</td>
			    	<td id="th">&nbsp;&nbsp;Action&nbsp;&nbsp;&nbsp;</td>
			    </tr>
			    <c:forEach items="${GovtRemits}" var="remits">
			    <tr>
			    	<td id="val">${remits.transactionID}</td>
			    	<td id="val">${remits.transactionDate}</td>
			    	<td id="val">${remits.description}</td>
			    	<td id="val">${remits.chequeNo}</td>
			    	<td id="val">${remits.creditDebit}</td>
			    	<td id="val">${remits.amountINR}</td>
			    	<td><input id="update" type="submit" value="update" onclick="updateRemits('${remits.transactionID}','${remits.transactionDate}','${remits.description}','${remits.chequeNo}','${remits.creditDebit}','${remits.amountINR}')" > </td>
			    </tr>
		    	</c:forEach>
		    </table>
		</div>
	</div>     

	
	<script type="text/javascript">
		function updateRemits(transactionID, transactionDate, description, chequeNo, creditDebit, amountINR)
		{
			window.location.hash = 'updategovtremits';
			document.getElementById('updategovtremits').style.display = "block";
			document.getElementById('transactionID').value = transactionID;
			document.getElementById('transactionDate').value = transactionDate;
			document.getElementById('description').value = description;
			document.getElementById('chequeNo').value = chequeNo;
			document.getElementById('creditDebit').value = creditDebit;
			document.getElementById('amountINR').value = amountINR;
		}
	</script>
	
	 <div id="updategovtremits" style="display: none;">
	 <div class="box">
     <div class="box-body" align="left"><br>
     	<label id="title">UPDATE ASSESSMENT FEE INFO</label><hr>    	
     	<form action="updategovtremits.html" method="post" autocomplete="off">
	
		<table class="tableforuser">
			<tr> 
				<td></td>
				<td><label>TRANSACTION ID</label></td>
				<td><input type="text" class="control" name="transactionID" id="transactionID" readonly="readonly"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>TRANSACTED DATE</label></td>
				<td><input type="date" class="control" name="transactionDate" id="transactionDate"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>DESCTIPTION</label></td>
				<td><textarea name="description" id="description" rows="3" class="control"></textarea> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>CHEQUE NO</label></td>
				<td><input type="text" class="control" name="chequeNo" id="chequeNo"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>CREDIT OR DEBIT</label></td>
				<td><select name="creditDebit" id="creditDebit" class="control">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
							<option value="Not Applicable">Not Applicable</option>
							</select></td>
							<td></td>
							<td></td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label>AMOUNT INR</label></td>
				<td><input type="text" class="control" name="amountINR" id="amountINR"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>
			</tr>
			
			<tr> 
				<td></td>
				<td><label ></label></td>
				<td><input class="control"  type="submit" value="Update Govt Remits" onclick= "return confirm_update()"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
	</form><br><br>
	</div>
    </div>			
	</div>
	
 </body>
</html>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 