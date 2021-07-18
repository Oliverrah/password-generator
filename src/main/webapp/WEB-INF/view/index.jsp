<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-br">

	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Password Generator</title>
	
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	    <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Zen+Loop&display=swap" rel="stylesheet">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/images/icon.png">		

	    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</head>
	
	<body>  
	    <div class="container">

		
				<h1 class="container-title">
					<span class="container-title-first">Password</span>
					<span class="container-title-second">Generator</span>
				</h1>
						
	    						
	        <h3 class="container-subtitle">Bem vindo ao gerador de senhas, você pode escolher a quantidade de caracteres e quais caracteres serão utilizados.</h3> 

	        <div class="container-inside">
	            <form:form action="processForm" method="POST" modelAttribute="password" class="container-inside-form" accept-charset="utf-8">
	
	                <div class="container-inside-element">
	                    <label for="number" class="container-inside-element-text">Quantidade de caracteres da senha:</label>
	                    <form:input required="required" type="number" path="passwordLenght" min="4" max="100" class="container-inside-element-input-number" />
	                    <form:errors path="passwordLenght" class="error-field" />
	                </div>
	
	                <div class="container-inside-element">
	                    <label for="upperCase" class="container-inside-element-text">Deseja incluir letras maiúsculas?</label>
	                    <form:checkbox path="uppercaseLetters" class="container-inside-element-checkbox"/>
	                </div>
	
	                <div class="container-inside-element">
	                    <label for="upperCase" class="container-inside-element-text">Deseja incluir letras minúsculas?</label>
	                    <form:checkbox path="lowercaseLetters" class="container-inside-element-checkbox" />
	                </div>
	
	                <div class="container-inside-element">
	                    <label for="upperCase" class="container-inside-element-text">Deseja incluir números?</label>
	                    <form:checkbox path="numbers" class="container-inside-element-checkbox"/>
	                </div>
	
	                <div class="container-inside-element">
	                    <label for="upperCase" class="container-inside-element-text">Deseja incluir caracteres especiais?</label>
	                    <form:checkbox path="specialCharacters" class="container-inside-element-checkbox" />
	                 </div>
	
	                 <div class="container-inside-element line">
	                    <input type="submit" value="Gerar Senha" class="btn container-inside-element-submit">
	                 </div>
	                
					
					<div class="container-inside-element-result-container">					
						<form:input type="text" path="result" class="container-inside-element-result-input" id="result" />									
						<a href="#" class="btn container-inside-element-result-button" id="copyField" onclick="copyToClipboard()">Copiar</a>
					</div>				             
	           </form:form>	           
	        </div>
	    </div>
	</body>
</html>