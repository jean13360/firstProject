package sing.boot.test.hello;

import com.google.gson.annotations.SerializedName;

public class UserDummy {
	private String nom;
	@SerializedName("Prenom")
	private String prenom;
	private String iddgasi;        
	private String groupe;
	public UserDummy() {}
	//Nom=AgentNom1, Prenom=AgentPreNom1, IDDGASI=IXXXYYYY, Groupe=TesteurAPI
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getIDDGASI() {
		return iddgasi;
	}
	public void setIDDGASI(String iDDGASI) {
		this.iddgasi = iDDGASI;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	
	
}
