 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Data Upload</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="tablecss/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
       <!-- Theme style -->
    <link href="tablecss/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    
    #name{width: 30%;height: 25px;}
    #upload{width: 30%; height: 25px; border: 2px; color: white; background-color: #3c8dbc; font-family: sans-serif; border-color: black;}
		
	}
   
    </style>
</head>
  <body class="skin-blue sidebar-mini">
    		<H4><b>Excel Data Upload Form</b></H4>
              <div class="box">
                <div class="box-body">
        			
    	  			<form action="upload-master.html" method="post" enctype="multipart/form-data" >
				    <div><br/>
		    		    <label >Select Master Detail File</label><br/><br/>
						<input id="name" type="file" name="file" id="file"  required="required"><br/>
						<input type="submit" id="upload" value="Upload"><br/><br/>
					</div>
					</form>
	            </div>
              </div>
                  
           <div class="box">
                <div class="box-body">
        			
    	  			<form action="upload-partner.html" method="post" enctype="multipart/form-data" >
				    <div><br/>
		    		    <label >Select Partner Detail File</label><br/><br/>
						<input id="name"  type="file" name="file" id="file" required="required"><br/>
						<input id="upload" type="submit" value="Upload"><br/><br/>
					</div>
					</form>
	            </div>
              </div>
              
              <div class="box">
                <div class="box-body">
        			
    	  			<form action="partner-transfer.html" method="post" enctype="multipart/form-data" >
				    <div><br/>
		    		    <label >Select Partner Transfer Detail File</label><br/><br/>
						<input id="name"  type="file" name="file" id="file" required="required"><br/>
						<input id="upload" type="submit" value="Upload"><br/><br/>
					</div>
					</form>
	            </div>
              </div>
      </body>
</html>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 