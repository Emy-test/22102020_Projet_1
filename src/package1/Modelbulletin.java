package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelbulletin {
//	public String ajouter bulletin
	
	public static ArrayList<Bulletin> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static ArrayList<Bulletin> getListe() {
		return liste;
	}

	public static void setListe(ArrayList<Bulletin> liste) {
		Modelbulletin.liste = liste;
	}

//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		Model.conn = conn;
//	}

	public static void ajouterBulletin(Bulletin p) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"INSERT INTO `bulletin`(`synthese`, `date`, `reference_bulletin`, `priorite`, `description`, `references_liees_bulletin`, `id_bulletin`, `nom_bulletin`) value(?,?,?,?,?,?,?,?)");
			prst.setString(1, p.getSynthese());
			prst.setString(2, p.getDate());
			prst.setString(3, p.getReference_bulletin());
			prst.setString(4, p.getPriorite());
			
			prst.setString(5, p.getDescription());
			prst.setString(6, p.getReferences_liees_bulletin());
			prst.setInt(7, p.getId());
			prst.setString(8, p.getNom_bulletin());
		
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}


	public static Bulletin chercherBulletin(int id) {
		for (Bulletin p : liste) {
			if (p.getId()==id)
				return p;
		}
		return null;
	}



	public static ArrayList<Bulletin> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Bulletin> listep = new ArrayList<Bulletin>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from bulletin");
			if (rs != null) {
				while (rs.next()) {
					Bulletin p = new Bulletin();
					p.setSynthese(rs.getString("synthese"));
					p.setDate(rs.getString("date"));
					p.setReference_bulletin(rs.getString("reference_bulletin"));
					p.setPriorite(rs.getString("priorite"));
					
					p.setDescription(rs.getString("description"));
					p.setReferences_liees_bulletin(rs.getString("references_liees_bulletin"));
					p.setId(rs.getInt("id_bulletin"));
					p.setNom_bulletin(rs.getString("nom_bulletin"));
				
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
		for (Bulletin i: versCollection()) {
			chaine+= i.getId()+ " | "+i.getNom_bulletin()+"\n";
		}
		return chaine;
		
	}

	public static void supprimerBulletin(int id) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from bulletin where id_bulletin = ?");
			prst.setInt(1, id);
			prst.executeUpdate();
			liste = versCollection();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

//	public static void alimenterBase() {
//		Connection conn = Connecteur.getConnection();
//		try {
//			Statement st = conn.createStatement();
//			st.execute("insert into bulletin values(9,\"groupe1\")");
//			st.execute("insert into bulletin values(8,\"groupe2\")");
//			
//			liste = versCollection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}


}
