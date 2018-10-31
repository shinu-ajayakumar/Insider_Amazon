package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage extends BasePage {

	public AmazonHomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyUserNameDisplayedinHeader(String userName) {
		driver.findElement(By.xpath("//*[@id='nav-link-accountList']/child::span[1]")).getText().toLowerCase()
				.contains(userName);
	}

	public void verifyBrowsingHistoryLinkShown() {
		try {
			driver.findElement(By.id("nav-recently-viewed")).isDisplayed();
		} catch (Exception e) {
			System.out.println("Browser History Link Not Shown");
			System.out.println("Exception thrown : " + e.getStackTrace().toString());
			System.out.println("Exception thrown : " + e.getMessage().toString());
		}
	}

	public void searchFor(String searchKeyword) {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(searchKeyword);
		clickSearchButton();
	}

	private void clickSearchButton() {
		driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input[1]")).click();
		System.out.println("Clicked Search Button");
	}

	public void clickList() {
		action = new Actions(driver);
		wait = new WebDriverWait(driver,10);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='nav-flyout-wl-items']/div/a/span")));
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-flyout-wl-items']/div/a/span")));
		action.click().build().perform();	
	}
}
