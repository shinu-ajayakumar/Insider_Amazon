package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLoginPage extends BasePage {

	public AmazonLoginPage(WebDriver driver) {
		super(driver);
	}

	public AmazonLoginPage enterEmailAndPassword(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		return this;

	}

	private void enterPassword(String password) {
		setElementText(driver.findElement(By.id("ap_password")), password);
		String fieldLabel = driver.findElement(By.xpath("//label[@for='ap_password']")).getText();
		System.out.println("Entered " + password + " in " + fieldLabel + " field");
	}

	private void enterEmail(String email) {
		setElementText(driver.findElement(By.id("ap_email")), email);
		String fieldLabel = driver.findElement(By.xpath("//label[@for='ap_email']")).getText();
		System.out.println("Entered " + email + " in " + fieldLabel + " field");
	}

	public void clickSignIn() {
		clickElement(driver.findElement(By.id("signInSubmit")));
		String buttonLabel = driver.findElement(By.xpath("//span[@class='a-button-text']")).getText().trim();
		System.out.println("Clicked " + buttonLabel + " button");
	}

}
