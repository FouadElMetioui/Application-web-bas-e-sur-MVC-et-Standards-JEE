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


@WebServlet("/DeleteProduitServlet")
public class DeleteProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDAO produitDAO;
	private Produit produit;
	private List<Produit> produits;

	
	public DeleteProduitServlet() {
		super();
		
		produitDAO = new ProduitDAO();
		produits = new ArrayList<>();
		produit = new Produit();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codP = request.getParameter("codePr");
		System.out.println("delete 1: " + codP);
		int codePr = Integer.parseInt(codP);
		System.out.println("delete 2: " + codePr);
		try {
			produitDAO.deleteProduit(codePr);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// recuperer a nouveau la liste des clients
		try {
			produits = produitDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// stocker les donnes recupere dans l'objet request
		request.setAttribute("produits", produits);

		request.getRequestDispatcher("jsp/produit.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
