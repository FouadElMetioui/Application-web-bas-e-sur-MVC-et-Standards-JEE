package ma.fstt.controllers.LigneCommande;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.LigneCommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.LigneCommande;
import ma.fstt.entities.Produit;
import ma.fstt.entities.Commande;


@WebServlet("/LigneCommandeServlet")
public class LigneCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeDAO commandeDAO;
	private Commande commande;
	private List<Commande> commandes;
	
	private LigneCommandeDAO ligneCommandeDAO;
	private LigneCommande ligneCommande;
	private List<LigneCommande> ligneCommandes;

	private ProduitDAO produitDAO;
	private Produit produit;
	private List<Produit> produits;
	
	private ClientDAO clientDAO;
	private List<Client> clients;
	
 
    public LigneCommandeServlet() {
        super();
        commandeDAO = new CommandeDAO();
		commandes = new ArrayList<>();
		commande = new Commande();
		
		clients = new ArrayList<>();
		clientDAO = new ClientDAO();
		
		ligneCommandeDAO = new LigneCommandeDAO();
		ligneCommandes = new ArrayList<>();
		ligneCommande = new LigneCommande();
		
		produitDAO = new ProduitDAO();
		produits = new ArrayList<>();
		produit = new Produit();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperer la liste des commandes
				try {
					commandes = commandeDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// recuperer la liste des clients
				try {
					clients = clientDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				// recuperer la liste des produits
				try {
					produits = produitDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// recuperer la liste des ligne de commande
				try {
					ligneCommandes = ligneCommandeDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				// stocker les donnes recupere dans l'objet request
				request.setAttribute("commandes", commandes);
				request.setAttribute("ligneCommandes", ligneCommandes);
				request.setAttribute("clients", clients);
				request.setAttribute("produits", produits);

				request.getRequestDispatcher("jsp/ligneCommande.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// capter les donnes qui sont dans la formule
				int codePr = Integer.parseInt(request.getParameter("Produitlist"));
				
				System.out.println("la code de produit est : " + codePr);
				
				int numCmd = Integer.parseInt(request.getParameter("Commandelist"));

				int qteCmd = Integer.parseInt(request.getParameter("qteCmd"));
				// creer la ligne de commande
				ligneCommande.setCodePr(codePr);
				ligneCommande.setNumCmd(numCmd);
				ligneCommande.setQteCmd(qteCmd);

				// enregistrer la ligne de commande
				try {
					ligneCommandeDAO.ajouterLigneCommande(ligneCommande);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// recuperer la liste des commandes
				try {
					commandes = commandeDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// recuperer la liste des clients
				try {
					clients = clientDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// recuperer la liste des ligne des commandes
				try {
					ligneCommandes = ligneCommandeDAO.findAll();
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
				request.setAttribute("commandes", commandes);
				request.setAttribute("ligneCommandes", ligneCommandes);
				request.setAttribute("produits", produits);
				request.setAttribute("clients", clients);
				request.getRequestDispatcher("jsp/ligneCommande.jsp").forward(request, response);
	}

}
