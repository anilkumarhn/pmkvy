 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <html>
 <head>
 
	<style>
	#rm{text-indent: 20Px; font-family: sans-serif; font-size: x-large; color: #3c8dbc; margin-bottom: -20px;}
	#menuhr{ height:1px; background-color: #3c8dbc; }
	#profile{ font-size: 14px;text-indent: 1150px; margin-bottom: -10px; color: #FF1493; font-weight: bold;}
	#un{color: #9932CC; font-size: 12px; }
	#signout{font-size: 14px; font-weight: bold; color:#FF1493; font-family: sans-serif; }
	</style>
	
 </head>
 <body>
 <br><br>
 <div><label id="rm">ROOMAN PMKVY</label></div><div id="profile"><b>user:</b>&nbsp;<a id="un" href="show-my-profile.html?userName=${USER_NAME}">${USER_NAME}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="signout" href="signout.html">Sign Out</a></div>         
 <hr id="menuhr">
 </body>
 </html>
  