package odevMerve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Q11 extends TestBase {


    @Test
    public void test() throws InterruptedException {
        // 1- go to url : https://demo.guru99.com/popup.php
        driver.get("https://demo.guru99.com/popup.php");

        // get the first window
        String firstWin = driver.getWindowHandle();
        Thread.sleep(2000);

        // clicking on click here button
        WebElement buttonClickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        Thread.sleep(2000);
        buttonClickHere.click();
        Thread.sleep(2000);

        // get all the window in the set
        Set<String> windowAllWindows = driver.getWindowHandles();

        // Switch to window
        for (String window : windowAllWindows) {
            driver.switchTo().window(window);

        }


        Thread.sleep(2000);

        // input email id(somepne@gmail.com) and type something in that input
        WebElement inputEmailID = driver.findElement(By.xpath("//input[@name='emailid']"));
        inputEmailID.sendKeys("somepne@gmail.com");
        Thread.sleep(2000);

        // Clicking on the submit button
        WebElement buttonSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
        buttonSubmit.click();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        // verify title as expected
        try {
            Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
            System.out.println("Title as expected"); // title as expected

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(2000);

        // String actualTitle=driver.getTitle();         ======>>>> bu sekılde de yapılabılır
        // String expectedTitle="Guru99 Bank Home Page";
        // Assert.assertEquals(actualTitle,expectedTitle);

        // switch to first window
        driver.switchTo().window(firstWin);

        System.out.println(driver.getCurrentUrl()); // https://demo.guru99.com/popup.php

    }


}