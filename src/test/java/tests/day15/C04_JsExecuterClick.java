package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {

    // amazon.com anasayfaya gidin
    // sellLinkine JSExecuter ile tıklayın
    // ilgili sayfaya gittigimizi test edelim


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        // 1. adim JsExecuter objesi olusturalim ve diriver i cast edelim

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        // 2. adim ilgili web elementi locate edelim

        WebElement sellelementi = driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        // 3. adim ilgili script ve argument(bizim web elementimiz) ile objemiz uzerinden
        // executeScript methodunu calıstıralım

        jse.executeScript("arguments[0].click();", sellelementi );

        // 4. adim ilgili sayfaya gittiginizi test edin

    Thread.sleep(5000);
    }

}
