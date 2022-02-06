package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_IFrame{


    WebDriver driver;
    @BeforeClass
    public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //1. Bir class olusturun:IframeTest
    @Test
    public void iframetesti(){

        //2. Https://the-internet.herokuapp.com/iframe sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/iframe");


        //3. Bir method olusturun :iframeTest
        //          => "An IFrame containing..." textinin erisilebilir oldugunu test edin ve konsolda yazdirin
        WebElement IstenenYaziElementi=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(IstenenYaziElementi.isEnabled(), "Iframe yazisi gorunmuyor");
        System.out.println(IstenenYaziElementi.getText());

        //          => Text Box a "Merhaba Dunya" yazin

        // yazi yazmak istedigimiz text kutusu iframe in icinde oldugundan direk ulasamiyoruz
        // once iframe i locate edip onun icine switch yapmalıyız
        WebElement iFrame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);

        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        //          => Text Box ın altında bulunan "Element Selenium" linkini textinin gorunur oldugunu
        // yukarida iFrame iicne swich yaptıgımızdan yenıden dısarı cıkmak ıstedıgımızde
        // ana sayfaya donmeliyiz
        driver.switchTo().defaultContent(); // le iframe icinden cikariz
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        //        => yeni sayfada "Sponsored by Sauce Labs" textinin oldugnu dogrulayin ve konsolda yazdirin.


        // sponsored yazisi yeni sayfada oldugundan ve driver eski sayfada kaldıgından yazıyı locate edemedık
        WebElement sponsoredBySauceLabs=driver.findElement(By.xpath("//p[text()='Sponsored by']"));
        softAssert.assertTrue(sponsoredBySauceLabs.isDisplayed(), "Sponsored yazisi gorunmuyor");
        softAssert.assertAll();
    }

@AfterClass
    public void teardown(){
        driver.quit();
}



}
