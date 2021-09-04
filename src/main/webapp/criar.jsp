<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.agenda.models.entity.ProcedimentoEntity" %>
<%@ page import="com.agenda.models.entity.ClienteEntity" %>
<%@ page import="java.util.ArrayList" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<ProcedimentoEntity> procedimentos = (ArrayList<ProcedimentoEntity>) request.getAttribute("procedimentos");
	@SuppressWarnings("unchecked")
	ArrayList<ClienteEntity> clientes = (ArrayList<ClienteEntity>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Agenda</title>
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<h1>Criar nova agenda</h1>
		<nav class="content buttonGroup">
			<a href="index.jsp" class="botao1">Home</a>
			<a href="listar" class="botao1">Agendas</a>
		</nav>
	</header>
	<main class="content">
		<form name="formAgenda" action="inserir">
			<div>
				<input type="text" name="id" placeholder="id" class="caixa2" readonly>
			</div>
			
			<div>
				<select name="idProcedimento" class="caixa1">
					<option value="">Selecione o procedimento</option>
					<% for (int i = 0; i < procedimentos.size(); i++) { %>
						<option value="<%= procedimentos.get(i).getId() %>"><%= procedimentos.get(i).getNome() %></option>
					<% } %>					
				</select>
			</div>
			<div>
				<select name="idCliente" class="caixa1">
					<option value="">Selecione o cliente</option>
					<% for (int i = 0; i < clientes.size(); i++) { %>
						<option value="<%= clientes.get(i).getId() %>"><%= clientes.get(i).getNome() %></option>
					<% } %>	
				</select>
			</div>
			<div>
				<input type="date" name="dataExecucao" placeholder="Data de execução" class="caixa1">
			</div>
			<input type="button" value="Adicionar" class="botao1" onclick="validar()">
		</form>
	</main>
	<script src="scripts/validador.js"></script>
</body>
</html>