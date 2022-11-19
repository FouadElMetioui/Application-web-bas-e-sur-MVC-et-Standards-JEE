<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="ma.fstt.entities.Commande"%>
<%@page import="ma.fstt.entities.Client"%>
<%@page import="ma.fstt.dao.ClientDAO"%>
<%@page import="java.util.List"%>
<%
List<Commande> commandes = (List<Commande>) request.getAttribute("commandes");
List<Client> clients = (List<Client>) request.getAttribute("clients");
%>
<%
Commande commande = (Commande) request.getAttribute("commande");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commande</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="ClientServlet"> Inventory </a></li>
			<li><a href="ClientServlet">Client</a></li>
			<li><a href="CommandeServlet">Commande</a></li>
			<li><a href="ProduitServlet">Produit</a></li>
			<li><a href="LigneCommandeServlet">Ligne Commande</a></li>
			<li><a href="#">About</a></li>
		</ul>
	</div>
	<!-- /#sidebar-wrapper -->

	<!-- Page Content -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#"> Gestion du stock </a>
	</nav>
	<div id="page-content-wrapper">
		<div class="container-fluid">

			<div class="row">
				<div class="col-lg-2 mt-4"></div>
				<c:if test="${empty commande}">
					<div class="col-4 mt-4">
						<form method="post" action="CommandeServlet" class="card">
							<div class="form-group">
								<label for="nom">Date de Commande</label> <input type="date"
									name="dateCmd" class="form-control" id="nom"
									placeholder="Entrer la date du Commande">
							</div>
							<div class="form-group">
								<label for="prenom">Choisir le Client</label> <select
									class="form-select" aria-label="Default select example"
									name="Clientlist">
									<c:forEach items="${clients}" var="client">
										<option value="${client.getCodeCli()}">${client.getNomCli()}</option>
									</c:forEach>
								</select>
							</div>

							<input type="submit" class="btn btn-primary mb-2 mt-3"
								value="Ajouter">
						</form>
					</div>
				</c:if>
				<c:if test="${not empty commande}">
					<div class="col-4 mt-4">
						<form method="post" action="UpdateCommandeServlet" class="card">
							<div class="form-group">
								<label for="nom">Date du Commande</label> <input type="date"
									name="dateCmd" class="form-control" id="nom"
									placeholder="Entrer la date du commande"
									value="${commande.getDateCmd()}">
							</div>
							<div class="form-group">
								<label for="prenom">Choisir le Client</label> <select
									class="form-select" aria-label="Default select example"
									name="Clientlist">
									<c:forEach items="${clients}" var="client">
										<c:if test="${client.codeCli == commande.codeCli}">
											<option value="${client.getCodeCli()}" selected>${client.getNomCli()}</option>
										</c:if>
										<c:if test="${client.codeCli != commande.codeCli}">
											<option value="${client.getCodeCli()}">${client.getNomCli()}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<input type="hidden" id="id" name="numCmd"
								value="${ commande.getNumCmd()}"> <input type="submit"
								class="btn btn-warning mb-2 mt-3" value="Update">
						</form>
					</div>
				</c:if>

				<div class="col-6 mt-4">
					<table class="table" class="card">
						<thead class="card-header">
							<tr>
								<th scope="col">Date de Commande</th>
								<th scope="col">Nom du Client</th>
								<th scope="col">action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${commandes}" var="commande">
								<tr>
									<td>${commande.getDateCmd()}</td>

									<c:forEach items="${clients}" var="client">
										<c:if test="${client.codeCli == commande.codeCli}">
											<td>${client.getNomCli()}</td>
										</c:if>
									</c:forEach>

									<td><a
										href="DeleteCommandeServlet?numCmd=${commande.getNumCmd()}"
										class="btn btn-danger">Delete</a><a
										href="UpdateCommandeServlet?numCmd=${commande.getNumCmd()}"
										class="btn btn-warning">update</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->


</body>
</html>