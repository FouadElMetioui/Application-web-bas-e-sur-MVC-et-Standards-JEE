<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="ma.fstt.entities.Commande"%>
<%@page import="ma.fstt.entities.Produit"%>
<%@page import="ma.fstt.entities.LigneCommande"%>
<%@page import="ma.fstt.entities.Client"%>
<%@page import="ma.fstt.dao.ClientDAO"%>
<%@page import="java.util.List"%>
<%
List<Commande> commandes = (List<Commande>) request.getAttribute("commandes");
List<Client> clients = (List<Client>) request.getAttribute("clients");
List<Produit> produits = (List<Produit>) request.getAttribute("produits");
List<LigneCommande> ligneCommandes = (List<LigneCommande>) request.getAttribute("ligneCommandes");
%>
<%
LigneCommande ligneCommande = (LigneCommande) request.getAttribute("ligneCommande");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ligneCommande</title>
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
		<a class="navbar-brand" href="ClientServlet"> Gestion du stock </a>
	</nav>
	<div id="page-content-wrapper">
		<div class="container-fluid">

			<div class="row">
				<div class="col-lg-2 mt-4"></div>
				<c:if test="${empty ligneCommande}">
					<div class="col-4 mt-4">
						<form method="post" action="LigneCommandeServlet" class="card">
							<div class="form-group">
								<label for="nom">Choisir le Produit</label> <select
									class="form-select" aria-label="Default select example"
									name="Produitlist">
									<c:forEach items="${produits}" var="produit">
										<option value="${produit.getCodePr()}">${produit.getNomPr()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="nom">Choisir la Commande</label> <select
									class="form-select" aria-label="Default select example"
									name="Commandelist">
									<c:forEach items="${commandes}" var="commande">
										<option value="${commande.getNumCmd()}">${commande.getNumCmd()}</option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group">
								<label for="nom">Quantite du Produit</label> <input
									type="number" name="qteCmd" class="form-control" id="nom"
									placeholder="Entrer la quantite du Commande">
							</div>
							<input type="submit" class="btn btn-primary mb-2 mt-3"
								value="Ajouter">
						</form>
					</div>
				</c:if>
				<c:if test="${not empty ligneCommande}">
					<div class="col-4 mt-4">
						<form method="post" action="UpdateLigneCommandeServlet"
							class="card">

							<div class="form-group">
								<label for="prenom">Choisir le Produit</label> <select
									class="form-select" aria-label="Default select example"
									name="Produitlist">
									<c:forEach items="${produits}" var="produit">
										<c:if test="${produit.codePr == ligneCommande.codePr}">
											<option value="${produit.getCodePr()}" selected>${produit.getNomPr()}</option>
										</c:if>
										<c:if test="${produit.codePr != ligneCommande.codePr}">
											<option value="${produit.getCodePr()}">${produit.getNomPr()}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="prenom">Choisir la Commande</label> <select
									class="form-select" aria-label="Default select example"
									name="Commandelist">
									<c:forEach items="${commandes}" var="commande">
										<c:if test="${commande.numCmd == ligneCommande.numCmd}">
											<option value="${commande.getNumCmd()}" selected>${commande.getNumCmd()}</option>
										</c:if>
										<c:if test="${commande.numCmd != ligneCommande.numCmd}">
											<option value="${commande.getNumCmd()}">${commande.getNumCmd()}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>

							<div class="form-group">
								<label for="nom">Quantite du Produit</label> <input
									type="number" name="qteCmd" class="form-control" id="nom"
									placeholder="Entrer la quantite du commande"
									value="${ligneCommande.getQteCmd()}">
							</div>

							<input type="hidden" id="id" name="numLigne"
								value="${ ligneCommande.getNumLigne()}"> <input
								type="submit" class="btn btn-warning mb-2 mt-3" value="Update">
						</form>
					</div>
				</c:if>

				<div class="col-6 mt-4">
					<table class="table" class="card">
						<thead class="card-header">
							<tr>
								<th scope="col"> Nom Produit</th>
								<th scope="col">Numero Commande</th>
								<th scope="col">Quantite Commande</th>
								<th scope="col">action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ligneCommandes}" var="ligneCommande">
								<tr>


									<c:forEach items="${produits}" var="produit">
										<c:if test="${produit.codePr == ligneCommande.codePr}">
											<td>${produit.getNomPr()}</td>
										</c:if>
									</c:forEach>
									<td>${ligneCommande.getNumCmd()}</td>
									<td>${ligneCommande.getQteCmd()}</td>
									<td><a
										href="DeleteLigneCommandeServlet?numLigne=${ligneCommande.getNumLigne()}"
										class="btn btn-danger">Delete</a><a
										href="UpdateLigneCommandeServlet?numLigne=${ligneCommande.getNumLigne()}"
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