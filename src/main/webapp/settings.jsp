<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<!doctype html> 
	<html> 
		<head> 
			<title>MAKbin</title>
			<meta charset="utf-8"/>
			<link type="text/CSS" rel="stylesheet" href="css/MAKbin.css" />
			<link type="text/CSS" rel="stylesheet" href="css/form.css" />
			<link type="text/CSS" rel="stylesheet" href="css/settings.css" />
			<script src="http://connect.facebook.net/en_US/all.js"></script>
			<script type="text/javascript" src="js/FBlogin.js"> </script>

		</head>
		<body> 
			<div id="fb-root"></div>
			<div id="header"> 
				<div id="login"> 
				
					<form id="logout" method="post" action="/logout">
						<input type="submit" id="logoutbutton" value="logout" />
					</form>
					
					<a href="signup.html">signup</a> 
			
					<a href="login.html">login</a>
					<div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="true"></div>
					
			
				</div> 
				<span id="logo">MAKbin</span> 
		
				<div class="menu"> 
					<a href="paste.html">Create paste</a> 
				
					<a href="/mypastes">Archive</a> 
				
					<a href="settings.jsp">My settings</a> 
	
				</div> 
			</div>
			
			<div id="main">

		<form id="my_settings" class="form" method="post">

			<label for="old_username" >Old password:</label>
			<input id="old_username" type="text" /><br />

			    <label for="new_password" >New password:</label>
			    <input id="new_password" type="text" /><br />

			    <label for="new_password_again" >New password confirm:</label>
			    <input id="new_password_again" type="text" /><br />

			    <input id="submit" type="button" value="Submit"><br />


	
			</form>
			</div> 



			<div id="footer"> 
				<p id="footer_info">2014 adkasjdlkasjdslkj</p> 
			</div> 
		</body> 
	</html> 
	

