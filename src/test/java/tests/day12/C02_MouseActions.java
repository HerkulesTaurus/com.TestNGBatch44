package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {

    @Test
    public void amazonList() throws InterruptedException {

        // amzon sayfasına gıdın
        // sag ustte hello signin elementinin userinde mouse u bekletin
        // acılan menu de new list linkine tiklayin
        // ve new list sayfasinin acildigini test edin

        driver.get("https://www.amazon.com");
            Actions actions=new Actions(driver);
           // WebElement helloElement=driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]")); bulamadi
            WebElement helloElement=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
            actions.moveToElement(helloElement).perform();

            WebElement listElementi=driver.findElement(By.xpath("//span[@class='nav-text'][1]"));
            actions.click(listElementi).perform();

            // ve new list sayfasinin acildigini test edin
            // sag ustte hello, signIn elementinin uzerınde mouse u bekletin
            // acilan menude new list linkine tiklayin

            String actualTitle=driver.getTitle();
            String arananMetin="Your List";

            Assert.assertTrue(actualTitle.contains(arananMetin));
            Thread.sleep(3000);

        }
}