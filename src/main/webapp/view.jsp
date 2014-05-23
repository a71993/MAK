<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html> 
<html> 
	<head> 
		<jsp:include page="_head.jsp"/>

	</head> 
	<body>
		
		<jsp:include page="_header.jsp"/>
		
		<div id="main"> 
			
			<h2 id="nameOfPaste">${name}</h2>
			
			<div id="view"> 
				<pre class="line-numbers" data-start="1"><code class="language-${syntax}">${text}</code></pre>
			
	       	</div>
	       	
   	        
	       	
	       	<div id="viewbuttons">
	       		<form method="post" action="/view">
	       		
	       			<input type="hidden" name="id" value="${id}"/> 
	       			<input type="hidden" name="name" value="${name}"/> 
	       			<input type="hidden" name="text" value="${text}"/> 
	       			<input type="hidden" name="syntax" value="${syntax}"/> 
	       			<input type="hidden" name="exposure" value="${exposure}"/> 
	       			<input id="editPaste" type="${isThisMyView != 'false' ? 'submit' : 'hidden'}" value="Edit" name="button"/>
	       			<input id="deletePaste" type="${isThisMyView != 'false' ? 'submit' : 'hidden'}" value="Delete" name="button"/>
	       		</form>
	       	</div>
		</div> 
		
		<jsp:include page="_footer.jsp"/>
	</body>
</html> 


