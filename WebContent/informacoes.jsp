<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8"> 
        <link rel="stylesheet" href="css/estilo.css">  

        
    </head>
    <body>
    	<img id="imagem" src="imagem/fundo.jpg">
        <div class="texto">Pontos Criticos -  Cadastramento </div>
    	 
    	<form id="test" class="baseForm" method="post" action="cadastro"> <!-- method="post"  action="cadastro" -->
            Nome Completo:
            <input class="formInput formTextInput" id="nome" type="text" name="nome">
            <label for="cpf">CPF:</label>
            <input class="formInput formTextInput" id="cpf" type="number" name="cpf">
            Endere�o:
            <input class="formInput formTextInput" id="endereco" type="text" name="endereco">
            Email:
            <input class="formInput formTextInput" id=email type="text" name="email">
            Nome de Usuario:
            <input class="formInput formTextInput" id=usuario type="text" name="usuario"> 
            Senha:
            <input class="formInput formTextInput" id=senha type="password" name="senha">
            Sexo:
            <input type="radio" name="op" value="Feminino"> Feminino
            <input type="radio" name="op" value="Masculino"> Masculino
            <br>
            
           	<button class="formInput submitButton" type="submit">Submit</button> <!-- //value="Cadastrar"> //onclick="showName(e)"    -->
           	<button class="btn btn-default" type="reset"> Limpar</button><a href="login"><button class="btn btn-default">Voltar</button></a>           
           	
        </form>
        
    </body>
	<script>
    	function showName(){
        	//armazenando os valores no em uma variavel para evitar ficar percorrendo no DOM, ajuda em performance
           	var form = document.getElementById("test");
           	var nome = document.getElementById("nomeCompleto").value;
           	var cpf = document.getElementById("cpf").value;
           	var endereco = document.getElementById("endereco").value;
           	var email = document.getElementById("email").value;
           	var nomeUsuario = document.getElementById("nomeUsuario").value;
           	var sexo = document.getElementById("test").elements["Sexo"].value;

           	var pessoa = {
           		nome : nome,
           		cpf : cpf,
           		endereco : endereco,
           		email : email,
           		nomeUsuario : nomeUsuario,
           		sexo : sexo
           	};

           	//Template string, do EcmaScript2016
           	form.innerHTML = `
           		<div>
           			<p><strong>Nome</strong> :  ${pessoa.nome} </p>
           			<p><strong>CPF</strong> :  ${pessoa.cpf} </p>
           			<p><strong>Endereço</strong> :  ${pessoa.endereco} </p>
           			<p><strong>Email</strong> :  ${pessoa.email} </p>
           			<p><strong>Nome de Usuário</strong> :  ${pessoa.nomeUsuario} </p>
           			<p><strong>Sexo</strong> :  ${pessoa.sexo} </p>
           		</div> 
           	`;
           		};
           	</script>
</html>
