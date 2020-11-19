package package1;

public class User {
	String nom, login, pwd, role, mail;
	int id;
	
	


//	public User(String nom, String login, String pwd, String role, String mail, int id) {
//		super();
//		this.nom = nom;
//		this.login = login;
//		this.pwd = pwd;
//		this.role = role;
//		this.mail = mail;
//		this.id = id;
//	}

	public User(String nom, String login, String pwd, String role, String mail) {
		super();
		this.nom = nom;
		this.login = login;
		this.pwd = pwd;
		this.role = role;
		this.mail = mail;
		
	}



	public String getMail() {
		return mail;
	}




	public void setMail(String mail) {
		this.mail = mail;
	}




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getPwd() {
		return pwd;
	}




	public void setPwd(String pwd) {
		this.pwd = pwd;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




//	public User(String nom, String login, String pwd, String role, int id) {
//		super();
//		this.nom = nom;
//		this.login = login;
//		this.pwd = pwd;
//		this.role = role;
//		this.id = id;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
