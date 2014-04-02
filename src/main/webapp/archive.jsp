<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html> 
<html> 
	<head> 
		<title>MAKbin</title>
		<meta charset="utf-8"/>
		<link type="text/CSS" rel="stylesheet" href="css/MAKbin.css" />
		<link type="text/CSS" rel="stylesheet" href="css/table.css" />
		<script src="http://connect.facebook.net/en_US/all.js"></script>
		<script type="text/javascript" src="js/FBlogin.js"> </script>

	</head>
	 
	<body>
		<div id="fb-root"></div>
		<div id="header"> 
			<div id="login"> 
				<a href="signup.html">signup</a> 
		
				<a href="login.html">login</a>
				<div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="true"></div>
				
		
			</div> 
			<span id="logo">MAKbin</span> 
	
			<div class="menu"> 
				<a href="paste.html">Create paste</a> 
			
				<a href="/mypastes">Archive</a> 
			
				<a href="settings.html">My settings</a> 

			</div> 
		</div>
		<div id="main"> 
		
			<a href="/mypastes">My Archive</a> 
			
			<a href="admin_archive.jsp">Others</a> 
			
			<p>Mul on kleepse kokku: <c:out value="${totalPastes}"  /></p>
		
			<table id="pastetable">
				<thead>
					<tr>
						<th>Name</th>
						<th>Posted</th>
						<th>Syntax</th>
						<th>Exposure</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pastes" items="${pastes}">
					<tr>
						<td><a href="/view?name=${pastes.name}"><c:out value="${pastes.name}"  /></a></td>
						<td><c:out value="${pastes.posted_time}"  /></td>
						<td><c:out value="${pastes.syntax}"  /></td>
						<td><c:out value="${pastes.exposure}"  /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

		</div> 
		<div id="footer"> 
			<p id="footer_info">2014 adkasjdlkasjdslkj</p> 
		</div> 
	</body> 
</html> 


