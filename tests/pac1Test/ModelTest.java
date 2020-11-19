package pac1Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import package1.Bulletin;
import package1.Logiciels;
import package1.Model;
import package1.Modelbulletin;
import package1.Modelperimetre;
import package1.Modelperimetre_solution;
import package1.Modelperimetre_user;
import package1.Modelsolution;
import package1.Modeluser;
import package1.Perimetre;
import package1.Solution;
import package1.User;
import package1.perimetre_solution;
import package1.perimetre_user;

public class ModelTest {
	
	public static Modelsolution msolution;
	public static Modelbulletin mbulletin;
	public static Model mlogiciel;
	public static Modeluser muser;
	public static Modelperimetre_solution mperimetre_solution;
	public static Modelperimetre mperimetre;
	public static Modelperimetre_user mperimetre_user;
	
	public static Bulletin bulletin;
	public static Solution solution;
	public static Logiciels logiciel;
	public static User user;
	public static Perimetre perimetre;
	public static perimetre_solution psolution;
	public static perimetre_user puser;
	
	
	public static ArrayList<Logiciels> liste_logiciel;
	public static ArrayList<Bulletin> liste_bulletin;
	public static ArrayList<Solution> liste_solution;
	public static String chaine_bulletin, chaine_bulletin1, chaine_solution, chaine_solution1, chaine_logiciel, chaine_logiciel1;
	public static String chaine_user, chaine_user1, chaine_mperimetre_user, chaine_mperimetre_user1, chaine_mperimetre_user2, chaine_mperimetre, chaine_mperimetre1, chaine_mpermietre_solution, chaine_mpermietre_solution1, chaine_mpermietre_solution2;
	
	@BeforeClass
	public static void init() {
		msolution= new Modelsolution();
		mbulletin= new Modelbulletin();
		mlogiciel= new Model();
		muser = new Modeluser();
		mperimetre_solution= new Modelperimetre_solution();
		mperimetre= new Modelperimetre();
		mperimetre_user= new Modelperimetre_user();
						
		bulletin= new Bulletin("", "", "", "", 10, "", "", "Test");
		solution = new Solution(2, 1, "Solution");
		logiciel = new Logiciels((long) 14, "Logiciel");
		user= new User("test", "", "", "", "");
		puser= new perimetre_user(100, 100);
		psolution=new perimetre_solution(101, 101);
		perimetre= new Perimetre(100, 100);
		
		chaine_bulletin= "1 | bul\n2 | test\n3 | Vers\n";
		chaine_bulletin1="1 | bul\n2 | test\n3 | Vers\n10 | Test\n";
		chaine_solution="5 | Je suis solution\n4 | Solution en tant que user\n3 | test id bulleint 2\n1 | Je suis solution\n";
		chaine_solution1="2 | Solution\n5 | Je suis solution\n4 | Solution en tant que user\n3 | test id bulleint 2\n1 | Je suis solution\n";
		chaine_logiciel="1 | Acrobat\n2 | Eclipse\n3 | Adobe\n4 | Android OS\n5 | Apache\n6 | Apple IOS\n7 | Chrome\n8 | Cisco\n9 | Edge\n10 | Firefox\n11 | Flash Player\n12 | Google\n13 | Java\n";
		chaine_logiciel1="1 | Acrobat\n2 | Eclipse\n3 | Adobe\n4 | Android OS\n5 | Apache\n6 | Apple IOS\n7 | Chrome\n8 | Cisco\n9 | Edge\n10 | Firefox\n11 | Flash Player\n12 | Google\n13 | Java\n14 | Logiciel\n";
		chaine_user="Emy Burgaud\nLucien O\n";
		chaine_user1="Emy Burgaud\nLucien O\ntest\n";
		chaine_mperimetre_user= "2 | 1\n" + 
				"3 | 1\n" + 
				"4 | 1\n";
		
		chaine_mperimetre_user1="2 | 1\n" + 
				"3 | 1\n" + 
				"4 | 1\n" + 
				"100 | 100\n";
		
		chaine_mperimetre_user2="2 | 1\n" + 
				"3 | 1\n" + 
				"4 | 1\n" + 
				"101 | 101\n";
		
		chaine_mperimetre="1 | 1\n" + 
				"5 | 3\n" + 
				"4 | 1\n" +
				"2 | 1\n" ;
		chaine_mperimetre1="1 | 1\n" + 
				"5 | 3\n" + 
				"4 | 1\n" + 
				"2 | 1\n" +
				"100 | 100\n";
		chaine_mpermietre_solution="9 | 8\n" + 
				"8 | 8\n" + 
				"1 | 1\n" + 
				"5 | 2\n";
		chaine_mpermietre_solution1="100 | 100\n"+
				"9 | 8\n" + 
				"8 | 8\n" + 
				"1 | 1\n" + 
				"5 | 2\n";
		
		chaine_mpermietre_solution2="101 | 101\n"+
				"9 | 8\n" + 
				"8 | 8\n" + 
				"1 | 1\n" + 
				"5 | 2\n";
	}
	
	
	@Test
	public void testModelperimetre_solution() {
		mperimetre_solution.supprimerperimetre_solution(100, 100);
		mperimetre_solution.supprimerperimetre_solution(101, 101);
		System.out.println(mperimetre_solution.toString());
		assertEquals(chaine_mpermietre_solution, mperimetre_solution.toString());
		mperimetre_solution.ajouterperimetre_solution(100, 100);
		assertEquals(chaine_mpermietre_solution1, mperimetre_solution.toString());
		mperimetre_solution.supprimerperimetre_solution(100, 100);
		mperimetre_solution.ajoutersolution(psolution);
		assertEquals(chaine_mpermietre_solution2, mperimetre_solution.toString());
		mperimetre_solution.supprimerperimetre_solution(101, 101);
		assertEquals(chaine_mpermietre_solution, mperimetre_solution.toString());
	}
	
