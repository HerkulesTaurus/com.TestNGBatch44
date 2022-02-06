package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q5_Iframe {

    //*************** odev ***************
    // soru :ingilizce

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    // web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
    // maximize the window
    // pencereyi büyüt

    @Test
    public void test(){
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        driver.manage().window().maximize();

        // click on action dialog button
        // if need use explicitly wait
        // eylem diyalog düğmesine tıklayın
        // kullanmanız gerekiyorsa açıkça bekleyin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-warning']"))).click();

        // click on the ok button
        // tamam butonuna tıklayın
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dialog-mycodemyway-action']"))).click();

        // accept the iframe message
        // iframe mesajını kabul et
        driver.switchTo().alert().accept();

    }

    @AfterClass
    public void tearDown(){
    driver.close();
    }
}
