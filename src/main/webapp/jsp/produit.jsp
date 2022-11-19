<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="ma.fstt.entities.Produit"%>
<%@page import="java.util.List"%>
<%
List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>
<%
Produit produit = (Produit) request.getAttribute("produit");
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
				<c:if test="${empty produit}">
					<div class="col-4 mt-4">
						<form method="post" action="ProduitServlet" class="card">
							<div class="form-group">
								<label for="nom">Nom Produit</label> <input type="text"
									name="nomPr" class="form-control" id="nom"
									placeholder="Entrer le nom du produit">
							</div>
							<div class="form-group">
								<label for="prenom">Prix Unitaire</label> <input type="text"
									name="pu" class="form-control" id="prenom"
									placeholder="Entrer le pu du produit">
							</div>
							<div class="form-group">
								<label for="adress">Quantite en Stock</label> <input type="text"
									name="qteStock" class="form-control" id="adress"
									placeholder="Entrer la quntie du produit">
							</div>
							<input type="submit" class="btn btn-primary mb-2 mt-3"
								value="Ajouter">
						</form>
					</div>
				</c:if>
				<c:if test="${not empty produit}">
					<div class="col-4 mt-4">
						<form method="post" action="UpdateProduitServlet" class="card">
							<div class="form-group">
								<label for="nom">Nom Produit</label> <input type="text"
									name="nomPr" class="form-control" id="nom"
									placeholder="Entrer le nom du produit"
									value="${ produit.getNomPr()}">
							</div>
							<div class="form-group">
								<label for="prenom">Prix Unitaire</label> <input type="text"
									name="pu" class="form-control" id="prenom"
									placeholder="Entrer le pu du produit"
									value="${ produit.getPu()}">
							</div>
							<div class="form-group">
								<label for="adress">Quantite en Stock</label> <input type="text"
									name="qteStock" class="form-control" id="adress"
									placeholder="Entrer la quntie du produit"
									value="${ produit.getQteStock()}">
							</div>
							<input type="hidden" id="id" name="codePr"
								value="${ produit.getCodePr()}"> <input type="submit"
								class="btn btn-warning mb-2 mt-3" value="Update">
						</form>
					</div>
				</c:if>

				<div class="col-6 mt-4">
					<table class="table" class="card">
						<thead class="card-header">
							<tr>
								<th scope="col">Nom</th>
								<th scope="col">prix unitaire</th>
								<th scope="col">quantite en stock</th>
								<th scope="col">action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${produits}" var="produit">
								<tr>
									<td>${produit.getNomPr()}</td>
									<td>${produit.getPu()}</td>
									<td>${produit.getQteStock()}</td>
									<td><a
										href="DeleteProduitServlet?codePr=${produit.getCodePr()}"
										class="btn btn-danger">Delete</a><a
										href="UpdateProduitServlet?codePr=${produit.getCodePr()}"
										class="btn btn-warning">update</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

</body>
</html>