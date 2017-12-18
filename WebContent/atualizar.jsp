<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<%-- <h1>ola ${user}</h1> --%>
  <!-- percorre contatos montando as linhas da tabela -->
  <tr>
  <td>Tipo</td>
  	<td>Endereco</td>
  	<td>Mensagem</td>
  	<td>Ação</td>
  </tr>
  <c:forEach var="contato" items="${lista}">
    <tr>
    <td>${contato.tipo}</td>
    <td>${contato.endereco}</td>
      <td>${contato.mensagem}</td>
      <td><a href="addponto?user=${user}&id=${contato.id}">Atualizar</a></td>
    </tr>
  </c:forEach>
</table>
<a href="ponte?user=${user}">Voltar</a>
</body>
</html>