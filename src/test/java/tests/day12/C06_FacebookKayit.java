package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {

    // Yeni bir class olusturalim: D15_MouseActions4

    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu= driver.findElement(By.name("firstname"));

        Actions actions=new Actions(driver);
         actions.click(isimKutusu).
                 keyDown(Keys.SHIFT).
                 sendKeys("s").
                 keyUp(Keys.SHIFT).
                 sendKeys("angaa ").
                 sendKeys(Keys.TAB).

                 sendKeys("ZENGE ").
                 sendKeys(Keys.TAB).

                 sendKeys("05328766789").
                 sendKeys(Keys.TAB).

                 sendKeys("Z09yheıdHKn..").
                 sendKeys(Keys.TAB).
                 sendKeys(Keys.TAB).

                 sendKeys("28").
                 sendKeys(Keys.TAB).

                 sendKeys("Tem").
                 sendKeys(Keys.TAB).

                 sendKeys("2000").
                 sendKeys(Keys.TAB).
                 sendKeys(Keys.TAB).
                 sendKeys(Keys.ARROW_RIGHT).
                 perform();

         //4- Kaydol tusuna basalim

             WebElement kaydolBox = driver.findElement(By.name("websubmit"));
                                    kaydolBox.click();
    }
}
