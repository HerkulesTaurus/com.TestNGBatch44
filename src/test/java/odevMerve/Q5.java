package odevMerve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q5 {

    // @BeforClass ın ıcınde driver i kuralım
    // maximize edip tum web elementler yuklenene kadar 10 sn bekleyelım
    static  WebDriver driver;
    @BeforeClass
    static public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //=======>>>>> iceriyor testi assert le de yapılabılır if le de <<<<<<<<<<<<<<========
    // Google a gidelim sayfa baslıgını google ıcerdıgını dgorulayalım
    @Test
    public void googleTest(){
    driver.navigate().to("https://www.google.com");
    String pageTitle="Google";
    Assert.assertTrue(driver.getTitle().contains(pageTitle), "Page Title doesnt contain 'Google'");
    }

    //=======>>>>> iceriyor testi assert le de yapılabılır if le de <<<<<<<<<<<<<<========
    // Amazon a gidelim ve url in www.amazon.com icerdigini kontrol edelim
    @Test
    public void amazonTest(){
        driver.navigate().to("https://www.amazon.com");

        String actualTitle=driver.getTitle();
        String expectedTitle="www.amazon.com";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("iceriyor");
        }else{
            System.out.println("icermiyor");
        }
    }


    // @AfterClass ta driver i kapatalım
    @AfterClass
    public void teardown(){
        driver.quit();

    }
}