	@Test
	public void testModelperimetre_user() {
		mperimetre_user.supprimerperimetre_user(100);
		mperimetre_user.supprimerperimetre_user(101);
		System.out.println(mperimetre_user.toString());
		assertEquals(chaine_mperimetre_user, mperimetre_user.toString());
		mperimetre_user.ajouterperimetre_user(puser);
		assertEquals(chaine_mperimetre_user1, mperimetre_user.toString());
		mperimetre_user.supprimerperimetre_user(100);
		mperimetre_user.ajouterperimetre_user(101, 101);
		assertEquals(chaine_mperimetre_user2, mperimetre_user.toString());
		mperimetre_user.supprimerperimetre_user(101);
		assertEquals(chaine_mperimetre_user, mperimetre_user.toString());
	}
	
	@Test
	public void testModelperimetre() {
		//mperimetre.supprimerPerimetre(100);
		System.out.println(mperimetre.toString());
		assertEquals(chaine_mperimetre, mperimetre.toString());
		mperimetre.ajouterPerimetre(100, 100);
		assertEquals(chaine_mperimetre1, mperimetre.toString());
		mperimetre.supprimerPerimetre(100);
		assertEquals(chaine_mperimetre, mperimetre.toString());
	}


	@Test
	public void testModel_bulletin() {
//		mbulletin.supprimerBulletin(10);
		System.out.println(mbulletin.toString());
		assertEquals(chaine_bulletin, mbulletin.toString());
		mbulletin.ajouterBulletin(bulletin);
		assertEquals(chaine_bulletin1, mbulletin.toString());
		
		assertEquals("bul", mbulletin.chercherBulletin(1).getNom_bulletin());
		mbulletin.supprimerBulletin(10);
		assertEquals(chaine_bulletin, mbulletin.toString());
		}
	
	@Test
	public void testModel_solution() {
//		msolution.supprimerSolution(2);
		System.out.println(msolution.toString());
		assertEquals(chaine_solution, msolution.toString());
		msolution.ajouterSolution(solution);
		assertEquals(chaine_solution1, msolution.toString());
		assertEquals("Je suis solution", msolution.chercherSolution(5).getDescription());;
		msolution.supprimerSolution(2);
		assertEquals(chaine_solution, msolution.toString());
	}
	
	@Test
	public void testModel_logiciel() {
		mlogiciel.supprimerLogiciels(14);
		System.out.println(mlogiciel.toString());
		assertEquals(chaine_logiciel, mlogiciel.toString());
		mlogiciel.ajouterLogiciels(logiciel);
		Long id=(long)14;
		assertEquals(chaine_logiciel1, mlogiciel.toString());
		assertEquals(id, mlogiciel.chercherIDLogiciels("Logiciel").getId_logiciel());
		assertEquals("Logiciel", mlogiciel.chercherLogiciels(14).getNom());
		mlogiciel.supprimerLogiciels(14);
		assertEquals(chaine_logiciel, mlogiciel.toString());
	}
	
	@Test
	public void testModel_user() {
//		muser.supprimerUser("test");
		System.out.println(muser.toString());
		assertEquals(chaine_user, muser.toString());
		muser.ajouterUser(user);
		assertEquals(chaine_user1, muser.toString());
		assertEquals("test", muser.chercherUser("", "").getNom());
		muser.supprimerUser("test");
		assertEquals(chaine_user, muser.toString());
	}
	

}
