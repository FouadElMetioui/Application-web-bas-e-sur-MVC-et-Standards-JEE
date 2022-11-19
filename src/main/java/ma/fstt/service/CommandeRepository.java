package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Commande;

public interface CommandeRepository {

	Commande trouverById(int id) throws Exception;

	void ajouterCommande(Commande commande) throws Exception;

	public List<Commande> findAll() throws Exception;

	void deleteCommande(int numCmd) throws Exception;
	
	public Commande updateCommande(Commande commande , int id) throws Exception;
	
}
