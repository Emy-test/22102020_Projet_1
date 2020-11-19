package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import package1.Logiciels;

public class Modelperimetre_solution {
	public static ArrayList<perimetre_solution> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static ArrayList<perimetre_solution> getListe() {
		return liste;
	}

	public static void setListe(ArrayList<perimetre_solution> liste) {
		Modelperimetre_solution.liste = liste;
	}

//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		Modelperimetre_solution.conn = conn;
//	}

	public static void ajoutersolution(perimetre_solution p) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into bulletin_solution(id_solution, id_bulletin) value(?,?)");
//			prst.setInt(1, p.getId());
			prst.setInt(1, p.getId_solution());
			prst.setInt(2, p.getId_bulletin());
		
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}
	
	public static void ajouterperimetre_solution(int id_solution, int id_bulletin) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into bulletin_solution(id_solution, id_bulletin) value(?,?)");
//			prst.setInt(1, p.getId());
			prst.setInt(1, id_solution);
			prst.setInt(2, id_bulletin);
		
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



	public static ArrayList<perimetre_solution> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<perimetre_solution> listep = new ArrayList<perimetre_solution>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from bulletin_solution");
			if (rs != null) {
				while (rs.next()) {
					perimetre_solution p = new perimetre_solution();
//					p.setId(rs.getInt("id"));
					p.setId_solution(rs.getInt("id_solution"));
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
		for (perimetre_solution i: versCollection()) {
			chaine+= i.getId_solution()+ " | "+i.getId_bulletin()+"\n";
		}
		return chaine;
	}

	public static void supprimerperimetre_solution(int id_solution, int id_bulletin) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from bulletin_solution where id_solution = ? and id_bulletin = ?");
			prst.setInt(1, id_solution);
			prst.setInt(2, id_bulletin);
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
//			st.execute("insert into logciels values(9,\"groupe1\")");
//			st.execute("insert into logiciels values(8,\"groupe2\")");
//			
//			liste = versCollection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

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
