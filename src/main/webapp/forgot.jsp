<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<!doctype html> 
	<html> 
		<head> 
			<jsp:include page="_head.jsp"/>

		</head>
		
		<body> 
			
			<jsp:include page="_header.jsp"/>
			
			<div id="main"> 
			
				<div class="form">
					<form id="forgot_passwd" method="post">
					
							<label for="username" >Username</label>
							<input id="username" type="text" /> <br />

							<label for="e-mail" >E-mail</label>
							<input id="e-mail" type="text" /> <br />
						
							<input id="send_passwd" type="button" value="Send new password" />
						
					</form>
				</div> <!-- .form end -->
			</div> <!-- #main end -->
			
			<jsp:include page="_footer.jsp"/>
		</body> 
	</html> 
	

