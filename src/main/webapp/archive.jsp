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
			
			<p id="total">Mul on kleepse kokku: <c:out value="${totalPastes}"  /></p>
		
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
						<td><a class="pastelink" id="${pastes.name}" href="/view?name=${pastes.urlName}"><c:out value="${pastes.name}"  /></a></td>
						<td><c:out value="${pastes.posted_time}"  /></td>
						<td class="syntax"><c:out value="${pastes.syntax}"  /></td>
						<td class="exposure"><c:out value="${pastes.exposure}"  /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

		</div> 
		
		<jsp:include page="_footer.jsp"/>
	</body> 
</html> 


