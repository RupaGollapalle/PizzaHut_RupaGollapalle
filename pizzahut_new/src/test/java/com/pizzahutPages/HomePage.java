package com.pizzahutPages;

import static utils.DriverClass.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import utils.UtilFunctions;

public class HomePage {

	public void openPizzaHutWebsite(String url) {
		
		try{ driver.get(url); }
		
		catch (ElementNotInteractableException e) {
			UtilFunctions.explicitlyWait(driver, 5);
		}catch(TimeoutException e2) {
			UtilFunctions.explicitlyWait(driver, 5);
		}
	}

//    public void waitForLocationPopup() {
//        // Implementation for waiting logic
//    }
//
//    public void closeLocationPopup() {
//        // Implementation for closing the popup
//    }

	public void userFindsLocation() {

		try {
			driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		} catch (NoSuchElementException e) {
			System.out.println("enter location element not found");
		}catch (ElementNotInteractableException e) {
			UtilFunctions.explicitlyWait(driver, 5);
		}catch(TimeoutException e2) {
			UtilFunctions.explicitlyWait(driver, 5);
		}

	}

	public void enterLocation(String location) {
		UtilFunctions.explicitlyWait(driver, 2);
		driver.findElement(By.xpath(" //input[@placeholder='Enter your location for delivery'] ")).sendKeys(location);
	}

	public void selectAutoPopulateOption() {

		try {
			Thread.sleep(1000);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
		} catch (Exception e) {
			System.out.println("Failed to select location");
		}

		UtilFunctions.explicitlyWait(driver, By.xpath(" /html/body/div[8]/div/div/div[2]/div[2]/button "), 5);

		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath(" /html/body/div[8]/div/div/div[2]/div[2]/button")).click();
		} catch (NoSuchElementException e) {
			System.out.println("No second popup appeared");
		} catch (Exception e) {
			System.out.println("No second popup appeared ");
			System.out.println("- - - - - - - - - - - - - - - - - - ");
		}

	}
}
