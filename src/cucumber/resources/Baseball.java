import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseball {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://athletics.rose-hulman.edu/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaseball() throws Exception {
    driver.get(baseUrl + "/landing/index");
    
    Actions moveMouse = new Actions(driver);
    moveMouse.moveToElement(driver.findElement(By.linkText("Sports")));
    moveMouse.build().perform();
    
    driver.findElement(By.linkText("Baseball")).click();
    driver.findElement(By.linkText("2017 Schedule/Results")).click();
    
		WebDriverWait wait = new WebDriverWait(driver, 30);
		By score = By.xpath("//a[contains(@href, 'sports/bsb/2016-17/releases/20170502vwpju4')]");
		wait.until(ExpectedConditions.textMatches(score, Pattern.compile(".+")));
		String actualScore = driver.findElement(score).getText();
		Assert.assertEquals("W, 11-2", actualScore);
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
