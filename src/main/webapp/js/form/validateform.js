function validateFirstName(firstName, div_Name)
	{	
		var Name_Format = /^[a-zA-Z_. ]+$/;
		var divTagId = document.getElementById(div_Name);
		divTagId.innerHTML ='';
		divTagId.style.color = "red";
		if(firstName == "")
	    {

		    divTagId.innerHTML = "first name cannot be empty";
		    return false;
	    }
		else if(!firstName.match(Name_Format))
		{
			divTagId.innerHTML = "invalid name format";
		    return false;
		}	
		else if(firstName.length <3)
		{
			divTagId.innerHTML = "first name atleast 3 characters";
		    return false;
		}
		else if(firstName.length >25)
		{
			divTagId.innerHTML = "first name max 25 characters only";
		    return false;
		}
		divTagId.style.color="green";
		divTagId.innerHTML = "\u2714";
		return false;
}
	

function validateLastName(lastName, div_Name)
{	
	var Name_Format = /^[a-zA-Z_. ]+$/;
	var divTagId = document.getElementById(div_Name);
	divTagId.innerHTML ='';
	divTagId.style.color = "red";
	if(lastName == "")
    {

	    divTagId.innerHTML = "last name cannot be empty";
	    return false;
    }
	else if(!lastName.match(Name_Format))
	{
		divTagId.innerHTML = "invalid name format";
	    return false;
	}	
	else if(lastName.length <3)
	{
		divTagId.innerHTML = "last name atleast 3 characters";
	    return false;
	}
	else if(lastName.length >25)
	{
		divTagId.innerHTML = "last name max 25 characters only";
	    return false;
	}
	divTagId.style.color="green";
	divTagId.innerHTML = "\u2714";
	return false;
}

function validatePassword(pwd, div_Name)
{	
	var divTagId = document.getElementById(div_Name);
	divTagId.innerHTML ='';
	divTagId.style.color = "red";
	if(pwd == "")
    {

	    divTagId.innerHTML = "password cannot be empty";
	    return false;
    }
	else if(pwd.length <6)
	{
		divTagId.innerHTML = "password atleast 6 characters";
	    return false;
	}
	else if(pwd.length >12)
	{
		divTagId.innerHTML = "password max 12 characters only";
	    return false;
	}
	divTagId.style.color="green";
	divTagId.innerHTML = "\u2714";
	return false;
}

function validateSelector(div_Name)
{	
	var divTagId = document.getElementById(div_Name);
	divTagId.innerHTML ='';
	divTagId.style.color = "red";
	var q = document.getElementById("roles");
	var selected = q.options[q.selectedIndex].value;
	if(selected == 0)
    {
	    divTagId.innerHTML = "role not selected";
	    return false;
    }
	divTagId.style.color="green";
	divTagId.innerHTML = "\u2714";
	return false;
}

function validateSelUser(div_Name)
{	
	var divTagId = document.getElementById(div_Name);
	divTagId.innerHTML ='';
	divTagId.style.color = "red";
	var q = document.getElementById("role");
	var selected = q.options[q.selectedIndex].value;
	if(selected == 0)
    {
	    divTagId.innerHTML = "role not selected";
	    return false;
    }
	divTagId.style.color="green";
	divTagId.innerHTML = "\u2714";
	return false;
}

 function validateEmail(email, div_Name)
{	
	var Name_Format = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
	var divTagId = document.getElementById(div_Name);
	divTagId.innerHTML ='';
	divTagId.style.color = "red";
	if(email == "")
    {

	    divTagId.innerHTML = "email cannot be empty";
	    return false;
    }
	else if(!email.match(Name_Format))
	{
		divTagId.innerHTML = "invalid email address";
	    return false;
	}	
	divTagId.style.color="green";
	divTagId.innerHTML = "\u2714";
	return false;
}
 
 
 
function validateCurPwd(curpwd, div_Name, password)  
 {
	 	var divTagId = document.getElementById(div_Name);
		divTagId.innerHTML ='';
		divTagId.style.color = "red";
		if(curpwd == "" || curpwd != password)
	    {
		    divTagId.innerHTML = "it seems wrong password";
		    return false;
	    }
		divTagId.style.color="green";
		divTagId.innerHTML = "\u2714";
		
		document.getElementById("acceptpwd").style.display="none";
		document.getElementById("updateprofile").style.display="block";
		return false;
 }



validatePartnerName(partnerName, div_Name)
{
	var Name_Format = /^[a-zA-Z_. ]+$/;
	var divTagId = document.getElementById(div_Name);
	divTagId.innerHTML ='';
	divTagId.style.color = "red";
	if(partnerName == "")
    {

	    divTagId.innerHTML = "partner name cannot be empty";
	    return false;
    }
	else if(!partnerName.match(Name_Format))
	{
		divTagId.innerHTML = "invalid name format";
	    return false;
	}	
	divTagId.style.color="green";
	divTagId.innerHTML = "\u2714";
	return false;
}














function validatePartner()
{
	var a=document.forms["update-partner"]["partnerName"].value;
	var b=document.forms["update-partner"]["address"].value;
	var c=document.forms["update-partner"]["contactNumber"].value;
	var d=document.forms["update-partner"]["contactPerson"].value;
	var e=document.forms["update-partner"]["panNumber"].value;
	var f=document.forms["update-partner"]["mouSigned"].value;
	var g=document.forms["update-partner"]["tds"].value;
	var h=document.forms["update-partner"]["partnerShare"].value;
	var i=document.forms["update-partner"]["emailID"].value;
	
	if (a == null || a == "" || b == null || b == "" || c == null || c == "" || d == null || d == "" || e == null || e == ""
		|| f == null || f == "" || g == null || g == "" || h == null || h == ""	|| i == null || i == "")
	{
		alert("Please fill all the inputs");
		return false;
	}
}

