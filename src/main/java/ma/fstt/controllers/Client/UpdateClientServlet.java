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

@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client;
	private ClientDAO clientDAO;
	private List<Client> clients;

	public UpdateClientServlet() {
		super();
		client = new Client();
		clientDAO = new ClientDAO();
		clients = new ArrayList<>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codC = request.getParameter("codeCli");
		int codeCli = Integer.parseInt(codC);
		try {
			client = clientDAO.trouverById(codeCli);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// recuperer a nouveau la liste des clients
		try {
			clients = clientDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// stocker les donnes recupere dans l'objet request
		request.setAttribute("clients", clients);

		request.setAttribute("client", client);
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
				Client cl = new Client();
				cl.setNomCli(nomCli);
				cl.setPreCli(preCli);
				cl.setAdrCli(adrCli);
				cl.setTelCli(telCli);
				cl.setVilleCli(villeCli);
				int id = Integer.parseInt(request.getParameter("codeCli"));
				
				// modifier  le client
				try {
					clientDAO.updateClient(cl, id);
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
