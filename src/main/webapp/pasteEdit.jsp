<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html> 
	<html> 
		<head> 
			<jsp:include page="_head.jsp"/>

		</head>
		
		<body> 
			
			<jsp:include page="_header.jsp"/>
			
			<div id="main" class="container">
				<h2>Paste</h2>
				
                <form id="my_settings" method="post" action="/paste">
                
					<p class="form-row">
						<label>
							Nimi:
							<input id="text" type="text" name="name" value="${name}"/>
						</label>
					</p>
					
					<p class="form-row">
						<textarea id="editor" class="editor" name="paste">${text}</textarea>
					</p>
					
					<p class="form-row">
						<label class="label-inline">
							syntax:
							<select id="syntax" name="syntax">
								<option value="markup" ${syntax == 'markup' ? 'selected' : ''}>HTML</option>
								<option value="cpp" ${syntax == 'cpp' ? 'selected' : ''}>C++</option>
								<option value="python" ${syntax == 'python' ? 'selected' : ''}>Python</option>
								<option value="java" ${syntax == 'java' ? 'selected' : ''}>Java</option>
								<option value="c" ${syntax == 'c' ? 'selected' : ''}>C</option>
								<option value="javascript" ${syntax == 'javascript' ? 'selected' : ''}>JavaScript</option>
								<option value="http" ${syntax == 'http' ? 'selected' : ''}>Http</option>
								<option value="sql" ${syntax == 'sql' ? 'selected' : ''}>SQL</option>
								<option value="csharp" ${syntax == 'csharp' ? 'selected' : ''}>C#</option>
								<option value="php" ${syntax == 'php' ? 'selected' : ''}>PHP</option>
								<option value="ruby" ${syntax == 'ruby' ? 'selected' : ''}>Ruby</option>
							</select>
						</label>
						
						<label class="label-inline">
							Exposure:
							<select id="Exposure" name="exposure">
								<option value="Public" ${exposure == 'Public' ? 'selected' : ''}>Public</option>
								<option value="Private" ${exposure == 'Private' ? 'selected' : ''}>Private</option>
							</select> 
						</label>
						
						<label class="label-inline pull-pight">
							<input id="submitbutton" type="submit" value="Submit" />
						</label>
					</p>
                
                </form>	
                
				<div id="preview-wrap"> 
					<pre class="line-numbers" data-start="1"><code id="preview-contents" class="language-markup"></code></pre>
				</div>
			</div> 
			
			<jsp:include page="_footer.jsp"/>
		</body>
	</html> 
	

