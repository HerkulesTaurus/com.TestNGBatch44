package tests.day14;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_ScreenShot extends TestBase {

    @Test
    public void screenTest() throws IOException {

        driver.get("https://www.google.com");

        // tum sayfanın screenShot'ini almak ıstıyorsak
        // 1. adim : screenshot almak icin obje olusturalım ve deger olarak driver imizi atayalim
        //     deger olarak driver i kabul etmesi icin casting yapmamız gerekir

        TakesScreenshot tss = (TakesScreenshot) driver;


        // 2. adim : Tum sayfanın screenshot ini almak icin bir File olusturalim ve dosya yolunu belirtelim

        File tumSayfaSS = new File("src//tumSayfa.png");


        // 3. adim : Olusturdugumuz file ile takescreenshot objesini iliskilendirelim

        tumSayfaSS=tss.getScreenshotAs(OutputType.FILE);

        // spesific elementin screenshot ini almak ıstıyorsanız


        WebElement logoElementi=driver.findElement(By.xpath("//img[@id='hplogo']"));

        File logoResmi = new File("src/logo.png");

        logoResmi=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

      //  FileUtils.copyFile(scrFile, new File("src\\screenshot.png"));

    }
}
