package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecuterScrollIntoView extends TestBase {

    // 1- Yenibir class olusturun : ScroolInto
    // 2- hotelmycamp anasayfasina gidin
    // 3- 2 farklı test methoduyla olusturarak actions class i ve Js Executer kullanarak asagıdakı oda turlerınden
    // ust sırada
    // 4- istediginiz oda inceleme sayfasi acildiginı test edın

    @Test
    public void scroolAction() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();

        driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

        Thread.sleep(5000);
    }


    @Test
    public void scroolJsExecuter() throws InterruptedException {

        driver.get("https://www.hotelmycamp.com");

        // 1. adim JsExecuter objesı olustur ve drıver ı cast edelım
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        // 2.adim calısacagımız web elementı locate edelım
        WebElement odaInceleLinki=driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

        // 3. adim ilgili script ve argument ile jse.executeScript() calıstır
        jse.executeScript("arguments[0].scrollIntoView(true);", odaInceleLinki);
        Thread.sleep(5000);

        jse.executeScript("arguments[0].click();", odaInceleLinki);
        Thread.sleep(5000);


    }




}
