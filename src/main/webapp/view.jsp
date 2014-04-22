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
			<pre class="line-numbers" data-start="1"><code class="language-java">
			
				${text}
				</code>
	       	</pre>
	       	</div>
	       	
	       	<div id="viewbuttons">
	       		<form>
	       			<input id="editPaste" type="submit" value="Edit" />
	       			<input id="deletePaste" type="submit" value="Delete" />
	       			<input id="copyToClipoard" type="button" value="Copy to Clipboard" />
	       		</form>
	       	</div>
		</div> 
		
		<jsp:include page="_footer.jsp"/>
	</body>
</html> 


