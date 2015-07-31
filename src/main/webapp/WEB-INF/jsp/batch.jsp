<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Batch Details</title>
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
<style type="text/css">
</style>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
    <link href="css/editpage.css" rel="stylesheet">
    <style type="text/css">
    </style>
    
    
	<style type="text/css">
 .sector-centre {
  color:#08233e;
  font:8.4em Futura, ‘Century Gothic’, AppleGothic, sans-serif;
  font-size:120%;
  padding:14px;
  background:url(overlay.png) repeat-x center #ffcc00;
  background-color:rgba(255,204,0,1);
  border:1px solid #ffcc00;
  -moz-border-radius:10px;
  -webkit-border-radius:10px;
  border-radius:10px;
  border-bottom:1px solid #9f9f9f;
  -moz-box-shadow:inset 0 1px 0 rgba(255,255,255,0.5);
  -webkit-box-shadow:inset 0 1px 0 rgba(255,255,255,0.5);
  box-shadow:inset 0 1px 0 rgba(255,255,255,0.5);
  cursor:pointer;
 }
  </style>
</head>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      
    <script type="text/javascript" src="js/templatemo-script.js"></script>   


    
<body>

	<div  class="sector-centre">
		<label>Centre ID :<b><i>${centre}</i></b> </label>
		<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<label>Sector ID :<b><i>${sector}</i></b></label>
  </div>
  	<c:if test="${!empty batchList}">
            
            <table id="t_id" class="table table-striped table-bordered templatemo-user-table" >
               <thead>
                  	<tr>
                  	    <td class="white-text templatemo-sort-by">Centre ID <span class="caret"></span></td>
                	    <td class="white-text templatemo-sort-by">Batch ID <span class="caret"></span></td>
	                    <td class="white-text templatemo-sort-by">Course Name <span class="caret"></span></td>
	                    <td class="white-text templatemo-sort-by">Start Date <span class="caret"></span></td>
	                    <td class="white-text templatemo-sort-by">End Date <span class="caret"></span></td>
	                    <td class="white-text templatemo-sort-by">Test Date <span class="caret"></span></td>
	                    <td class="white-text templatemo-sort-by">Test Conducted <span class="caret"></span></td>
                  		<td class="white-text templatemo-sort-by">Edit <span class="caret"></span></td>
                  		<td class="white-text templatemo-sort-by">ViewStudentList <span class="caret"></span></td>
                  	</tr>
               </thead>
               <tbody>
                  <c:forEach items="${batchList}" var="batch">
                     <tr >
				            <td class="row_centreID">${batch.centreID}</td>
				            <td class="row_batchID">${batch.batchID}</td>
				            <td class="row_sectorName">${batch.sectorName}</td>
				            <td class="row_startDate">${batch.startDate}</td>
				            <td class="row_endDate">${batch.endDate}</td>
				            <td class="row_testDate">${batch.testDate}</td>
				            <td class="row_testConducted">${batch.testConducted}</td>
            		        <td class="edit_row">&#x2710;Edit</td> 
            		        <td align="center"><form action="studentList.html?batchID=${batch.batchID}" method="POST">
            		        						<input type="submit" value="ViewStudentList"/>
            		        </form></td>
            		        <%-- <td align="center"><a href="studentList.html?batchID=${batch.batchID}">ViewStudentList</a></td> --%>
		 			 </tr>
		  		   </c:forEach>
                </tbody>
              </table>    
    </c:if>
              <br>
              
              <form action="edit.html" method="POST" id="edit_form">
			 		Centre ID :
			 				<input type="text" disabled="disabled" name="centreID" id="centreID"/><br/><br/><br/>
			 		Batch ID :
			 				<input type="text" disabled="disabled" name="batchID" id="batchID"/><br/><br/><br/>
			 		Sector Name :
			 				<input type="text" disabled="disabled" name="sectorName" id="sectorName"/><br/><br/><br/>
			 		Start Date :
			 				<input type="text" name="startDate" id="startDate"/><br/><br/><br/>
			 		End Date :
			 				<input type="text" name="endDate" id="endDate"/><br/><br/><br/>
			 		Test Date :
			 				<input type="text" name="testDate" id="testDate"/><br/><br/><br/>
			 		Test Conducted :
			 				<input type="text" name="testConducted" id="testConducted"/><br/><br/><br/>
			 		
 		  `				<input type="submit" value="Send" />
  						<span id="cls_f">X</span>
 			</form>
  
<script type="text/javascript">
	var edit_row = document.querySelectorAll('#t_id .edit_row');
	for(var i=0; i<edit_row.length; i++)
		{
	  		edit_row[i].addEventListener('click', function(e)
			{
			    // get parent row, add data from its cells in form fields
			    var tr_parent = this.parentNode;
			    document.getElementById('centreID').value = tr_parent.querySelector('.row_centreID').innerHTML;
			    document.getElementById('batchID').value = tr_parent.querySelector('.row_batchID').innerHTML;
			    document.getElementById('sectorName').value = tr_parent.querySelector('.row_sectorName').innerHTML;
			    document.getElementById('startDate').value = tr_parent.querySelector('.row_startDate').innerHTML;
			    document.getElementById('endDate').value = tr_parent.querySelector('.row_endDate').innerHTML;
			    document.getElementById('testDate').value = tr_parent.querySelector('.row_testDate').innerHTML;
			    document.getElementById('testConducted').value = tr_parent.querySelector('.row_testConducted').innerHTML;
			    // display the form, and focus on a form field
			    document.getElementById('edit_form').style.display = 'block';
			    document.getElementById('centreID').focus();
		     }, false);
		}

//to hide #edit_form when click on #cls_f button
	document.getElementById('cls_f').addEventListener('click', function()
		{
			this.parentNode.style.display = 'none';
		}, false);

</script>       
</body>
</html>