package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelperimetre {
	
	public static ArrayList<Perimetre> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static ArrayList<Perimetre> getListe() {
		return liste;
	}

	public static void setListe(ArrayList<Perimetre> liste) {
		Modelperimetre.liste = liste;
	}

//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		Model.conn = conn;
//	}

	public static void ajouterPerimetre(int id_logiciel, int id_bulletin) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"INSERT INTO `logiciel_bulletin`(`id_logiciel`, `id_bulletin`) value(?,?)");
			prst.setInt(1, id_logiciel);
			prst.setInt(2, id_bulletin);
			
		
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}


	public static Perimetre chercherPerimetre(long id_logiciel) {
		for (Perimetre p : liste) {
			if (p.getId_logiciel()==id_logiciel)
				return p;
		}
		return null;
	}


	public static ArrayList<Perimetre> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Perimetre> listep = new ArrayList<Perimetre>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from logiciel_bulletin");
			if (rs != null) {
				while (rs.next()) {
					Perimetre p = new Perimetre();
					p.setId_logiciel(rs.getInt("id_logiciel"));
					p.setId_bulletin(rs.getInt("id_bulletin"));
									
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
		for (Perimetre i: versCollection()) {
			chaine+= i.getId_logiciel()+ " | "+i.getId_bulletin()+"\n";
		}
		return chaine;
	}

	public static void supprimerPerimetre(long id) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from logiciel_bulletin where id_logiciel = ?");
			prst.setLong(1, id);
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
