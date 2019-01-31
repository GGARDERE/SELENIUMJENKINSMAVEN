package premierTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class TestSeleniumTest {
	
	private WebDriver driver;
 
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @SuppressWarnings("deprecation")
@Before
  public void setUp() throws Exception {
	 String toto="chrome";
	 
	if(toto=="IE")
		{
		 File file = new File("C:/DriverAutomatisation/IEDriverServer_Win32_3.14.0/IEDriverServer.exe");
	        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	        driver = new InternetExplorerDriver();
		}
	else if(toto=="chrome")
		{
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver2_43/chromedriver.exe");
		driver = new ChromeDriver();
		}
	else if(toto=="FF")
		{

       String geckoDriverPath = "C:/geckoDriver/geckodriver-v0.24.0-win64/geckodriver.exe";
       System.setProperty("webdriver.gecko.driver",geckoDriverPath);
      //  System.setProperty("webdriver.firefox.marionette", geckoDriverPath);
       driver = new FirefoxDriver();
        // pour firefox

	//	 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	//	 capabilities.setCapability("marionette", true);
		// driver = new FirefoxDriver(capabilities);
		 
	//			System.setProperty("webdriver.gecko.driver", "C:/geckoDriver/geckodriver-v0.24.0-win64/geckodriver.exe");
		//driver = new FirefoxDriver();
		
		}
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   	driver.manage().window().maximize();
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.google.fr/search?q=education+nationale&rlz=1C1GCEA_enFR781FR781&oq=education+nationale&aqs=chrome..69i57j0l5.6091j1j8&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.cssSelector("h3.LC20lb")).click();
    
    driver.findElement(By.xpath("//li[@id='nav_menu_2']/a/span")).click();
    driver.findElement(By.linkText("L'école élémentaire en pratique")).click();
    driver.findElement(By.linkText("Le règlement intérieur à l'école")).click();
    driver.findElement(By.xpath("//li[@id='nav_menu_3']/a/span")).click();
    driver.findElement(By.linkText("Le parcours Avenir")).click();
    driver.findElement(By.xpath("//li[@id='nav_menu_4']/a/span")).click();
    driver.findElement(By.linkText("Les enseignements de première et de terminale du lycée général et technologique")).click();
    driver.findElement(By.linkText("La voie générale")).click();
    driver.findElement(By.linkText("Concours général")).click();
    driver.findElement(By.xpath("//li[@id='nav_menu_1']/a/span")).click();
    driver.findElement(By.linkText("L'école élémentaire")).click();
    driver.findElement(By.linkText("Les dispositifs d'accompagnement pour les écoliers")).click();
    driver.quit();
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
