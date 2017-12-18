<!DOCTYPE html>
<head>
<title>Adicionar</title>

        <meta charset="UTF-8"> 
        <link rel="stylesheet" type="text/css"  href="css/estilo.css"/>  

</head>

<body>
    <img id="imagem" src="imagem/fundo.jpg"/>
    <div class="texto">Pontos Criticos - Ajude e Adicione </div>


    <form class="add" method="post" action="addponto">
            <label > Endereco:</label>
            <input class="formInput formTextInput" placeholder="${id}" id=id  type="hidden" name="id"  value="${id}" >
            
            <input class="formInput formTextInput" placeholder="${user}" id=nome  type="hidden" name="nome"  value="${user}" >
            <input class="formInput formTextInput" placeholder="Digite o Endereco " id=endereco type="text" name="endereco" value="${endereco}">
            <label> Tipo:</label>
            <input type="radio" name="op" value="Inchentes"> Inchentes
            <input type="radio" name="op" value="Assaltos"> Assaltos
            <input type="radio" name="op" value="Acidentes"> Acidentes
            <label> Mensagem:</label>
            <textarea class="msg" placeholder="Descreva o ocorrido" name="mensagem">${mensagem}</textarea>
            <input type="file"  name="foto">
            
            <input class="btn btn-confirm block" type="submit" value="Enviar">
            <a href="ponte?user=${user}">Voltar</a>  
            
    </form>
</body>
</html>