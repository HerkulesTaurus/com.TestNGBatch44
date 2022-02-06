package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

public class C01_WindowHandle {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}

    @Test
    public void handleWindows() throws InterruptedException {
    driver.get("https://www.amazon.com/");
    String windowHandleDegeri1=driver.getWindowHandle();
        System.out.println("ilk sayfanın handle degerını : " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW);//yenı bir pencere acilir

        driver.get("https://www.bestbuy.com/");
        System.out.println("2. sayfanın handle degeri :"+ driver.getWindowHandle());
        String windowHandleDegeri2=driver.getWindowHandle();

        Set<String> handleDegerleriSet = Collections.singleton(driver.getWindowHandle());
        System.out.println(handleDegerleriSet);
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        Thread.sleep(5000);
        //====> amazon un acik oldugu sayfaya gecin ve nutella icin arama yapin

        driver.switchTo().window(windowHandleDegeri1);
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);


        // bestbuy acik olan sayfaya gecin ve title in Best Buy icerdigini test edin
        Thread.sleep(5000);
        driver.switchTo().window(windowHandleDegeri2);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));


        // facebook un oldugu sayfaya gecin ve URL in
        // https://www.facebook.com oldugunu test edin
        // eger acik olan pencerelerden sadece bir tanesinin window handle degeri bilinmiyorsa
        // once tum handle degerlerini bulup bir set e koyariz

        handleDegerleriSet=driver.getWindowHandles();

        // bu soru icin su anda set te 3 window handle degeri var
        // 1. ve 2. sayfanın window degeri handle degerlerini biliyoruz
        // setimizde olup, ilk iki sayfa olamayan handle degeri 3. sayfanin handle degeri olacaktir

        String windowHandleDegeri3="";
        for (String each: handleDegerleriSet){
            if (!(each.equals(windowHandleDegeri1) || each.equals(windowHandleDegeri2)) ){

                windowHandleDegeri3=each;
            }
        }

        System.out.println(windowHandleDegeri3);
        System.out.println(handleDegerleriSet);

        driver.switchTo().window(windowHandleDegeri3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        Thread.sleep(5000);

    }

    @AfterClass
    public void teardown(){
        driver.quit();

    }
}
