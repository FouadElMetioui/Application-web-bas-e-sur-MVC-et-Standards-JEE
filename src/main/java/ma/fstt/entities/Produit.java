package ma.fstt.entities;

import java.io.Serializable;

public class Produit implements Serializable {

	private int codePr;
	private String nomPr;
	private float pu;
	private int qteStock;

	public Produit(int codePr, String nomPr, float pu, int qteStock) {
		super();
		this.codePr = codePr;
		this.nomPr = nomPr;
		this.pu = pu;
		this.qteStock = qteStock;
	}

	
	public int getQteStock() {
		return qteStock;
	}


	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}


	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodePr() {
		return codePr;
	}

	public void setCodePr(int codePr) {
		this.codePr = codePr;
	}

	public String getNomPr() {
		return nomPr;
	}

	public void setNomPr(String nomPr) {
		this.nomPr = nomPr;
	}

	public float getPu() {
		return pu;
	}

	public void setPu(float pu) {
		this.pu = pu;
	}

	

}
