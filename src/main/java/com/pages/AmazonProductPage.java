package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage extends BasePage {

	public AmazonProductPage(WebDriver driver) {
		super(driver);
	}

	public void clickAddToList() {
		try {
			driver.findElement(By.id("add-to-wishlist-button-submit")).isDisplayed();
			String productTitle = driver.findElement(By.id("productTitle")).getText();
			driver.findElement(By.id("add-to-wishlist-button-submit")).click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			String newListName = driver.findElement(By.xpath("//input[@name='create-name']")).getAttribute("value").toString();
			driver.findElement(By.xpath(
					"//input[@class='a-button-input a-declarative']/following-sibling::span[text()='Create List']/preceding-sibling::input"))
					.click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@class='a-button-text' and text()='Continue shopping']")).click();
			System.out.println("Added product ' " + productTitle + " ' to list ' " + newListName + " '");
			return;
		} catch (Exception e) {

		}
		try {
			driver.findElement(By.xpath("//input[@value='Add to List']")).isDisplayed();
			String productTitle = driver.findElement(By.xpath("//span[@class='a-size-large a-text-bold']")).getText();
			driver.findElement(By.xpath("//input[@value='Add to List']")).click();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			String newListName = driver.findElement(By.xpath("//input[@class='inputBox']")).getAttribute("value").toString();
			driver.findElement(By.xpath("//input[@alt='Create a List']")).click();
			System.out.println("Added product ' " + productTitle + " ' to list ' " + newListName + " '");
			return;
		} catch (Exception e) {

		}
	}
}
