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
import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;


@WebServlet("/UpdateProduitServlet")
public class UpdateProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProduitDAO produitDAO;
	private Produit produit;
	private List<Produit> produits;

	public UpdateProduitServlet() {
		super();
		produitDAO = new ProduitDAO();
		produits = new ArrayList<>();
		produit = new Produit();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codP = request.getParameter("codePr");
		int codePr = Integer.parseInt(codP);
		try {
			produit = produitDAO.trouverById(codePr);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// recuperer a nouveau la liste des produits
		try {
			produits = produitDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// stocker les donnes recupere dans l'objet request
		request.setAttribute("produits", produits);

		request.setAttribute("produit", produit);
		request.getRequestDispatcher("jsp/produit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// capter les donnes qui sont dans la formule
		String nomPr = request.getParameter("nomPr");
		float pu = Float.parseFloat(request.getParameter("pu"));
		int qteStock = Integer.parseInt(request.getParameter("qteStock"));

		// creer un produit
		Produit pr = new Produit();
		pr.setNomPr(nomPr);
		pr.setPu(pu);;
		pr.setQteStock(qteStock);
		int id = Integer.parseInt(request.getParameter("codePr"));

		// modifier le produit
		try {
			produitDAO.updateProduit(pr, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// recuperer la liste des produits
		try {
			produits = produitDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// stocker les donnes recupere dans l'objet request
		request.setAttribute("produits", produits);

		request.getRequestDispatcher("jsp/produit.jsp").forward(request, response);

	}

}
