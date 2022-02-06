package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {

    @Test
    public void nutellaTesti() throws InterruptedException, IOException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        // nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER );

        //sonucların nutella ıcerdıgını test edın
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));

        String sonucSayisiStr=sonucYazisiElementi.getText();
        Assert.assertTrue(sonucSayisiStr.contains("nutella"));


        // test calısma isoatı olarak tu sayfanın screenshot ını alın


        // tum sayfa screenshot icin 4 adım gereklı

        // 1- adim TakeScreenShot onjesi olusturma

        TakesScreenshot tss=(TakesScreenshot)  driver;

        // 2- kaydedecegımız dosyayi olusturalım

        File tumSayfaSS = new File("target/screenShot/tumsayfa.png");
        //sol daki menu nun altındakı target dosyasının altına screenshot dossyası olusturdu oraya attı

        // 3- bir dosya daha olusturup screenShot objesi ile screenshot i alalim

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici resmi kaydetmek ıstedigimiz asil dosyaya copy yapalım

        FileUtils.copyFile(geciciResim, tumSayfaSS);


        Thread.sleep(5000);

    }
}
