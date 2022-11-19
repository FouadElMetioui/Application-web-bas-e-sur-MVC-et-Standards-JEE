package ma.fstt.entities;

public class LigneCommande {

	private int numLigne;
	private int codePr ;
	private int numCmd;
	private int qteCmd;
	public int getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}
	public int getCodePr() {
		return codePr;
	}
	public void setCodePr(int codePr) {
		this.codePr = codePr;
	}
	public int getNumCmd() {
		return numCmd;
	}
	public void setNumCmd(int numCmd) {
		this.numCmd = numCmd;
	}
	public int getQteCmd() {
		return qteCmd;
	}
	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}
	public LigneCommande(int numLigne, int codePr, int numCmd, int qteCmd) {
		super();
		this.numLigne = numLigne;
		this.codePr = codePr;
		this.numCmd = numCmd;
		this.qteCmd = qteCmd;
	}
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
