   

<html>
    <head>
        <title>Pontos Criticos da Cidade - Facilitando o Dia-a-Dia</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="indicando os pontos criticos da cidade de sao jose dos campos"/>
        <meta name"keywords" content="problemas,ruas,acidentes,inchentes,congestionamento" />
        <meta name="author" content="Caroline Teixeira" />
        <link rel="stylesheet" type="text/css"  href="css/estilo.css"/>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script>
     $(document).ready(function() {
         $("#login").click(function() {
             servletCall();
         });

     });
     function servletCall() {
         $.post(
             "login", 
             {name : "Message from jsp"}, //meaasge you want to send
             function(result) {
             $('#somediv').html('Here is your result : <strong>' + result + '</strong>'); //message you want to show
         
             });
     };
     function logar() {
 		$.ajax({
             url: "login",
             type: "POST",
             data: {user: $("#usuario").val()},
             success: function(form){
                 $("#somediv").html(form);
             }
         });
   </script>
        
    </head>
    <body> 
                <img id="imagem" src="imagem/fundo.jpg"/>
                <div class="texto">Pontos Criticos </div>

    
        <form class="baseForm" method="post" action="login">
            Nome de Usuário:
            <input class="formInput formTextInput" id=usuario type="text" name="usuario"> 
            Senha:
            <input class="formInput formTextInput" id=senha type="password" name="senha">
            <input  class="formInput submit" type="submit" >
            <a  href="cadastro" id="cadastro">Cadastrar</a> 
            
        </form>
            <div id="somediv"></div>
    </body>
</html>
 