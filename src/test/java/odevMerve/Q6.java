package odevMerve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.print.attribute.SetOfIntegerSyntax;
import java.time.Duration;
import java.util.Set;

public class Q6 {


    WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void newWindowTest(){

        // https://www.the-internet.herokuapp.com/windows adresine gidin,
      driver.get("https://www.the-internet.herokuapp.com/windows");  // sayfa kullanılamıyor

        // sayfadaki text in "Opening a new window" oldugunu dogrulayin.
        String actualText=driver.findElement(By.tagName("h3")).getText();
        String expectedText="Opening a new window";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualText,expectedText, "Actual and Expected taxt is doesnt match");

        // sayfa basliginin (title) "The Internet" oldugunu dogrulayin
        softAssert.assertEquals(driver.getTitle(),"The Internet", "Title doesnt exist the Internet");

        // Click Here butonuna basin
        String firstHandleNumber=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[.='Click Here']"));

        // Acilan yeni pencerenin sayfa basliginin (title) "New Wİndow" oldugnu dogrulayin.
        Set<String> handleList=driver.getWindowHandles();
        String newWindowHandleNumber="";
        for (String each:handleList){
            newWindowHandleNumber=each;
        }

        // sayfadaki text in "New Window" oldugnu dogrulayin
        driver.switchTo().window(newWindowHandleNumber);
        softAssert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"New Window", "Text test desnt match");

        // Bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugnu dogrulayin
        driver.switchTo().window(firstHandleNumber);
        softAssert.assertEquals(driver.getTitle(),"The Internet", "Last Title test FAİLED");

        softAssert.assertAll();

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}