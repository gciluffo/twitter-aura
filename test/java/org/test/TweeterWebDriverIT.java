package org.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Verify app loads using WebDriver
 */
public class TweeterWebDriverIT {
	
    @Test
    public void TwitterTests() throws Exception {
		WebDriver driver =  new FirefoxDriver();

    	try {
			driver.get("http://localhost:8080/Twitter/homepage.app");

			String testText = "Silenium";
			// Wait for text box to load
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea")));
			driver.findElement(By.cssSelector("textarea")).sendKeys(testText);
			// Clicks the first button it finds
			driver.findElement(By.cssSelector("button")).click();
			// Check that something was tweeted
			Assert.assertEquals("Silenium", driver.findElement(By.cssSelector("div.panel-body")).getText());


			// Press the cleanup button
			driver.findElement(By.cssSelector("div.clean button")).click();

			// Validate initial state
			//Assert.assertEquals("What is you thinking", driver.findElement(By.cssSelector(".uiInputTextArea")).getText());
			
			//
			//driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".uiOutputText"), testText));
    	} finally {
			driver.close();
    	}
    }
}