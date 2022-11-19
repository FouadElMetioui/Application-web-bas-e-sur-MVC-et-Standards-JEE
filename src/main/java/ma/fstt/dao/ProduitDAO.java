package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitRepository;

public class ProduitDAO implements ProduitRepository{


	Connection conn = SingletonConnection.getConnection();

	@Override
	public Produit trouverById(int id) throws SQLException {

		PreparedStatement ps = conn.prepareStatement("select * from produit WHERE codePr = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Produit p = new Produit();
		rs.next();
		p.setCodePr(id);
		p.setNomPr(rs.getString("nomPr"));
		p.setPu(rs.getFloat("pu"));
		p.setQteStock(rs.getInt("qteStock"));
		
		return p;
	}

	@Override
	public void ajouterProduit(Produit produit) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"insert into produit (codePr , nomPr , pu, qteStock) values(?,?,?,?)");
		
		ps.setInt(1, produit.getCodePr());
		ps.setString(2, produit.getNomPr());
		ps.setFloat(3, produit.getPu());
		ps.setInt(4, produit.getQteStock());

		ps.execute();
	}

	@Override
	public List<Produit> findAll() throws SQLException {
		List<Produit> produits=new ArrayList<Produit>();
		PreparedStatement ps = conn.prepareStatement("select * from produit");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Produit p = new Produit();
			p.setCodePr(rs.getInt("codePr"));
			p.setNomPr(rs.getString("nomPr"));
			p.setPu(rs.getFloat("pu"));
			p.setQteStock(rs.getInt("qteStock"));
			produits.add(p);
		}

		return produits;
	}

	@Override
	public void deleteProduit(int codePr) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("delete from produit WHERE codePr = ?");
		ps.setInt(1, codePr);
		ps.execute();
	}

	@Override
	public Produit updateProduit(Produit produit, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("update produit SET nomPr = ? , pu = ? , qteStock = ?  WHERE codePr = ?");
		ps.setString(1, produit.getNomPr());
		ps.setFloat(2, produit.getPu());
		ps.setInt(3, produit.getQteStock());
		ps.setInt(4, id);
		ps.execute();
		
		return produit;

	}
}
