function displayit(){
	var userInput = document.getElementById("tekstibox").value.replace(/\n/g,'<br>');
	document.getElementById("tekst2").innerHTML=userInput;
}

$(document).ready(function(){
	
	//replace tab character to spaces
	$(document.body).delegate('#editor','keydown', function(e) {
		var $this = $(this);
		var keyCode = e.keyCode || e.which;
		
		if (keyCode === 9) {
			e.preventDefault();
			var start = $this.get(0).selectionStart;
			var end = $this.get(0).selectionEnd;

			// set textarea value to: text before caret + tab + text after caret
			$(this).val($this.val().substring(0, start)
				+ "\t"
				+ $this.val().substring(end));

			// put caret at right position again
			$this.get(0).selectionStart =
			$this.get(0).selectionEnd = start + 1;
		}
	});
	
	//update preview pane contents
	$('#editor').on('keyup', function(e) {
		$('#preview-contents').text($('#editor').val());
		
		if (Prism) {
			Prism.highlightAll();
		}
	});
	
	//update syntax code name
	$('#syntax').on('change', function() {
		var newVal = $(this).val();

		$('#preview-contents').removeClass().addClass('language-' + newVal);
		
		
		if (Prism) {
			Prism.highlightAll();
		}
	});
});