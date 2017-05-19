import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoSteps {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	Schedule schedule;

	@Given("^I am using Firefox$")
	public void i_am_using_Firefox() throws Throwable {
		driver = new FirefoxDriver();
		baseUrl = "http://athletics.rose-hulman.edu/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^I load the Athletics page$")
	public void i_load_the_Athletics_page() throws Throwable {
		driver.get(baseUrl + "/landing/index");
	}

	@When("^I load the Baseball (\\d+) schedule$")
	public void i_load_the_Baseball_schedule(int arg1) throws Throwable {
		BaseballMenu baseball = new SportsMenu(driver).navigateToBaseballMenu();
		this.schedule = baseball.navigateToSchedule();
	}

	@Then("^the scheduleshould say that the team won (\\d+)-(\\d+) on May (\\d+)nd$")
	public void the_scheduleshould_say_that_the_team_won_on_May_nd(int arg1, int arg2, int arg3) throws Throwable {

		String actualScore = this.schedule.getScoreByDate("20170502");
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
}
