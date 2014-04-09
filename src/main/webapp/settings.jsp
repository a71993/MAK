<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<!doctype html> 
	<html> 
		<head> 

			<jsp:include page="_head.jsp"/>

		</head>
		<body> 
			
			<jsp:include page="_header.jsp"/>
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


			<jsp:include page="_footer.jsp"/>

		</body> 
	</html> 
	

