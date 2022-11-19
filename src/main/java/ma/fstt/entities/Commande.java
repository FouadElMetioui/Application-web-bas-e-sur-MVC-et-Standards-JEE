package ma.fstt.entities;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {

	private int numCmd;
	private Date dateCmd;
	private int codeCli;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int numCmd, Date dateCmd, int codeCli) {
		super();
		this.numCmd = numCmd;
		this.dateCmd = dateCmd;
		this.codeCli = codeCli;
	}

	public int getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(int numCmd) {
		this.numCmd = numCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public int getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(int codeCli) {
		this.codeCli = codeCli;
	}

}
