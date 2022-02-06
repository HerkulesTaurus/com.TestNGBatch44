package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q2 {

// birbirine bagimli testler olusturun..
// .beforClass olusturup setUp ayarlarini yapin..

WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //  birbirine bagimli testler olusturarak;
    //  3- daha sonra google a bagimli olarak amazon a gidin

    @Test (dependsOnMethods = "googleTest")
    public void amazaontest(){
        driver.get("https://www.amazon.com/");
    }

    //  2- sonra facebook a bagimli olarak google a gidin,
    @Test (dependsOnMethods = "facebookTest")
    public void googleTest(){
        driver.get("https://www.google.com/");
    }

    //  1- ilk once facebook a gidin
    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com/");
    }


    // driver i kapatin

    @AfterClass
    public void tearDown(){
        driver.close();
}




}
