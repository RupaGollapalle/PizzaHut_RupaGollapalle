package com.pizzahutPages;

import static utils.DriverClass.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DrinksPage {
	double total_2;

	public void addPepsi() {
		try {
			Thread.sleep(800);
			driver.findElement(By.xpath("//button[contains(@data-synth, 'pepsi-600ml')]")).click();
			System.out.println("Added pepsi 600 ML");
		} catch (NoSuchElementException e) {
			System.out.println("Add-pepsi element not found");
		} catch (Exception e) {
			System.out.println("NOT added pepsi 600 ML");
		}

	}

	public boolean twoItemsInCheckoutButton() {
		try {
			driver.findElement(By.xpath("//span[text()='2 items'] "));
			System.out.println("2-items found in checkout button");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("2-items element not found");
			return false;

		}

	}

	public boolean totalPriceIsMoreThanBefore() {
		try {
			Thread.sleep(800);

			WebElement checkout = driver.findElement(
					By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span "));

			System.out.print("Current price : " + checkout.getText().substring(1) + " & ");
			System.out.print("Previous price : " + PizzaPage.total_1);
			System.out.println();

			double c1 = Double.parseDouble(checkout.getText().substring(1));
			total_2 = c1;

			if (c1 > PizzaPage.total_1) {
				System.out.println("Current price is more than previous");
				return true;
			} else {
				System.out.println("Current price is less than previous ");
				return false;
			}

		} catch (NoSuchElementException e) {
			System.out.println("For Comparing,checkout element for 2-items not found");
			return false;
		} catch (Exception e) {
			System.out.println("Checkout-2 price not executed");
			return false;
		}
	}

	public void removePizza() {

		try {
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/div[1]/div[3]/div/div[1]/button[2] "))
					.click();
			System.out.println("Removed pizza");
		} catch (NoSuchElementException e) {
			System.out.println("Removed pizza element NOT found");
		}

	}

	public boolean priceTagRemovedFromCheckout() {
		try {

			driver.findElement(
					By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span "));

			System.out.println("Price Tag Found ");
			return true;

		} catch (NoSuchElementException e) {
			System.out.println("Price Tag element NOT Found");
			return false;
		}
	}

	public boolean itemsInCheckoutISOne() {

		try {
			Thread.sleep(800);
			driver.findElement(By.xpath("//span[text()='1 item'] "));
			System.out.println("Items in checkout button is ONE");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("1-item element NOT found ");
			return false;
		} catch (Exception e) {
			System.out.println("Items in checkout button is NOT ONE");
			return false;
		}
	}

	public void clickCheckout() {

		try {
			Thread.sleep(800);
			driver.findElement(By.xpath("//div[@class='basket-checkout'] ")).click();
			System.out.println("Clicked checkout button");
		} catch (NoSuchElementException e) {
			System.out.println("Checkout button element not found");
		} catch (Exception e) {
			System.out.println("NOT Clicked checkout button");
			;
		}
	}

	public boolean minOrderPopupDisplays() {
		try {
			driver.findElement(By.xpath("//span[text()='Continue Shopping']"));
			System.out.println("Minimum order popup appeared");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Minimum order popup NOT appeared");
		}
		return false;
	}

}
