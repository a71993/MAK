<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html> 
<html> 
	<head> 
		<title>MAKbin</title>
		<link type="text/CSS" rel="stylesheet" href="css/MAKbin.css" />
		<link type="text/CSS" rel="stylesheet" href="css/view.css" />
		<script src="http://connect.facebook.net/en_US/all.js"></script>
		<script type="text/javascript" src="js/FBlogin.js"> </script>
		<script src="js/prism.js"></script>
		<link href="css/prism.css" rel="stylesheet" />

	</head> 
	<body>
		<div id="fb-root"></div>
		<div id="header"> 
			<div id="login"> 
			
				<form id="logout" method="post" action="/logout">
					<input type="submit" id="logout" value="logout" />
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
			
			<h2 id="nameOfPaste">${name}</h2>
			
			<div id="view"> 
			<pre class="line-numbers" data-start="1"><code class="language-java">
			
				${text}
				</code>
	       	</pre>
	       	</div>
	       	
	       	<div id="viewbuttons">
	       		<form>
	       			<input id="editPaste" type="button" value="Edit" />
	       			<input id="deletePaste" type="button" value="Delete" />
	       			<input id="copyToClipoard" type="button" value="Copy to Clipboard" />
	       		</form>
	       	</div>
		</div> 
		<div id="footer"> 
			<p id="footer_info">2014 adkasjdlkasjdslkj</p> 
		</div> 
	</body>
</html> 


