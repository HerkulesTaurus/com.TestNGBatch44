package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebElement extends TestBase {

    @Test
            public void test02() throws IOException, InterruptedException {
    // amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

    // nutella icin arama yapin
    WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("nutella"+Keys.ENTER );

    //sonucların nutella ıcerdıgını test edın
    WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
    String sonucSayisiStr = sonucYazisiElementi.getText();
    Assert.assertTrue(sonucSayisiStr.contains("nutella"));

    // test calısma isoatı olarak tu sayfanın screenshot ını alın

    // tum sayfa screenshot icin 4 adım gereklı

    // 1- adim ScreenShot cekecegımız webelementi locate edelim

    // 2- adim screenshot i kaydedecegimiz bir file olusturalım
    File webelementSS=new File("target/screenShot/webelement.jpeg");

    // 3- adim
    File geciciResim = sonucYazisiElementi.getScreenshotAs(OutputType.FILE);

    // 4- gecici resmi kaydetmek ıstedigimiz asil dosyaya copy yapalım
    FileUtils.copyFile(geciciResim,webelementSS);

        Thread.sleep(5000);
}
}
