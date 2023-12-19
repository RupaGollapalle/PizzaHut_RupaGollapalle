package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverClass;
import utils.UtilFunctions;

public class Hooks {
	WebDriver driver;

//
//	@BeforeAll
//	public  static void before_All() {
//		System.out.println("Before ALl");
//
//	}

//	@BeforeStep
//	public void beforeStep() {
//		System.out.println("Before Step");
//	}

	@Before
	public void beforeScenario() {

		try {
			System.out.println("\nbefore scenario");
			driver = DriverClass.getWebDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());

		} catch (ElementNotInteractableException e) {
			UtilFunctions.explicitlyWait(driver, 5);
		}catch(TimeoutException e2) {
			UtilFunctions.explicitlyWait(driver, 5);
		}
	}

	@After
	public void afterScenario() {
		driver.quit();
		System.out.println("\nAfter scenario --> Driver Closed");

	}

}
