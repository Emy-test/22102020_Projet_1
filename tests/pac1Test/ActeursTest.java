package pac1Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import package1.Bulletin;
import package1.Logiciels;
import package1.Perimetre;
import package1.Solution;
import package1.User;

public class ActeursTest {
	public static Logiciels logiciel;
	public static User user;
	public static Bulletin bulletin;
	public static Solution solution;
	public static Perimetre perimetre;
	public static package1.perimetre_user perimetre_user;
	public static package1.perimetre_solution perimetre_solution;

	@BeforeClass
	public static void init() {
		logiciel=new Logiciels();
		bulletin = new Bulletin();
		solution = new Solution();
		user= new User();
		perimetre= new Perimetre();
		perimetre_user= new package1.perimetre_user();
	}

	@Test
	public void testLogiciel() {
		
		logiciel.setId_logiciel((long) 1);
		logiciel.setNom("Java");
		System.out.println(logiciel.getNom());
		Long i=(long) 1;
		assertEquals(i, logiciel.getId_logiciel());
		assertEquals("Java", logiciel.getNom());
		}
	
	@Test
	public void testBulletin()  {
		bulletin.setDate("17112020");
		bulletin.setDescription("Test");
		bulletin.setId(2);
		bulletin.setNom_bulletin("Erreur");
		bulletin.setPriorite("Haute");
		bulletin.setReference_bulletin("C12");
		bulletin.setReferences_liees_bulletin("references");
		bulletin.setSynthese("Synthese");
		assertEquals("17112020", bulletin.getDate());
		assertEquals("Test", bulletin.getDescription());
		assertEquals(2, bulletin.getId());
		assertEquals("Erreur", bulletin.getNom_bulletin());
		assertEquals("Haute", bulletin.getPriorite());
		assertEquals("C12", bulletin.getReference_bulletin());
		assertEquals("references", bulletin.getReferences_liees_bulletin());
	}
	
	@Test
	public void testSolution() {
		solution.setId_bulletin(1);
		solution.setId_solution(1);
		solution.setDescription("Solution");
		assertEquals(1, solution.getId_bulletin());
		assertEquals(1, solution.getId_solution());
		assertEquals("Solution", solution.getDescription());
	}
	
	@Test
	public void testUser(){
		user.setId(5);
		assertEquals(5, user.getId());
	}
	
	@Test
	public void testPerimetre(){
		perimetre.setId(100);
		assertEquals(100, perimetre.getId());
	}
	
}
