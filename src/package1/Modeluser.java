package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import package1.Logiciels;

public class Modeluser {
	public static ArrayList<User> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static ArrayList<User> getListe() {
		return liste;
	}

	public static void setListe(ArrayList<User> liste) {
		Modeluser.liste = liste;
	}

//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		Modeluser.conn = conn;
//	}
	

	public static void ajouterUser(User p) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"INSERT INTO `utilisateur`(`login`, `pwd`, `nom`, `role`, `mail`) value(?,?,?,?,?)");
//			prst.setInt(1, p.getId());
			prst.setString(1, p.getLogin());
			prst.setString(2, p.getPwd());
			prst.setString(3, p.getNom());
			prst.setString(4, p.getRole());
			prst.setString(5, p.getMail());
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}

	public static User chercherUser(String login, String pwd) {
		for (User p : liste) {
			if (p.getLogin().equals(login) && p.getPwd().equals(pwd))
				return p;
		}
		return null;
	}
	
	public static User chercherUser(long id) {
		for (User p : liste) {
			if (p.getId()==id)
				return p;
		}
		return null;
	}


	public static ArrayList<User> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<User> listep = new ArrayList<User>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from utilisateur");
			if (rs != null) {
				while (rs.next()) {
					User p = new User();
					p.setId(rs.getInt("id"));
					p.setLogin(rs.getString("login"));
					p.setPwd(rs.getString("pwd"));
					
					p.setNom(rs.getString("nom"));
					p.setRole(rs.getString("role"));
					p.setMail(rs.getString("mail"));
					listep.add(p);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listep;
	}
	
	public String toString() {
		String chaine="";
		for (User i: getListe()) {
			chaine+= i.getNom()+"\n";
		}
		return chaine;
	}

//cette fonction est créée uniquement pour les tests.
	public static void supprimerUser(String nom) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from utilisateur where nom = ?");
			prst.setString(1, nom);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}


//	public static ArrayList<String> getListeGroupes(){
//		ResultSet rs = null;
//		Statement st=null;
//		ArrayList<String> listeg = new ArrayList<String>();
//		try {
//			st = conn.createStatement();
//			
//			rs = st.executeQuery("select code_groupe from groupe");
//			if (rs != null) {
//				while (rs.next()) {
//					listeg.add(rs.getString("code_groupe"));					
//				}
//			}
//		}catch(SQLException e) {
//			e.getMessage();
//		}
//		return listeg;
//
//	}
	
}
