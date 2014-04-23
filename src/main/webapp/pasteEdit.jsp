<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html> 
	<html> 
		<head> 
			<jsp:include page="_head.jsp"/>

		</head>
		
		<body> 
			
			<jsp:include page="_header.jsp"/>
			
			<div id="main">
                <form id="my_settings" method="post" action="/pasteedit">
                    
                    
                <p id="Paste"> Paste </p>
                
                <div id="nimi">
			        <input id="text" type="text" name="name" value="${name}" />
                    </div>
                <input id="syntaxnupud" type="button" value="Nupud">
                    
                
                    <div id="tekst">
                    <textarea id="tekstibox" name="paste" rows="30" cols="90">${text}</textarea>
                    </div>
                
                
               <p id="Preview2"> Preview</p>
                 <div id="preview"> 
                     <p id="tekst2"></p>
                     
		        </div> 
                <div id="syntaxnupud2">  
                    
                    <div id="syntax2">
                        <label for="Syntax" >Syntax:</label>
                        <select id="Syntax" name="syntax">
                          <option value="HTML" ${syntax == 'HTML' ? 'selected' : ''}>HTML</option>
                          <option value="C++" ${syntax == 'C++' ? 'selected' : ''}>C++</option>
                          <option value="Python" ${syntax == 'Python' ? 'selected' : ''}>Python</option>
                          <option value="Java" ${syntax == 'Java' ? 'selected' : ''}>Java</option>
                    </select>
                    </div>
                    
                    <div id="syntax1">
                        <label for="Exposure" >Exposure:</label>
                        <select id="Exposure" name="exposure">
                          <option value="Public" ${exposure == 'Public' ? 'selected' : ''}>Public</option>
                          <option value="Private" ${exposure == 'Private' ? 'selected' : ''}>Private</option>
                        </select> 
                    </div>
                </div>
                <div id="submit2">
                   
				 	<input id="submitbutton" type="submit" value="Submit" /> 
				</div> 
                
                </form>	
			</div> 
			
			<jsp:include page="_footer.jsp"/>
		</body>
	</html> 
	

