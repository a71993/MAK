	<!doctype html> 
	<html> 
		<head> 
			<jsp:include page="_head.jsp"/>

		</head>
		
		<body> 
			<jsp:include page="_header.jsp"/>
			
			<div id="main"> 
			
				<a href="/mypastes">My Archive</a> 
				
				<a href="/mypastes">Others</a> 
			
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
						<tr>
							<td>untitled</td>
							<td>21 seconds ago</td>
							<td>HTML</td>
							<td>Public</td>
						</tr>
					</tbody>
				</table>
	
			</div> 
			
			<jsp:include page="_footer.jsp"/>
		</body> 
	</html> 
	

