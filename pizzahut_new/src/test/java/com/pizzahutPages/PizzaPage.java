package com.pizzahutPages;

import static utils.DriverClass.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class PizzaPage {

	public static double total_1;

	public void selectAddButtonOfRecommendedPizza() {
		try {
			Thread.sleep(800);
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[4]/div[3]/div/button/span[1]/span "))
					.click();
			System.out.println("Pizza selected");
		} catch (NoSuchElementException e) {
			System.out.println("Select pizza element not found");
		} catch (Exception e) {
			System.out.println("Pizza NOT selected");
		}
	}

	public boolean isPizzaAddedToBasket() {
		try {
			Thread.sleep(800);
			driver.findElement(By.xpath("//span[text()='1 item'] "));
			System.out.println("Pizza added to basket");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Pizza in basket element not found ");
			return false;
		} catch (Exception e) {
			System.out.println("Pizza NOT  added to basket");
			return false;
		}
	}

	public boolean validating_pizzaPrice_checkoutPrice() {
		try {

			WebElement subtotal = driver.findElement(By.xpath("//span[@class='subtotal'] "));
			WebElement tax = driver.findElement(
					By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/span[2] "));
			WebElement checkout = driver.findElement(
					By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span "));

			System.out.print("Subtotal : " + subtotal.getText().substring(1) + " ");
			System.out.print("Tax : " + tax.getText().substring(1) + " ");
			System.out.print("Restaurant Handling Charges : " + "35.0 ");
			System.out.println();
			System.out.println("Checkout price : " + checkout.getText().substring(1));

			double c1 = Double.parseDouble(checkout.getText().substring(1));
			double st = Double.parseDouble(subtotal.getText().substring(1));
			double t = Double.parseDouble(tax.getText().substring(1));

			total_1 = c1;

			if (c1 == (st + t + 35.0)) {
				System.out.println("Total = Checkout");

				return true;
			} else {
				System.out.println("Total not equal to Checkout ");
				System.out.println("- - - - - - - - - - - - - - - - - - ");
				return false;
			}

		} catch (NoSuchElementException e) {
			System.out.println("pizza price -checkout price elements not found");
			return false;
		}
	}

	public boolean checkoutContainsItems() {
		try {
			Thread.sleep(800);
			driver.findElement(
					By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[1]/span"));
			System.out.println("Item count found in checkout button");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Counter-item element not found");
			return false;
		} catch (Exception e) {
			System.out.println("Item count NOT found in checkout button");
			return false;
		}
	}

	public boolean checkoutContainsPrice() {
		try {
			Thread.sleep(800);
			driver.findElement(
					By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span "));
			System.out.println("Total price count found in checkout button");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Counter-price element not found");
			return false;
		} catch (Exception e) {
			System.out.println("Total price count NOT found in checkout button");
			return false;
		}

	}

	public void clickDrinks() {
		try {
			Thread.sleep(800);
			driver.findElement(By.xpath("//a[contains(@class,'drinks')]")).click();
			System.out.println("Clicked Drinks option");
		} catch (NoSuchElementException e) {
			System.out.println("drinks option element not found");
		} catch (Exception e) {
			System.out.println("NOT Clicked Drinks option");
		}
	}

}
