package odevMerve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q10 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test(){
        // 1- "https://www.automationpractice.com/" adresine gidin
        driver.get("https://www.automationpractice.com/");

        // 2- 2. Urunun uzerıne gelip add to chart yapın
        driver.findElement(By.xpath("//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]/span"));

        // 3- 4. Urunun uzerıne gelip add to chart yapın

        // 4- 5. Urunun uzerıne gelip add to chart yapın

        // 5- Chart a gelin 3 urun oldugnu dogrulayın

        // 6- Chart a gelip Check out tıklayın

        // 7- Toplam alisveris miktarinin 108.97 oldugnuu dogrulayin
    }

    @AfterClass
    public void teardown(){
        //driver.quit();
    }

}
