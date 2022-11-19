package ma.fstt.entities;

public class Client {

	private int codeCli;
	private String nomCli;
	private String preCli;
	private String adrCli;
	private String telCli;
	private String villeCli;

	public int getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(int codeCli) {
		this.codeCli = codeCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPreCli() {
		return preCli;
	}

	public void setPreCli(String preCli) {
		this.preCli = preCli;
	}

	public String getAdrCli() {
		return adrCli;
	}

	public void setAdrCli(String adrCli) {
		this.adrCli = adrCli;
	}

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}

	

	public Client(int codeCli, String nomCli, String preCli, String adrCli, String telCli, String villeCli) {
		super();
		this.codeCli = codeCli;
		this.nomCli = nomCli;
		this.preCli = preCli;
		this.adrCli = adrCli;
		this.telCli = telCli;
		this.villeCli = villeCli;
	}

	public String getVilleCli() {
		return villeCli;
	}

	public void setVilleCli(String villeCli) {
		this.villeCli = villeCli;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

}
