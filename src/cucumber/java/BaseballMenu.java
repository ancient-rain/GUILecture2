import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseballMenu {
	WebDriver driver;

	public BaseballMenu(WebDriver driver) {
		this.driver = driver;
	}

	public Schedule navigateToSchedule() {
		driver.findElement(By.linkText("2017 Schedule/Results")).click();

		return new Schedule(driver);
	}

}
