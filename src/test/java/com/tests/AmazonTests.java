package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pages.AmazonHomePage;
import com.pages.AmazonLandingePage;
import com.pages.AmazonListPage;
import com.pages.AmazonLoginPage;
import com.pages.AmazonProductPage;
import com.pages.AmazonSearchPage;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTests {

	@Test
	public void AmazonTest() {
		WebDriver driver;
	
		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		driver = new ChromeDriver();
		//driver.get("https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=Samsung");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		System.out.println("Launched Chrome Browser");

		AmazonLandingePage amazonLandingePage = new AmazonLandingePage(driver);
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		AmazonLoginPage amazonLoginPage = new AmazonLoginPage(driver);
		AmazonSearchPage amazonSearchPage = new AmazonSearchPage(driver);
		AmazonProductPage amazonProductPage = new AmazonProductPage(driver);
		AmazonListPage amazonListPage = new AmazonListPage(driver);

		amazonLandingePage.navigateToAmazon();
		amazonLandingePage.VerifyPageTitle();
		amazonLandingePage.clickSignIn();
		amazonLoginPage.enterEmailAndPassword("","").clickSignIn();
		amazonHomePage.verifyUserNameDisplayedinHeader("shinu");
		amazonHomePage.verifyBrowsingHistoryLinkShown();
		amazonHomePage.searchFor("Samsung");
		
		amazonSearchPage.verifyFirstResultsContainsText(4,"Samsung");
		amazonSearchPage.clickPageNavigation(2);
		amazonSearchPage.verifyCurrentPageNumber(2);
		amazonSearchPage.clickProductAtRow(3);
		amazonProductPage.clickAddToList();
		amazonHomePage.clickList();
		amazonListPage.clickFirstList();
		amazonListPage.verifyFirstProduct();
		amazonListPage.deleteLastAddedItem();
		amazonListPage.verifyAddedLastItemDeleted();
		
	
	}

}
