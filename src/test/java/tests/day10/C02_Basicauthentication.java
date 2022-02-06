package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Basicauthentication {

    //1. Bir class olusturun:BasicAuthentication
    WebDriver driver;
    WebElement sonucaYazisiElementi;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
        @Test
        public void authenticationTesti() {
            //2. https://the-internet.herokuapp.com/basic_auth adresine gidin
            driver.get("https://the-internet.herokuapp.com/basic_auth");

            //3.asagidaki yontem ve test datalarini kullanarak Authentication ı yapın
            //    Html konutu : https://username:password@URl
            //    Username    : admin
            //    password    : admin
            // basic authentication isteyen web servisleri bize nasil ve hangi bilgilerle authentication
            // yapabilecegimiz bilgisini de vermek zorundadir.
            // bizde tarif edilen yontem ve bize verilen bilgilerli birebir uygulayarak
            // istedigimiz webservise giris saglayabiliriz

            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
            //4. Basarili sekilde sayfaya girildigini dogrulayın

            WebElement conratMesajıElementi=driver.findElement(By.tagName("p"));
            Assert.assertTrue(conratMesajıElementi.isDisplayed());
        }

        @AfterClass
    public void teardown(){
        driver.close();
        }
    }



