import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Schedule {
	WebDriver driver;
	
	public Schedule(WebDriver driver){
		this.driver = driver;
	}
	
	public String getScoreByDate(String date){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		By score = By.xpath("//a[contains(@href, 'sports/bsb/2016-17/releases/20170502vwpju4')]");
		wait.until(ExpectedConditions.textMatches(score, Pattern.compile(".+")));
		
		return driver.findElement(score).getText();
	}
}
