package pac1Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.junit.BeforeClass;
import org.junit.Test;

import package1.Authentification;
import package1.Bulletin;
import package1.Connecteur;
import package1.Deconnexion;
import package1.Logiciels;
import package1.Model;
import package1.Modelbulletin;
import package1.Modelsolution;
import package1.Solution;

public class ServletTest {
	private static Authentification auth;
	private static Deconnexion dec;
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	//public static HttpSession session, session1;
	public Connecteur connect;
	public static Connection c;
	
	public static Modelsolution msolution;
	public static Modelbulletin mbulletin;
	public static Model mlogiciel;
	
	public static ArrayList<Logiciels> liste_logiciel;
	public static ArrayList<Bulletin> liste_bulletin;
	public static ArrayList<Solution> liste_solution;

	@BeforeClass
	public static void init() {
		c = null;
		mlogiciel = new Model();
		msolution= new Modelsolution();
		mbulletin= new Modelbulletin();
				 
	}

//	@Test
//	public void testConnexion() throws ServletException, IOException {
//		//auth.doGet(request, response);
//		//session=request.getSession(true);
//		
//		assertEquals(1, auth.session.getId());
//		
//		}
//	
//	@Test
//	public void testDeconnexion() throws ServletException, IOException {
//		HttpSession session1=request.getSession(false);
//		assertEquals(dec.session, session1);
//		
//	}
	
//	@Test
//	public void TestConnecteur() throws SQLException {
//		connect.getConnection();
//		c = DriverManager.getConnection("jdbc:mysql://localhost/menace", "root", "");
//		assertEquals(c, connect.getConnection());
//	}
	
//	@Test
//	public void TestSupression() throws SQLException {
//		System.out.println(mlogiciel.toString());
//		assertEquals(liste_logiciel, mlogiciel.toString());
//		assertEquals(liste_bulletin, mbulletin.toString());
//		assertEquals(liste_solution, msolution.toString());
//	}

}
