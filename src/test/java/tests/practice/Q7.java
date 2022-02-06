package tests.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Q7 extends TestBase {

    @Test
    public void alert1() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        Thread.sleep(3000);

        // 2. CLICK ME of JavaScript Alert e tıklayın
        driver.findElement(By.id("button1")).click();

        // 3. pop up text i alın
        String message=driver.switchTo().alert().getText();
        Thread.sleep(3000);

        // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
        String expmessage= "I am an alert box!";
        softAssert.assertTrue(message.equals(expmessage));

        // 5. pop up i kabul edin
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        softAssert.assertAll();
    }

    // Yine ayni class da baska test methodu olusturun
    @Test (dependsOnMethods = "alert1")
    public void alert2() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        Thread.sleep(2000);

        // 2. CLICK ME of JavaScript Confirm Box i  TIKLAYIN
        driver.findElement(By.xpath("//span[@id='button4']")).click();
        Thread.sleep(3000);

        // 3. pop up text i alın                                                //  devamı da bu sekılde olursa alert disable
        Alert alert= driver.switchTo().alert(); //bu sekılde de olabılir ==> alert.dismiss(); yada alert.accept();
        String message=driver.switchTo().alert().getText();
            // alert.getText(); 2. way
        // 4. Mesajın "Press a button!" olduğunu doğrulayın
        String expMessage= "Press a button!";
        softAssert.assertTrue(message.equals(expMessage));

        // 5. Açılır pencereyi kapat

           // alert.dismiss(); ==>2. way Alert alert= olusturdugumuzda kullanırız
        driver.switchTo().alert().dismiss();

        // 6. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
        softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-alert-text']")).isDisplayed());
        softAssert.assertAll();

        // 7. alert1'e göre dependsOnMethods kullanın

    }






}
