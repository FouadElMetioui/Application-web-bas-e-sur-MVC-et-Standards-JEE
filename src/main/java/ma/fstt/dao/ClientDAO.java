package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;

public class ClientDAO implements ClientRepository {

	Connection conn = SingletonConnection.getConnection();

	@Override
	public Client trouverById(int id) throws SQLException {

		PreparedStatement ps = conn.prepareStatement("select * from client WHERE codeCli = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Client c = new Client();
		rs.next();
		c.setCodeCli(rs.getInt("codeCli"));
		c.setNomCli(rs.getString("nomCli"));
		c.setPreCli(rs.getString("preCli"));
		c.setAdrCli(rs.getString("adrCli"));
		c.setTelCli(rs.getString("telCli"));
		c.setVilleCli(rs.getString("villeCli"));

		return c;
	}

	@Override
	public void ajouterClient(Client client) throws SQLException {
		System.out.println(" ajouter un client");
		PreparedStatement ps = conn.prepareStatement(
				"insert into client (codeCli , nomCli , preCli, adrCli ,telCli ,villeCli) values(?,?,?,?,?,?)");
		ps.setInt(1, client.getCodeCli());
		ps.setString(2, client.getNomCli());
		ps.setString(3, client.getPreCli());
		ps.setString(4, client.getAdrCli());
		ps.setString(5, client.getTelCli());
		ps.setString(6, client.getVilleCli());

		ps.execute();
	}

	@Override
	public List<Client> findAll() throws SQLException {
		List<Client> clients=new ArrayList<Client>();
		PreparedStatement ps = conn.prepareStatement("select * from client");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Client c = new Client();
			c.setCodeCli(rs.getInt("codeCli"));
			c.setNomCli(rs.getString("nomCli"));
			c.setPreCli(rs.getString("preCli"));
			c.setAdrCli(rs.getString("adrCli"));
			c.setTelCli(rs.getString("telCli"));
			c.setVilleCli(rs.getString("villeCli"));
			clients.add(c);
		}

		return clients;
	}

	@Override
	public void deleteClient(int codeCli) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("delete from client WHERE codeCli = ?");
		ps.setInt(1, codeCli);
		ps.execute();
	}

	@Override
	public Client updateClient(Client client, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("update client SET nomCli = ? , preCli = ? , adrCli = ? , telCli = ? , villeCli = ? WHERE codeCli = ?");
		ps.setString(1, client.getNomCli());
		ps.setString(2, client.getPreCli());
		ps.setString(3, client.getAdrCli());
		ps.setString(4, client.getTelCli());
		ps.setString(5, client.getVilleCli());
		
		ps.setInt(6, id);
		
		ps.execute();
		return client;

	}

}
