<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<!doctype html> 
	<html> 
		<head> 
			<jsp:include page="_head.jsp"/>
			
		</head>
		
		<body> 
			<jsp:include page="_header.jsp"/>
			
			<div id="main">

		<form id="sign_up" class="form" method="post" action="/login">
                       
			<label for="username" >Username</label>
			<input id="username" name="username" type="text" /> <br />
		    
			    <label for="password" >Password</label>
			    <input id="password" name="password" type="text" /> <br />
			    <a id="forgot_password" href="/forgot.jsp">Forgot password?</a>
			    
				<a href= "http://graph.facebook.com/FACEBOOK_USER_ID/picture"></a>
			    <input id="log_in" type="submit" value="Log in"/> <br />
			    
			</form>
			<div id="fb-root"></div>
			
			</div> 

			<jsp:include page="_footer.jsp"/>
			
		</body>  
	</html> 
	

