<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="ma.fstt.entities.Client"%>
<%@page import="java.util.List"%>
<%
List<Client> clients = (List<Client>) request.getAttribute("clients");
%>
<%
Client client = (Client) request.getAttribute("client");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
			<li class="sidebar-brand"><a href="ClientServlet"> Inventory
			</a></li>
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
				<c:if test="${empty client}">
					<div class="col-lg-4 mt-4">
						<form method="post" action="ClientServlet" class="card">
							<div class="form-group">
								<label for="nom">Nom Client</label> <input type="text"
									name="nomCli" class="form-control" id="nom"
									placeholder="Entrer le nom du client">
							</div>
							<div class="form-group">
								<label for="prenom">Prenom Client</label> <input type="text"
									name="preCli" class="form-control" id="prenom"
									placeholder="Entrer le prenom du client">
							</div>
							<div class="form-group">
								<label for="adress">adress Client</label> <input type="text"
									name="adrCli" class="form-control" id="adress"
									placeholder="Entrer l'adress du client">
							</div>
							<div class="form-group">
								<label for="tel">Telephone Client</label> <input type="text"
									name="telCli" class="form-control" id="tel"
									placeholder="Entrer le telephone du client">
							</div>
							<div class="form-group">
								<label for="ville">Ville Client</label> <input type="text"
									name="villeCli" class="form-control" id="ville"
									placeholder="Entrer la ville du client">
							</div>
							<input type="submit" class="btn btn-primary mb-2 mt-3"
								value="Ajouter">
						</form>
					</div>
				</c:if>
				<c:if test="${not empty client}">
					<div class="col-lg-4 mt-4">
						<form method="post" action="UpdateClientServlet" class="card">
							<div class="form-group">
								<label for="nom">Nom Client</label> <input type="text"
									name="nomCli" class="form-control" id="nom"
									placeholder="Entrer le nom du client"
									value="${ client.getNomCli()}">
							</div>
							<div class="form-group">
								<label for="prenom">Prenom Client</label> <input type="text"
									name="preCli" class="form-control" id="prenom"
									placeholder="Entrer le prenom du client"
									value="${ client.getPreCli()}">
							</div>
							<div class="form-group">
								<label for="adress">adress Client</label> <input type="text"
									name="adrCli" class="form-control" id="adress"
									placeholder="Entrer l'adress du client"
									value="${ client.getAdrCli()}">
							</div>
							<div class="form-group">
								<label for="tel">Telephone Client</label> <input type="text"
									name="telCli" class="form-control" id="tel"
									placeholder="Entrer le telephone du client"
									value="${ client.getTelCli()}">
							</div>
							<div class="form-group">
								<label for="ville">Ville Client</label> <input type="text"
									name="villeCli" class="form-control" id="ville"
									placeholder="Entrer la ville du client"
									value="${ client.getVilleCli()}">
							</div>
							<input type="hidden" id="id" name="codeCli"
								value="${ client.getCodeCli()}"> <input type="submit"
								class="btn btn-warning mb-2 mt-3" value="Update">
						</form>
					</div>
				</c:if>

				<div class="col-lg-6 mt-4">
					<table class="table" class="card">
						<thead class="card-header">
							<tr>
								<th scope="col">Nom</th>
								<th scope="col">Prenom</th>
								<th scope="col">adress</th>
								<th scope="col">Telephone</th>
								<th scope="col">Ville</th>
								<th scope="col">action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${clients}" var="client">
								<tr>
									<td>${client.getNomCli()}</td>
									<td>${client.getPreCli()}</td>
									<td>${client.getAdrCli()}</td>
									<td>${client.getTelCli() }</td>
									<td>${client.getVilleCli()}</td>
									<td><a
										href="DeleteClientServlet?codeCli=${client.getCodeCli()}"
										class="btn btn-danger">Delete</a><a
										href="UpdateClientServlet?codeCli=${client.getCodeCli()}"
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