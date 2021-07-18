function copyToClipboard(){
    
    var resultInput = window.document.getElementById("result");

    resultInput.select();
	
    window.document.execCommand("copy");
    window.document.getElementById("copyField").innerText = 'Copiado!';
    window.document.getElementById("copyField").style.backgroundColor = "#428347";
    window.document.getElementById("copyField").style.color = "#fff";
}