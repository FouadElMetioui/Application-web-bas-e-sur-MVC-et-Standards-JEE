package ma.fstt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeRepository;

public class CommandeDAO implements CommandeRepository{

	Connection conn = SingletonConnection.getConnection();

	@Override
	public Commande trouverById(int id) throws SQLException {

		PreparedStatement ps = conn.prepareStatement("select * from commande WHERE numCmd = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Commande c = new Commande();
		rs.next();
		c.setNumCmd(id);
		c.setDateCmd(rs.getDate("dateCmd"));
		c.setCodeCli(rs.getInt("codeCli"));
		
		return c;
	}

	@Override
	public void ajouterCommande(Commande commande) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"insert into commande (numCmd , dateCmd , codeCli) values(?,?,?)");
		ps.setInt(1, commande.getNumCmd());
		ps.setDate(2, (Date) commande.getDateCmd());
		ps.setInt(3, commande.getCodeCli());
		

		ps.execute();
	}

	@Override
	public List<Commande> findAll() throws SQLException {
		List<Commande> commandes=new ArrayList<Commande>();
		PreparedStatement ps = conn.prepareStatement("select * from commande");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Commande c = new Commande();
			c.setNumCmd(rs.getInt("numCmd"));
			c.setDateCmd(rs.getDate("dateCmd"));
			c.setCodeCli(rs.getInt("codeCli"));
			
			commandes.add(c);
		}

		return commandes;
	}

	@Override
	public void deleteCommande(int numCmd) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("delete from commande WHERE numCmd = ?");
		ps.setInt(1, numCmd);
		ps.execute();
	}

	@Override
	public Commande updateCommande(Commande commande, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("update commande SET dateCmd = ? , codeCli = ?  WHERE numCmd = ?");
		ps.setDate(1, (Date) commande.getDateCmd());
		ps.setInt(2, commande.getCodeCli());
		ps.setInt(3, id);
		ps.execute();
		return commande;

	}


}
