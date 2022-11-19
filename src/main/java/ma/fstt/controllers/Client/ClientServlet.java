package ma.fstt.controllers.Client;

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
import ma.fstt.entities.Client;


@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO;
	private Client client;
	private List<Client> clients;

	
	public ClientServlet() {
		super();
		clientDAO = new ClientDAO();
		clients = new ArrayList<>();
		client = new Client();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recuperer la liste des clients
				try {
					clients = clientDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				// stocker les donnes recupere dans l'objet request
				request.setAttribute("clients", clients);

	    
			
		request.getRequestDispatcher("jsp/client.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// capter les donnes qui sont dans la formule
		String nomCli = request.getParameter("nomCli");
		String preCli = request.getParameter("preCli");
		String adrCli = request.getParameter("adrCli");
		String telCli = request.getParameter("telCli");
		String villeCli = request.getParameter("villeCli");
		
		// creer un client
		client.setNomCli(nomCli);
		client.setPreCli(preCli);
		client.setAdrCli(adrCli);
		client.setTelCli(telCli);
		client.setVilleCli(villeCli);
		
		// enregistrer le client
		try {
			clientDAO.ajouterClient(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// recuperer la liste des clients
		try {
			clients = clientDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// stocker les donnes recupere dans l'objet request
		request.setAttribute("clients", clients);

		request.getRequestDispatcher("jsp/client.jsp").forward(request, response);
	}

}
