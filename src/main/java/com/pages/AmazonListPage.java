package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonListPage extends BasePage {
	
	String productName;

	public AmazonListPage(WebDriver driver) {
		super(driver);
	}

	public void clickFirstList() {
		driver.findElement(By.xpath("//*[contains(@id,'wl-list-title')][1]")).click();
	}

	public void verifyFirstProduct() {
		productName = driver.findElement(By.xpath("//a[contains(@id,'itemName') and contains(@class,'a-link-normal')]")).getText();
		driver.findElement(By.xpath("//a[contains(@id,'itemName') and contains(@class,'a-link-normal')]")).getText()
				.toLowerCase().contains("Samsung");
		System.out.println("Verified product ' " + productName + " ' is shown list");
	}

	public void deleteLastAddedItem() {
		driver.findElement(By.xpath("//*[@class='a-link-normal a-declarative g-visible-js']")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("Product ' " + productName + " ' is deleted from list");
	}

	public void verifyAddedLastItemDeleted() {
		driver.findElement(By.xpath("//*[contains(@class,'a-alert-content') and contains(text(),'Deleted')]"))
				.isDisplayed();		
		System.out.println("Verified product ' " + productName + " ' is deleted from List");
	}
}
