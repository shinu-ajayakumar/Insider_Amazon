package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonLandingePage extends BasePage {

	public AmazonLandingePage(WebDriver driver) {
		super(driver);
	}

	public void navigateToAmazon() {
		driver.get("https://www.amazon.com/");
		System.out.println("Navigated to page with Title : " + driver.getTitle());
		System.out.println("Page Url is : " + driver.getCurrentUrl());
	}

	public void VerifyPageTitle() {
		driver.getCurrentUrl().contains("Amazon.com");
	}

	public void clickSignIn() {
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList")));
		action.click().build().perform();
		/*
		 * driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 * action.moveToElement(driver.findElement(By.cssSelector(
		 * "span.nav-action-inner"))); action.click().build().perform();
		 */
		System.out.println("Clicked SignIn Button");
	}

}
