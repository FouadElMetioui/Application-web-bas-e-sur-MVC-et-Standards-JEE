package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.LigneCommande;

public interface LigneCommandeRepository {
	
	public LigneCommande trouverById(int id) throws Exception;

	void ajouterLigneCommande(LigneCommande ligneCommande) throws Exception;

	public List<LigneCommande> findAll() throws Exception;

	void deleteLigneCommande(int numLigne) throws Exception;
	
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande , int id) throws Exception;
}
