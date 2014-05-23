<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!doctype html> 
	<html> 
		<head> 
			<jsp:include page="_head.jsp"/>

		</head>
		
		<body> 
			<jsp:include page="_header.jsp"/>
			
			<div id="main"> 
			
	
				<table id="pastetable">
					<thead>
						<tr>
							<th>Name</th>
							<th>Posted</th>
							<th>Syntax</th>
							<th>Creator</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="pastes" items="${pastes}">
					<tr>
						<td><a href="/view?id=${pastes.urlId}"><c:out value="${pastes.name}"  /></a></td>
						<td><c:out value="${pastes.posted_time}"  /></td>
						<td><c:out value="${pastes.syntax}"  /></td>
						<td><c:out value="${pastes.creator}"  /></td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
	
			</div> 
			
			<jsp:include page="_footer.jsp"/>
		</body> 
	</html> 
	

