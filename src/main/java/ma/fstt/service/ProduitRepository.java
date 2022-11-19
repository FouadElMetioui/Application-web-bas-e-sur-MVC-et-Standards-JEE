package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Produit;

public interface ProduitRepository {

	Produit trouverById(int id) throws Exception;

	void ajouterProduit(Produit produit) throws Exception;

	public List<Produit> findAll() throws Exception;

	void deleteProduit(int codePr) throws Exception;
	
	public Produit updateProduit(Produit produit , int id) throws Exception;
	
}
