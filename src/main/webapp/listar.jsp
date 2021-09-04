<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.agenda.models.entity.AgendaEntity" %>
<%@ page import="java.util.ArrayList" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<AgendaEntity> agendas = (ArrayList<AgendaEntity>) request.getAttribute("agendas");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agendas</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>	
	<header>
		<h1>Agendas</h1>
		<nav class="content buttonGroup">
			<a href="index.jsp" class="botao1">Home</a>
			<a href="criar" class="botao1">Nova agenda</a>
			<a href="report" class="botao2">Relatório</a>
		</nav>
	</header>
	
	<main class="content">
		<table id="tabela">
			<thead>
				<tr>
					<th>ID</th>
					<th>Procedimento</th>
					<th>Cliente</th>
					<th>Data de execução</th>	
					<th>Opções</th>	
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < agendas.size(); i++) { %>
					<tr>
						<td><%= agendas.get(i).getId() %></td>
						<td><%= agendas.get(i).getProcedimento().getNome() %></td>
						<td><%= agendas.get(i).getCliente().getNome() %></td>
						<td><%= agendas.get(i).getDataExecucao() %></td>
						<td>
							<a href="select?idcon=<%= agendas.get(i).getId() %>" class="botao1">Editar</a>
							<a href="javascript: confirmar(<%= agendas.get(i).getId() %>)" class="botao2">Excluir</a>					
						</td>
					</tr>
				<% } %>
			</tbody>
		</table>
	</main>
	<script src="scripts/confirmador.js"></script>
</body>
</html>