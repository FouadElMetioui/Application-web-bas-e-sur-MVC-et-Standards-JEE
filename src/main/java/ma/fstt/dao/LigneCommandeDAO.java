package ma.fstt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.LigneCommande;
import ma.fstt.service.LigneCommandeRepository;

public class LigneCommandeDAO implements LigneCommandeRepository {

	Connection conn = SingletonConnection.getConnection();

	@Override
	public LigneCommande trouverById(int id) throws SQLException {

		PreparedStatement ps = conn.prepareStatement("select * from lignecommande WHERE numLigne = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		LigneCommande l = new LigneCommande();
		rs.next();
		l.setNumLigne(rs.getInt("numLigne"));
		l.setCodePr(rs.getInt("codePr"));
		l.setNumCmd(rs.getInt("numCmd"));
		l.setQteCmd(rs.getInt("qteCmd"));
		return l;
	}

	
	@Override
	
	public void ajouterLigneCommande(LigneCommande ligneCommande) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"insert into lignecommande (numLigne , codePr , numCmd, qteCmd) values(?,?,?,?)");
		ps.setInt(1, ligneCommande.getNumLigne());
		ps.setInt(2, ligneCommande.getCodePr());
		ps.setInt(3, ligneCommande.getNumCmd());
		ps.setInt(4, ligneCommande.getQteCmd());

		ps.execute();
	}

	@Override
	public List<LigneCommande> findAll() throws SQLException {
		List<LigneCommande> ligneCommandes=new ArrayList<LigneCommande>();
		PreparedStatement ps = conn.prepareStatement("select * from lignecommande");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			LigneCommande lc = new LigneCommande();
			lc.setCodePr(rs.getInt("codePr"));
			lc.setNumCmd(rs.getInt("numCmd"));
			lc.setNumLigne(rs.getInt("numLigne"));
			lc.setQteCmd(rs.getInt("qteCmd"));
			
			ligneCommandes.add(lc);
		}

		return ligneCommandes;
	}

	@Override
	public void deleteLigneCommande(int numLigne) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("delete from lignecommande WHERE numLigne = ?");
		ps.setInt(1, numLigne);
		ps.execute();
	}

	@Override
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("update lignecommande SET codePr = ? , numCmd = ? , qteCmd = ? WHERE numLigne = ?");
		ps.setInt(1, ligneCommande.getCodePr());
		ps.setInt(2, ligneCommande.getNumCmd());
		ps.setInt(3, ligneCommande.getQteCmd());
		ps.setInt(4, id);
		ps.execute();
		return ligneCommande;

	}


}
