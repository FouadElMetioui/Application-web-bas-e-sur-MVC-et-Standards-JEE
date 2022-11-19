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



@WebServlet("/DeleteClientServlet")
public class DeleteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client ;
	private ClientDAO clientDAO;
	private List<Client> clients;
  
    public DeleteClientServlet() {
        super();
        client  = new Client();
        clientDAO = new ClientDAO();
        clients = new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codC = request.getParameter("codeCli");
		System.out.println("delete 1: "+codC);
		int codeCli = Integer.parseInt(codC);
		System.out.println("delete 2: "+codeCli);
		try {
			clientDAO.deleteClient(codeCli);
		} catch (SQLException e) {
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


	
request.getRequestDispatcher("jsp/client.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
