<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery.js"></script>
<script> 
$(document).ready(function(){
  $(".edit_row1").click(function(){
    $("#edit_form1").slideToggle("slow");
  });
});
</script>
<script> 
$(document).ready(function(){
  $(".edit_row2").click(function(){
    $("#edit_form2").slideToggle("slow");
  });
});
</script>

<script> 
$(document).ready(function(){
  $(".edit_row3").click(function(){
    $("#edit_form3").slideToggle("slow");
  });
});
</script>

<style type="text/css"> 
#edit_form1,.edit_row1,#edit_form2,.edit_row2,#edit_form3,.edit_row3
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#edit_form1,#edit_form2,,#edit_form3
{
padding:50px;
display:none;
}
</style>


<style type="text/css">
#t_id1,#t_id2,#t_id3 {
  margin: 1% auto;
}
#t_id1,#t_id2,#t_id3, #t_id1 td,#t_id2 td,#t_id3 td {
  border: 1px solid #333;
  padding: 1px;
}
#t_id1 .edit_row1 {
  background: #fbfb01;
  font-weight: 700;
  cursor: pointer;
}
#t_id2 .edit_row2 {
  background: #fbfb01;
  font-weight: 700;
  cursor: pointer;
}
#t_id3 .edit_row3 {
  background: #fbfb01;
  font-weight: 700;
  cursor: pointer;
}
#edit_form1 {
  display: none;
  position: relative;
  margin: 1% auto;
  width:60em;
  background: #f8f9fb;
  text-align: center;
}
#edit_form2 {
  display: none;
  position: relative;
  margin: 1% auto;
  width:60em;
  background: #f8f9fb;
  text-align: center;
}
#edit_form3 {
  display: none;
  position: relative;
  margin: 1% auto;
  width:60em;
  background: #f8f9fb;
  text-align: center;
}
#cls_f {
  position: absolute;
  top: -4px;
  right: -4px;
  background: #fbfb01;
  border: 2px solid #e00;
  border-radius: .4em;
  padding: 2px;
  font-size: 14px;
  font-weight: 700;
  cursor: pointer;
}
</style>



<style type="text/css">
#t_id {
  margin: 1% auto;
}
#t_id,t_id tr, #t_id td {
  border: 1px solid #333;
  padding: 1px;
}
#t_id .edit_row1 {
  background: #fbfb01;
  font-weight: 700;
  cursor: pointer;
}
#t_id .edit_row2 {
  background: #fbfb01;
  font-weight: 700;
  cursor: pointer;
}
#t_id .edit_row3 {
  background: #fbfb01;
  font-weight: 700;
  cursor: pointer;
}

		#edit_form1 label{
			display: inline-block;
			width: 250px;
			text-align: left;
		}

#edit_form2 {
  display: none;
  position: relative;
  margin: 1% auto;
  width: 60em;
  background: #f8f9fb;
  text-align: center;
}
#edit_form3 {
  display: none;
  position: relative;
  margin: 1% auto;
  width: 60em;
  background: #f8f9fb;
  text-align: center;
}
#cls_f1,#cls_f2,#cls_f3 {
  position: absolute;
  top: -4px;
  right: -4px;
  background: #fbfb01;
  border: 2px solid #e00;
  border-radius: .4em;
  padding: 2px;
  font-size: 14px;
  font-weight: 700;
  cursor: pointer;
}
</style>
</head>

<body>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<title>student</title>
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="css/tabstyles.css" />
  		<script src="js/modernizr.custom.js"></script>

<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
<style type="text/css">

table { 
		 
 		  margin: 0 auto; 
		  font-size: 16px;
		  border: 1px solid #ccc;
 		  border-width: 1px 0 0 1px; 
 		  border-collapse: collapse; 
   }

