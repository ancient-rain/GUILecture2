import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SportsMenu {
	WebDriver driver;

	public SportsMenu(WebDriver driver){
		this.driver = driver;
	}
	
	public BaseballMenu navigateToBaseballMenu(){
		Actions moveMouse = new Actions(driver);
		moveMouse.moveToElement(driver.findElement(By.linkText("Sports")));
		moveMouse.build().perform();

		driver.findElement(By.linkText("Baseball")).click();
		
		return new BaseballMenu(driver);
	}
}
