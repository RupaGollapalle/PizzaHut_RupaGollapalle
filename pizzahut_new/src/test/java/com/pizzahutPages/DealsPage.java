package com.pizzahutPages;

import static utils.DriverClass.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import utils.UtilFunctions;

public class DealsPage {

	public void inDealsPage() {

		// UtilFunctions.explicitlyWait(driver,By.xpath("//span[text()='Deals']"),3);

		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@href='/order/deals/'] [contains(@aria-current,\"page\")]"));
			System.out.println("On Deals page ");

		} catch (NoSuchElementException e) {
			System.out.println("Deals page element not found");
		} catch (Exception e) {
			System.out.println("NOT on Deals page ");
		}
	}

	public boolean isVegetarianRadioButtonOff() {
		// Implementation for checking if the vegetarian radio button is off

		UtilFunctions.explicitlyWait(driver, By.xpath("//div[@role='button']/*[contains(@class,'bg-grey-light')]"), 3);
		try {
			// Thread.sleep(800);
			driver.findElement(By.xpath("//div[@role='button']/*[contains(@class,'bg-grey-light')]"));
			System.out.println("Vegetarian radio button flag found and is OFF");

			return true;

		} catch (NoSuchElementException e) {
			System.out.println("Vegetarian radio button flag not found");
			return false;
		}
//        catch(Exception e){
//            System.out.println("veg radio  - Exception");
//            return false;
//        }
	}

	public void clickPizzasMenuBar() {
		// Implementation for clicking on the Pizzas menu bar option

		try {
			Thread.sleep(800);
			driver.findElement(By.xpath("//a[contains(@class,'pizza')] ")).click();
			System.out.println("Pizza page opened");
		} catch (NoSuchElementException e) {
			System.out.println("pizza page element not founded");
		} catch (Exception e) {
			System.out.println("pizza page NOT opened");
		}
	}

}
