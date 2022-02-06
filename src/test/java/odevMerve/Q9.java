package odevMerve;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.security.Key;

public class Q9 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@href='#'])[4]")).click();


        // 3- Ad, soyad, mail ve sifre kutularına deger yazalim ve kaydol tusuna basalim
        WebElement ad=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.click(ad).
                sendKeys("Zeda").
                sendKeys(Keys.TAB).
                sendKeys("Zengoc").
                sendKeys(Keys.TAB).
                sendKeys("zonkac@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("zonkac@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("Zoajods21.").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("5").
                sendKeys("H").
                sendKeys("1990").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        // 4- Kaydol tusuna basın
        WebElement kaydolButonElementi=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        actions.click(kaydolButonElementi).perform();
        Thread.sleep(1500);

    }


}
