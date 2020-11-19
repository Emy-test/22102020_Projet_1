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
//public class Projet1userTest {
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
//  public void projet1user() {
//    driver.get("http://localhost:8085/22102020_Projet_1/");
//    driver.manage().window().setSize(new Dimension(945, 1140));
//    driver.findElement(By.name("login")).click();
//    driver.findElement(By.name("login")).sendKeys("emy");
//    driver.findElement(By.name("pwd")).sendKeys("emy");
//    driver.findElement(By.cssSelector("td:nth-child(1) > input")).click();
//    driver.findElement(By.linkText("Liste bulletin")).click();
//    {
//      List<WebElement> elements = driver.findElements(By.linkText("Bulletin"));
//      assert(elements.size() > 0);
//    }
//    driver.findElement(By.linkText("Bulletin")).click();
//    driver.findElement(By.linkText("Retour liste logiciels")).click();
//    {
//      List<WebElement> elements = driver.findElements(By.linkText("Retour"));
//      assert(elements.size() > 0);
//    }
//    driver.findElement(By.linkText("Retour")).click();
//    {
//      List<WebElement> elements = driver.findElements(By.linkText("Liste de vos perimetres"));
//      assert(elements.size() > 0);
//    }
//    driver.findElement(By.linkText("Liste de vos perimetres")).click();
//   
//    //Le texte commenté fonctionne mais ajoute un perimetre donc il est commenté pour ne pas modifier mes tests unitaires
//    
////    driver.findElement(By.linkText("Ajouter un perimetre")).click();
////    driver.findElement(By.name("nom")).click();
////    {
////      WebElement dropdown = driver.findElement(By.name("nom"));
////      dropdown.findElement(By.xpath("//option[. = 'Edge']")).click();
////    }
////    driver.findElement(By.name("nom")).click();
////    driver.findElement(By.cssSelector("input")).click();
//    
//    driver.findElement(By.linkText("Retour")).click();
//    {
//      List<WebElement> elements = driver.findElements(By.linkText("Se déconnecter..."));
//      //assert(elements.size() > 0);
//    }
//    driver.findElement(By.linkText("Se déconnecter...")).click();
//  }
//}
