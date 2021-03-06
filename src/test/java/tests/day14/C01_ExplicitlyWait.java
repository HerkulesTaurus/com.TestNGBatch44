package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {

    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //     Iki metod icin de asagidaki adimlari test edin.

    @Test (priority = 2001, enabled = false)
    public void implicitlyWaitTest() throws InterruptedException {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        Thread.sleep(3000);
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        Thread.sleep(3000);
    }


    @Test
    public void explicitlyWaitTest() throws InterruptedException {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //explicitliy wait kullanabılmek ıcın once waıt objesı olusturmalıyız
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));

        // her ne kadar kodun anlasılabılır olamsı ıcın once locate edelım sonra bekleyelım yaklasımı daha guzel gorunsede
        // web element zaten gorunur olmadıgı ıcın locate etmemız de mumkun olmayacaktır
        // bu durumda locate ve bekleme ıslemını beraber yapmak gerekır

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        WebElement itsGoneElmenti=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElmenti.isDisplayed());
        Thread.sleep(3000);

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        WebElement itsBackElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
    }
}
