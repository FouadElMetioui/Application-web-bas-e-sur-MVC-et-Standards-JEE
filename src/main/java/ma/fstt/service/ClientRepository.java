package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;

public interface ClientRepository {

	Client trouverById(int id) throws Exception;

	void ajouterClient(Client client) throws Exception;

	public List<Client> findAll() throws Exception;

	void deleteClient(int codeCli) throws Exception;
	
	public Client updateClient(Client client , int id) throws Exception;
	

}
