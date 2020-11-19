package package1;

public class Bulletin {
	public String synthese,date,reference_bulletin,priorite;
	public int id;
	public String description, references_liees_bulletin;
	String nom_bulletin;
	public String getSynthese() {
		return synthese;
	}
	public void setSynthese(String synthese) {
		this.synthese = synthese;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReference_bulletin() {
		return reference_bulletin;
	}
	public void setReference_bulletin(String reference_bulletin) {
		this.reference_bulletin = reference_bulletin;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferences_liees_bulletin() {
		return references_liees_bulletin;
	}
	public void setReferences_liees_bulletin(String references_liees_bulletin) {
		this.references_liees_bulletin = references_liees_bulletin;
	}
	public String getNom_bulletin() {
		return nom_bulletin;
	}
	public void setNom_bulletin(String nom_bulletin) {
		this.nom_bulletin = nom_bulletin;
	}
//	public Bulletin(int id, String nom_bulletin) {
//		super();
//		this.id = id;
//		this.nom_bulletin = nom_bulletin;
//	}
	public Bulletin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bulletin(String synthese, String date, String reference_bulletin, String priorite, int id,
			String description, String references_liees_bulletin, String nom_bulletin) {
		super();
		this.synthese = synthese;
		this.date = date;
		this.reference_bulletin = reference_bulletin;
		this.priorite = priorite;
		this.id = id;
		this.description = description;
		this.references_liees_bulletin = references_liees_bulletin;
		this.nom_bulletin = nom_bulletin;
	}



}
