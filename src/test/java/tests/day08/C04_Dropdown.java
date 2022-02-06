package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {

    //● Bir class oluşturun: C3_DropDownAmazon

        WebDriver driver;
        WebElement dropdownElementi;
        Select select;

        @BeforeMethod
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

    //● https://www.amazon.com/ adresine gidin.
        @Test
    public void test1(){
            driver.get("https://www.amazon.com/");
            //-Test 1
            // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
            dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            select = new Select(dropdownElementi);

            List<WebElement> optionListesi = select.getOptions();

            int actualOptionSayisi=optionListesi.size();
            int expectedOptionSayisi=45;

            Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);
        }




    @Test
    public void Test2(){
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin


        //    2. Arama kutusuna Java yazin ve aratin
        //    3. Bulunan sonuc sayisini yazdirin
        //    4. Sonucun Java kelimesini icerdigini test edin
    }
}
