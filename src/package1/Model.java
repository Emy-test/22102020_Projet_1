package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import package1.Logiciels;

public class Model {
	public static ArrayList<Logiciels> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static ArrayList<Logiciels> getListe() {
		return liste;
	}

	public static void setListe(ArrayList<Logiciels> liste) {
		Model.liste = liste;
	}

//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		Model.conn = conn;
//	}

	public static void ajouterLogiciels(Logiciels p) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into logiciels(id_logiciel, nom) value(?,?)");
			prst.setLong(1, p.getId_logiciel());
			prst.setString(2, p.getNom());
		
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}

	

	public static Logiciels chercherLogiciels(int id) {
		for (Logiciels p : liste) {
			if (p.getId_logiciel()==id)
				return p;
		}
		return null;
	}

	public static Logiciels chercherIDLogiciels(String nom) {
		for (Logiciels p : liste) {
			if (p.getNom().equals(nom))
				return p;
		}
		return null;
	}


	public static ArrayList<Logiciels> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Logiciels> listep = new ArrayList<Logiciels>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from logiciels");
			if (rs != null) {
				while (rs.next()) {
					Logiciels p = new Logiciels();
					p.setId_logiciel(rs.getLong("id_logiciel"));
					p.setNom(rs.getString("nom"));
				
					listep.add(p);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listep;
	}
	


	public static void supprimerLogiciels(long id) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from logiciels where id_logiciel = ?");
			prst.setLong(1, id);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public String toString() {
		String chaine="";
		for (Logiciels i: getListe()) {
			chaine+= i.getId_logiciel()+ " | "+i.getNom()+"\n";
		}
		return chaine;
		
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