td { padding: 10px; border: 1px solid #ccc; border-width: 0 1px 1px 0; }
tr:hover td { background: #CAEFFD; color: #0768B3; cursor: pointer; }
</style>

	</head>
	<body>
			
				<div class="tabs tabs-style-underline">
					<nav>
						<ul>
							<li><a href="#section-underline-1" class="icon icon-home"><span>STUDENT INFO</span></a></li>
							<li><a href="#section-underline-2" class="icon icon-gift"><span>ASSESSMENT RESULT</span></a></li>
							<li><a href="#section-underline-3" class="icon icon-upload"><span>GOVT REMITS</span></a></li>
							
						</ul>
					</nav>
					
					<div class="content-wrap">
						<section id="section-underline-1">
							<label path="" align="left">Branch Name : </label><input type="button" value="Rajajinagar " onclick="javascript:history.go(-2)">
							<label path="" align="left">Sector Name : </label><input type="button" value="Agriculture Sector Skill Council of India " onclick="javascript:history.go(-1)">
							<label path="" align="left">Course Name : </label><input type="button" value="Electronic " onclick="javascript:history.go(-1)">
  	
								<table id="t_id" class="table table-striped table-bordered templatemo-user-table">
									<thead>
						 				<tr>
						                    <td class="white-text templatemo-sort-by">Candidate ID <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Candidate Name <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Enrollment No <span class="caret"></span></td>
						                     <td class="white-text templatemo-sort-by">Contact No <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Email ID <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Address <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Aadhar Number <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Aadhar Number Validated<span class="caret"></span></td>
						                 	<td class="white-text templatemo-sort-by">Edit <span class="caret"></span></td>
						                  </tr>
						 			</thead>
									<tbody>
									 	<c:forEach items="${govtRemitsList}" var="govtRemit">
									           <tr>
									                  <c:forEach items="${govtRemit.students}" var="student"> 
														   <td class="row_candidateID">${student.candidateID}</td>
														   <td class="row_candidateName">${student.candidateName}</td>
													       <td class="row_enrollmentNo">${student.enrollmentNo}</td>
														   <td class="row_contactNo">${student.contactNo}</td>
														   <td class="row_emailID">${student.emailID}</td>
														   <td class="row_address">${student.address}</td>
														   <td class="row_aadharNo">${student.aadharNo}</td>
													       <td class="row_aadharValidated">${student.aadharValidated}</td>
														   <td class="edit_row1">&#x2710;Edit</td>
													  </c:forEach>
											   </tr>
									     </c:forEach>
														  
									</tbody>
								</table>

								<form action="editstudent.html" method="post" id="edit_form1">
										<div>
											<label for="candidateID">Candidate ID :</label>
											<input type="text"  name="candidateID" id="candidateID" />
										</div>
										<div>
											<label for="candidateID">Candidate Name :</label>
											<input type="text" name="candidateName" id="candidateName" />
										</div>
										<div>
											<label for="candidateID">Enrollment No :</label>
											<input type="text" name="enrollmentNo" id="enrollmentNo" />
										</div>
										<div>
											<label for="candidateID">Contact No : </label>
											<input type="text" name="contactNo" id="contactNo" />
										</div>
										<div>
											<label for="candidateID">Email ID :</label>
											 <input type="text" name="emailID" id="emailID" />
										</div>
										<div>
											<label for="candidateID"> Address :</label>
											 <input type="text" name="address" id="address" />
										</div>
											<div>
											<label for="candidateID">Aadhar Number  :</label>
											 <input type="text" name="aadharNo" id="aadharNo" />
										</div>
											<div>
											<label for="candidateID">Aadhar Number Validated :</label>
											 <input type="text" name="aadharValidated" id="aadharValidated" />
										</div>
										<input type="submit" value="Send" /><span id="cls_f1">X</span>
								
								</form>

						
						</section>
						
						<section id="section-underline-2">
							<label path="" align="left">Branch Name : </label><input type="button" value="Rajajinagar " onclick="javascript:history.go(-2)">
							<label path="" align="left">Sector Name : </label><input type="button" value="Agriculture Sector Skill Council of India " onclick="javascript:history.go(-1)">
  							<label path="" align="left">Branch Name : </label><input type="button" value="Rajajinagar " onclick="javascript:history.go(-2)">
	
								<table id="t_id" class="table table-striped table-bordered templatemo-user-table">
									<thead>
						 				<tr>
						 					<td class="white-text templatemo-sort-by">Candidate ID <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Candidate Name <span class="caret"></span></td>
						                   	<td class="white-text templatemo-sort-by">Assessment ID <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Result approved by SSC <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Certification Issued By NSDC <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Monetary Reward Tracker- NSDC Processed <span class="caret"></span></td>
							                <td class="white-text templatemo-sort-by">Certification Issued To Student <span class="caret"></span></td>
							                <td class="white-text templatemo-sort-by">Monetary Reward Tracker-Disbursement List <span class="caret"></span></td>
							                <td class="white-text templatemo-sort-by">Edit <span class="caret"></span></td>
						                  </tr>
						 		   	</thead>
									
									<tbody>
				 					
				 						<c:forEach items="${govtRemitsList}" var="govtRemit">
				                  
				                	  		<c:forEach items="${govtRemit.students}" var="student"> 
							                  	<tr>
							                  		<c:forEach items="${student.assessmentResult}" var="assmtResult">
								                  		<td class="row_candidateID">${student.candidateID}</td>
								                  	    <td class="row_candidateName">${student.candidateName}</td>
								                 		<td class="row_assessmentID">${assmtResult.assessmentID}</td>
								                 		<td class="row_result">${assmtResult.result}</td>
								                 		<td class="row_certIssuedByNSDC">${assmtResult.certIssuedByNSDC}</td>
								                 		<td class="row_certIssuedToStudent">${assmtResult.certIssuedToStudent}</td>
								                 		<td class="row_nsdcProcessed">${assmtResult.nsdcProcessed}</td>
								                 		<td class="row_disbursementList">${assmtResult.disbursementList}</td>
								                 		<td class="edit_row2">&#x2710;Edit</td>
								          			</c:forEach>
							                    </tr>
						            	    </c:forEach>
						                </c:forEach>
					  
									</tbody>
								</table>

									<form action="editstudassmt.html" method="post" id="edit_form2">
											<table >
													<tr><td align="left">Candidate ID : </td><td><input type="text" name="candidateID" id="student.candidateID" /><br/></td></tr>
													<tr>
														<td align="left">Candidate Name : </td><td><input type="text" name="candidateName" id="student.candidateName" /><br/></td></tr>
										 			<tr>
														<td align="left">Assessment ID : </td><td><input type="text" name="assessmentID" id="assessmentID" /><br/></td></tr>
													
										 			<tr>
														<td align="left"> Result approved by SSC :</td><td> <input type="text" name="result" id="result" /><br/></td></tr>
										  			<tr>
														<td align="left">Certification Issued By NSDC :</td><td> <input type="text" name="certIssuedByNSDC" id="certIssuedByNSDC" /><br/></td></tr>
										  			<tr>
														<td align="left">Monetary Reward Tracker- NSDC Processed :</td><td> <input type="text" name="certIssuedToStudent" id="certIssuedToStudent" /><br/></td></tr>
										  			<tr>
														<td align="left">Certification Issued To Student : </td><td><input type="text" name="nsdcProcessed" id="nsdcProcessed" /><br/></td></tr>
										  			<tr>
														<td align="left">Monetary Reward Tracker-Disbursement List :</td><td> <input type="text" name="disbursementList" id="disbursementList" /><br/></td></tr>
										    </table>
													<td align="center"><input type="submit" value="Send" /></td><br/></tr><span id="cls_f2">X</span>
									  
									</form>


						</section>
						
						<section id="section-underline-3">
							<label path="" align="left">Branch Name : </label><input type="button" value="Rajajinagar " onclick="javascript:history.go(-2)">
							<label path="" align="left">Sector Name : </label><input type="button" value="Agriculture Sector Skill Council of India " onclick="javascript:history.go(-1)">
							<label path="" align="left">Branch Name : </label><input type="button" value="Rajajinagar " onclick="javascript:history.go(-2)">
							
								<table id="t_id" class="table table-striped table-bordered templatemo-user-table">
									<thead>
						 				<tr>
						 					<td class="white-text templatemo-sort-by">Candidate ID <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Candidate Name <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Transaction ID <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Cheque No <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Credit/Debit <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Amount(INR) <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Transaction Date <span class="caret"></span></td>
						                    <td class="white-text templatemo-sort-by">Description<span class="caret"></span></td>
						                  	<td class="white-text templatemo-sort-by">Edit <span class="caret"></span></td>
						                  </tr>
						 			</thead>
								
									<tbody>
  										<c:forEach items="${govtRemitsList}" var="govtRemit">
							                <tr>
							                  <c:forEach items="${govtRemit.students}" var="student"> 
							                  		<td class="row_candidateID">${student.candidateID}</td>
							                  		 <td class="row_candidateName">${student.candidateName}</td>
							                 		<td class="row_transactionID">${govtRemit.transactionID}</td>
							                 		<td class="row_chequeNo">${govtRemit.chequeNo}</td>
							                 		<td class="row_creditDebit">${govtRemit.creditDebit}</td>
							                 		<td class="row_amountINR">${govtRemit.amountINR}</td>
							                 		<td class="row_transactionDate">${govtRemit.transactionDate}</td>
							                 		<td class="row_description">${govtRemit.description}</td>
							                 		<td class="edit_row3">&#x2710;Edit</td>
							                   </c:forEach>
							                </tr>
							             </c:forEach>
									 </tbody>
							     </table>

									<form action="editgovtremits.html" method="post" id="edit_form3">
										 <table>
												 <tr> <td>   Candidate ID :</td><td> <input type="text"  name="student.candidateID" id="govtRemit.student.candidateID" /><br/></td></tr>
											     <tr> <td> Candidate Name :</td><td> <input type="text" name="student.candidateName" id="govtRemit.student.candidateName" /><br/></td></tr>
												 <tr> <td>  Transaction ID :</td><td> <input type="text" name="transactionID" id="transactionID" /><br/></td></tr>
											     <tr> <td>  Cheque No : </td><td><input type="text" name="chequeNo" id="chequeNo" /><br/></td></tr>
												 <tr> <td> Credit/Debit :</td><td> <input type="text" name="creditDebit" id="creditDebit" /><br/></td></tr>
												 <tr> <td> Amount(INR) :</td><td><input type="text" name="amountINR" id="amountINR" /><br/></td></tr>
												 <tr> <td> Transaction Date :</td><td><input type="text" name="transactionDate" id="transactionDate" /><br/></td></tr>
												 <tr> <td> Description :</td><td><input type="text" name="description" id="description" /><br/></td></tr>
										 </table>
										  <input type="submit" value="Send" /> <span id="cls_f3">X</span>
									</form>


						</section>
						
					</div>
				</div>
			
		<script src="js/cbpFWTabs.js"></script>
		<script>
				(function() 
					{[].slice.call( document.querySelectorAll( '.tabs' ) ).forEach( function( el )
							{
								new CBPFWTabs( el );
							});
					})();
		</script>
		
	
		<script>
			// gets all the .edit_row cells, registers click to each one
				var edit_row = document.querySelectorAll('#t_id .edit_row1');
				for(var i=0; i<edit_row.length; i++)
				{
				  edit_row[i].addEventListener('click', function(e)
					 {
					    // get parent row, add data from its cells in form fields
					    var tr_parent = this.parentNode;
					    document.getElementById('candidateID').value = tr_parent.querySelector('.row_candidateID').innerHTML;
					    document.getElementById('candidateName').value = tr_parent.querySelector('.row_candidateName').innerHTML;
					    document.getElementById('enrollmentNo').value = tr_parent.querySelector('.row_enrollmentNo').innerHTML;
					    document.getElementById('contactNo').value = tr_parent.querySelector('.row_contactNo').innerHTML;
					    document.getElementById('emailID').value = tr_parent.querySelector('.row_emailID').innerHTML;
					    document.getElementById('address').value = tr_parent.querySelector('.row_address').innerHTML;
					    document.getElementById('aadharNo').value = tr_parent.querySelector('.row_aadharNo').innerHTML;
					    document.getElementById('aadharValidated').value = tr_parent.querySelector('.row_aadharValidated').innerHTML;
					     // display the form, and focus on a form field
					    document.getElementById('edit_form1').style.display = '';
					    document.getElementById('candidateID').focus();
					  }, false);
				 }
				
				// to hide #edit_form when click on #cls_f button
				document.getElementById('cls_f1').addEventListener('click', function(){ this.parentNode.style.display = 'none';}, false);
		</script>
		<script>
			// gets all the .edit_row cells, registers click to each one
			var edit_row = document.querySelectorAll('#t_id .edit_row2');
			for(var i=0; i<edit_row.length; i++)
			{
			  edit_row[i].addEventListener('click', function(e)
				{
				    // get parent row, add data from its cells in form fields
				    var tr_parent = this.parentNode;
				    document.getElementById('student.candidateID').value = tr_parent.querySelector('.row_candidateID').innerHTML;
				    document.getElementById('student.candidateName').value = tr_parent.querySelector('.row_candidateName').innerHTML;
				    document.getElementById('assessmentID').value = tr_parent.querySelector('.row_assessmentID').innerHTML;
				    document.getElementById('result').value = tr_parent.querySelector('.row_result').innerHTML;
				    document.getElementById('certIssuedByNSDC').value = tr_parent.querySelector('.row_certIssuedByNSDC').innerHTML;
				    document.getElementById('certIssuedToStudent').value = tr_parent.querySelector('.row_certIssuedToStudent').innerHTML;
				    document.getElementById('nsdcProcessed').value = tr_parent.querySelector('.row_nsdcProcessed').innerHTML;
				    document.getElementById('disbursementList').value = tr_parent.querySelector('.row_disbursementList').innerHTML;
				    
				    // display the form, and focus on a form field
				    document.getElementById('edit_form2').style.display = '';
				    document.getElementById('candidateName').focus();
				  }, false);
			 }
		
			// to hide #edit_form when click on #cls_f button
			document.getElementById('cls_f2').addEventListener('click', function(){ this.parentNode.style.display = 'none';}, false);
		</script>
		<script>
			// gets all the .edit_row cells, registers click to each one
			var edit_row = document.querySelectorAll('#t_id .edit_row3');
			for(var i=0; i<edit_row.length; i++)
			{
			  edit_row[i].addEventListener('click', function(e)
			    {
				    // get parent row, add data from its cells in form fields
				    var tr_parent = this.parentNode;
				    document.getElementById('govtRemit.student.candidateID').value = tr_parent.querySelector('.row_candidateID').innerHTML;
				    document.getElementById('govtRemit.student.candidateName').value = tr_parent.querySelector('.row_candidateName').innerHTML;
				    document.getElementById('transactionID').value = tr_parent.querySelector('.row_transactionID').innerHTML;
				    document.getElementById('chequeNo').value = tr_parent.querySelector('.row_chequeNo').innerHTML;
				    document.getElementById('creditDebit').value = tr_parent.querySelector('.row_creditDebit').innerHTML;
				    document.getElementById('amountINR').value = tr_parent.querySelector('.row_amountINR').innerHTML;
				    document.getElementById('transactionDate').value = tr_parent.querySelector('.row_transactionDate').innerHTML;
				    document.getElementById('description').value = tr_parent.querySelector('.row_description').innerHTML;
				    // display the form, and focus on a form field
				    document.getElementById('edit_form3').style.display = '';
				    document.getElementById('candidateName').focus();
				  }, false);
		    }
		
			// to hide #edit_form when click on #cls_f button
			document.getElementById('cls_f3').addEventListener('click', function(){ this.parentNode.style.display = 'none';}, false);
		</script>
	</body>
  </html>
 </body>

</html>