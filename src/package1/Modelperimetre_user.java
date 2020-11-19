package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import package1.Logiciels;

public class Modelperimetre_user {
	public static ArrayList<perimetre_user> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static ArrayList<perimetre_user> getListe() {
		return liste;
	}

	public static void setListe(ArrayList<perimetre_user> liste) {
		Modelperimetre_user.liste = liste;
	}

//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		Modelperimetre_user.conn = conn;
//	}
	
	public static void ajouterperimetre_user(int id_utilisateur, int id_logiciel){
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"INSERT INTO `utilisateurs_logiciels`(`id_utilisateur`, `id_logiciel`) value(?,?)");
//			prst.setInt(1, p.getId());
			prst.setInt(1, id_utilisateur);
			prst.setInt(2, id_logiciel);
		
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}

	public static void ajouterperimetre_user(perimetre_user p) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"INSERT INTO `utilisateurs_logiciels`(`id_utilisateur`, `id_logiciel`) value(?,?)");
//			prst.setInt(1, p.getId());
			prst.setInt(1, p.getId_utilisateur());
			prst.setInt(2, p.getId_logiciel());
		
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}


//
//	public static perimetre_solution cherchersolution(int id) {
//		for (perimetre_solution p : liste) {
//			if (p.getId()==id)
//				return p;
//		}
//		return null;
//	}



	public static ArrayList<perimetre_user> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<perimetre_user> listep = new ArrayList<perimetre_user>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from utilisateurs_logiciels");
			if (rs != null) {
				while (rs.next()) {
					perimetre_user p = new perimetre_user();
//					p.setId(rs.getInt("id"));
					p.setId_utilisateur(rs.getInt("id_utilisateur"));
					p.setId_logiciel(rs.getInt("id_logiciel"));
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
		for (perimetre_user i: versCollection()) {
			chaine+= i.getId_logiciel()+ " | "+i.getId_utilisateur()+"\n";
		}
		return chaine;
	}
//fonction créée uniquement pour les tests
	public static void supprimerperimetre_user(int id) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from utilisateurs_logiciels where id_logiciel = ?");
			prst.setInt(1, id);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

	
}
