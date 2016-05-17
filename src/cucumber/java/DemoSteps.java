import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DemoSteps {
	WebDriver driver = null;
	@Given("^I am using Firefox$")
	public void i_am_using_Firefox() throws Throwable {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I view the CSSE faculty expertise page$")
	public void i_view_the_CSSE_faculty_expertise_page() throws Throwable {
		driver.get("https://www.rose-hulman.edu/academics/academic-departments/computer-science-software-engineering/faculty-staff/faculty-expertise.aspx");
	}

	@Then("^Mark Hays should have Software testing and quality assurance listed as an area of expertise\\.$")
	public void mark_Hays_should_have_Software_testing_and_quality_assurance_listed_as_an_area_of_expertise() throws Throwable {
		assertEquals("Software testing and quality assurance", driver.findElement(By.xpath("//div[@id='content-container']/div[2]/table/tbody/tr[15]/td[2]/ul/li")).getText());
	}
	
	@After
	public void close(){
		driver.close();
	}
	
}
