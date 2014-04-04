function displayit(){
	var userInput = document.getElementById("tekstibox").value.replace(/\n/g,'<br>');
	document.getElementById("tekst2").innerHTML=userInput;
}