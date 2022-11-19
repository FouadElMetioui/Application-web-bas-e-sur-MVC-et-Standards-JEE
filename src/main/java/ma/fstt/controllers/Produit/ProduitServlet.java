package ma.fstt.controllers.Produit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Produit;

@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDAO produitDAO;
	private Produit produit;
	private List<Produit> produits;

	public ProduitServlet() {
		super();
		produitDAO = new ProduitDAO();
		produits = new ArrayList<>();
		produit = new Produit();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recuperer la liste des produits
		try {
			produits = produitDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// stocker les donnes recupere dans l'objet request
		request.setAttribute("produits", produits);

		request.getRequestDispatcher("jsp/produit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// capter les donnes qui sont dans la formule
		String nomPr = request.getParameter("nomPr");
		float pu = Float.parseFloat(request.getParameter("pu"));
		int qteStock = Integer.parseInt(request.getParameter("qteStock"));

		// creer un produit
		produit.setNomPr(nomPr);
		produit.setPu(pu);
		produit.setQteStock(qteStock);

		// enregistrer le produit
		try {
			produitDAO.ajouterProduit(produit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// recuperer la liste des produits
		try {
			produits = produitDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// stocker les donnes recupere dans l'objet request
		request.setAttribute("produits", produits);

		request.getRequestDispatcher("jsp/produit.jsp").forward(request, response);

	}

}
