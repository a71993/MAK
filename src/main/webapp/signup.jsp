<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<!doctype html> 
	<html> 
		<head> 

			<jsp:include page="_head.jsp"/>

		</head>
		 
		<body>
			<jsp:include page="_header.jsp"/>
			
			<div id="main"> 
			
				<div class="form">
					<form id="forgot_passwd" name="forgot_passwd" method="post" action="/signup">
					
							<label for="username" >Username</label>
							<input id="username" name="username" type="text" /> <br />

							<label for="email1" >E-mail</label>
							<input id="email1" name="email1" type="text" /> <br />
							
							<label for="email2" >Confirm e-mail</label>
							<input id="email2" name="email2" type="text" /> <br />
							
							<label for="password1" >Password</label>
							<input id="password1" name="password1" type="password" /> <br />
							
							<label for="password2" >Confirm password</label>
							<input id="password2" name="password2" type="password" /> <br />
						
							<input id="submitbutton" type="button" value="Submit" onclick="isempty();"/>
						
					</form>
				</div> <!-- .form end -->
			</div> <!-- #main end -->
			
			<jsp:include page="_footer.jsp"/>
		</body> 
	</html> 
	

