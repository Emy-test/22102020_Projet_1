//package seleniumTest;
//
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import java.util.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//public class Projet1_admin_ajout_suppression_bulletinTest {
//  private WebDriver driver;
//  private Map<String, Object> vars;
//  JavascriptExecutor js;
//  @Before
//  public void setUp() throws MalformedURLException {
////    driver = new ChromeDriver();
////    js = (JavascriptExecutor) driver;
////    vars = new HashMap<String, Object>();
//	  driver = new RemoteWebDriver(new java.net.URL("http://localhost:9515"), new ChromeOptions());
//	  js = (JavascriptExecutor) driver;
//	  vars = new HashMap<String, Object>();
//  }
//  @After
//  public void tearDown() {
//    driver.quit();
//  }
//  @Test
//  public void projet1adminajoutbulletin() {
//    driver.get("http://localhost:8085/22102020_Projet_1/");
//    driver.manage().window().setSize(new Dimension(944, 725));
//    driver.findElement(By.name("login")).click();
//    driver.findElement(By.name("login")).sendKeys("lucien");
//    driver.findElement(By.name("pwd")).click();
//    driver.findElement(By.name("pwd")).sendKeys("lucien");
//    driver.findElement(By.cssSelector("td:nth-child(1) > input")).click();
//    {
//      List<WebElement> elements = driver.findElements(By.linkText("Liste des bulletins"));
//      assert(elements.size() > 0);
//    }
//    driver.findElement(By.linkText("Liste des bulletins")).click();
//    driver.findElement(By.linkText("Ajouter un bulletin")).click();
//    driver.findElement(By.name("id")).click();
//    driver.findElement(By.name("id")).sendKeys("200");
//    driver.findElement(By.name("nom_bulletin")).click();
//    driver.findElement(By.name("nom_bulletin")).click();
//    driver.findElement(By.name("nom_bulletin")).click();
//    {
//      WebElement element = driver.findElement(By.name("nom_bulletin"));
//      Actions builder = new Actions(driver);
//      builder.doubleClick(element).perform();
//    }
//    driver.findElement(By.name("nom_bulletin")).sendKeys("Selenium");
//    driver.findElement(By.cssSelector("fieldset")).click();
//    driver.findElement(By.name("synthese")).click();
//    driver.findElement(By.name("synthese")).sendKeys("Selenium");
//    driver.findElement(By.cssSelector("fieldset")).click();
//    driver.findElement(By.name("date")).click();
//    driver.findElement(By.name("date")).sendKeys("Selenium");
//    driver.findElement(By.name("reference_bulletin")).sendKeys("Selenium");
//    driver.findElement(By.name("priorite")).sendKeys("Selenium");
//    driver.findElement(By.name("description")).sendKeys("Selenium");
//    driver.findElement(By.name("references_liees_bulletin")).click();
//    driver.findElement(By.name("references_liees_bulletin")).sendKeys("Selenium");
//    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
//    driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(7) a")).click();
//    driver.findElement(By.linkText("Supprimer ce bulletin")).click();
//  }
//}
