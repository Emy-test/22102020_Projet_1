package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import package1.Logiciels;

public class Modelsolution {
	public static ArrayList<Solution> liste = versCollection();
	public static Connection conn = Connecteur.getConnection();
	
	public static ArrayList<Solution> getListe() {
		return liste;
	}

	public static void setListe(ArrayList<Solution> liste) {
		Modelsolution.liste = liste;
	}

//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		Modelsolution.conn = conn;
//	}

	public static void ajouterSolution(Solution p) {
		try {
			Statement st = conn.createStatement();
			PreparedStatement prst = conn.prepareStatement(
					"insert into solution(id_solution, description, id_bulletin) value(?,?,?)");
			prst.setInt(1, p.getId_solution());
			prst.setString(2, p.getDescription());
			prst.setInt(3, p.getId_bulletin());
		
			prst.execute();
			liste = versCollection();
		} catch (SQLException excep) {
			excep.printStackTrace();
		}

	}


	public static Solution chercherSolution(int id) {
		for (Solution p : liste) {
			if (p.getId_solution()==id)
				return p;
		}
		return null;
	}



	public static ArrayList<Solution> versCollection() {
		Connection conn = Connecteur.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Solution> listep = new ArrayList<Solution>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from solution");
			if (rs != null) {
				while (rs.next()) {
					Solution p = new Solution();
					p.setId_solution(rs.getInt("id_solution"));
					p.setDescription(rs.getString("description"));
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
		for (Solution i: versCollection()) {
			chaine+= i.getId_solution()+ " | "+i.getDescription()+"\n";
		}
		return chaine;
		
	}


	public static void supprimerSolution(int id) {
		PreparedStatement prst = null;
		try {
			prst = conn.prepareStatement("delete from solution where id_solution = ?");
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
