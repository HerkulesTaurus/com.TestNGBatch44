package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        // driver.get("https://the-internet.herokuapp.com/upload");

        // driver.findElement(By.id("file-submit")).click();

        // driver.get("https://www.youtube.com");
        // driver.findElement(By.xpath("//yt-formatted-string[text()='I Agree']")).click();

        // driver.get("https://www.techproeducation.com");
        // driver.findElement(By.xpath("(//a[text()='info@techproeducation.com'])[2]")).click();

        // https://the-internet.herokuapp.com/dynamic_controls  sayfasine gidin
        // disabled butonuna basin
        // disabled yazisinin ciktigini test edin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        // Thread.sleep(3000); // hard wait bekleme
        // implicitlwait dynamic wait dir ise gore kendını ayarlar parantez ıcındekı deger max degerı belirtir

        WebElement itsDisabledYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsDisabledYaziElementi.isDisplayed());


     }
}
