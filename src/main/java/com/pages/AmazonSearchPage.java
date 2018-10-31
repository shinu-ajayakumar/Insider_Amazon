package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchPage extends BasePage {

	public AmazonSearchPage(WebDriver driver) {
		super(driver);
	}

	public void verifyFirstResultsContainsText(int rowCount, String searchKeyword) {
		String xpath = "//*[contains(@class,'a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal') and contains(@title,'"
				+ searchKeyword + "')]";
		if (driver.findElements(By.xpath(xpath)).size() >= rowCount) {
			System.out.println("First " + rowCount + " row(s) have the search keyword");
		}
	}

	public void clickPageNavigation(int pageNumber) {
		String xpath = "//*[@class='pagnLink']/child::a[text()='" + pageNumber + "']";
		//scrollPageDown(1);
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("Navigated to Page Number : " + pageNumber);
	}

	public void verifyCurrentPageNumber(int pageNumber) {
		try {
		    WebElement date = driver.findElement(By.className("pagnCur"));
		    if (date.getText().equals(Integer.toString(pageNumber))) {
				System.out.println("Current Page Number is :" + pageNumber);
			}
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement date = driver.findElement(By.className("pagnCur"));
		    if (date.getText().equals(Integer.toString(pageNumber))) {
				System.out.println("Current Page Number is :" + pageNumber);
			}
		}		
	}

	public void clickProductAtRow(int rowNumber) {
		int i = 0;
		List<WebElement> elements = driver.findElements(By.xpath(
				"//*[contains(@class,'a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal')]"));
		for (WebElement element : elements) {
			i++;
			if (i == rowNumber) {
				String productTitle = element.getAttribute("title");
				element.click();
				System.out.println("Clicked product with title : " + productTitle);
				break;
			}
		}

	}
}
