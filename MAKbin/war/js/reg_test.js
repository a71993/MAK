function isempty(){
	
	var value1= document.getElementById("username").value;
	var value2= document.getElementById("e-mail1").value;
	var value3= document.getElementById("e-mail2").value;
	var value4= document.getElementById("password1").value;
	var value5= document.getElementById("password2").value;
	
	
	
	if(value1.length <6){
		alert("Kasutajanimi peab olema vähemalt 6 tähemärki")
	}
	else if(value4.length <6){
		alert("parool peab olema vähemalt 6 tähemärki")
	}
	else if(value1==""|| value2=="" || value3=="" || value4=="" || value5==""){
		alert("Palun täida tühjad väljad");
	}
	else if(value2!=value3){
		alert("e-mail1 ei sama mis e-mail2");
	}
	else if(value4!=value5){
		alert("parooli kontroll ei ole sama mis parool");
	}
	else if(value2.indexOf("@")== -1 && value2.indexOf(".")== -1){
		alert("Palun sisesta korrektne e-mail");
	}
	
	
	//kui kõik on korras 
	else if{
		alert("Kõik on korrektne!!");
	}
}