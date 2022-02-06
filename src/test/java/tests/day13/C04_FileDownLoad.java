package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownLoad extends TestBase {

    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )

    @Test
    public void isExistTesti() throws InterruptedException {
        String dosyaYolu=System.getProperty("user.home") + "\\Downloads\\sample.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void downLoadTesti() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[.='sample.png']")).click();
        Thread.sleep(5000);
    }
}

