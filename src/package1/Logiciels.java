package package1;

public class Logiciels {
	Long id_logiciel;
	String nom;
	
	

	public Long getId_logiciel() {
		return id_logiciel;
	}



	public void setId_logiciel(Long id_logiciel) {
		this.id_logiciel = id_logiciel;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Logiciels() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Logiciels(Long id_logiciel, String nom) {
		super();
		this.id_logiciel = id_logiciel;
		this.nom = nom;
	}


}
