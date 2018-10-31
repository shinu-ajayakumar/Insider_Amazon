package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class BasePage {

	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void setElementText(WebElement elementName, String elementText) {
		waitForElementVisible(elementName);
		elementName.clear();
		elementName.sendKeys(elementText);
	}

	private void waitForElementVisible(WebElement elementName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(elementName));
	}

	protected void clickElement(WebElement elementName) {
		waitForElementVisible(elementName);
		elementName.click();
	}

	protected void scrollPageDown(int scrollCount) {
		for (int i = 0; i <= scrollCount; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}
