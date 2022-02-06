package odevMerve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q8_fBookVeriAlma {

    // Q8
    WebDriver driver;
    @BeforeClass
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");

        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
    }


    @Test
    public void facebookDropdownDay(){
        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement birthday=driver.findElement(By.name("birthday_day"));
        Select select=new Select(birthday);
        List<WebElement>days=select.getOptions();
        for (WebElement each:days){
            System.out.println(" "+ each.getText());
        }
        System.out.println();
    }

    @Test
    public void facebookDropdownMonth(){
        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement month=driver.findElement(By.name("birthday_month"));
        Select select=new Select(month);
        List<WebElement>months=select.getOptions();
        for (WebElement each:months){
            System.out.println(" " + each.getText());
        }
        System.out.println();
    }

    @Test
    public void facebookDropdownYear(){
        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
WebElement year=driver.findElement(By.name("birthday_year"));
Select select=new Select(year);
List<WebElement>years=select.getOptions();
for (WebElement each:years){
    System.out.println(" "+ each.getText());
}
        System.out.println();

    }


        @AfterClass
                public void teardown() throws InterruptedException {
            Thread.sleep(3000);
        //    driver.quit();
            System.out.println("The codes are succesfully completed! ALL PASS");

    }

}
