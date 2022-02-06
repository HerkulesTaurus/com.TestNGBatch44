package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class TwitterLogin extends TestBase {


    @Test
    public void loginTest() throws InterruptedException {
        // 1-https://www.twitter.com a gidin
        driver.get("https://www.twitter.com");

        // 2-hesap olustur butonuna basın
        driver.findElement(By.xpath("//span[text()='Telefon numarası veya e-posta adresiyle kaydol']")).click();

        // 3-isim girin
        WebElement nameElement=driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/label/div/div[2]/div/input"));
        Faker faker=new Faker();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());

        // 4-eposta kullan butonuna tıkla
        driver.findElement(By.xpath("//span[text()='E-posta kullan']")).click();

        // 5-e posta gir
        WebElement emailElement=driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]"));
        emailElement.sendKeys(faker.internet().emailAddress());

        // 6-ay gir
        WebElement monthElement=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
        Select selectMonth=new Select(monthElement);
        selectMonth.selectByIndex(faker.random().nextInt(1,12));

        // 7-gun gir
        WebElement dayElement=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
        Select select1=new Select(dayElement);
        select1.selectByIndex(faker.random().nextInt(1,31));

        // 8-yil gir
        WebElement yearElement=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
        Select select2=new Select(yearElement);
        select2.selectByIndex(faker.random().nextInt(1,120));

        // 9-ileri tusuna basin
        driver.findElement(By.xpath("//span[text()='İleri']")).click();

        // 10-ileri tusuna basin
        driver.findElement(By.xpath("//span[text()='İleri']")).click();
        Thread.sleep(3000);

        // 11-Kaydol tusuna basın
        driver.findElement(By.xpath("//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']")).click();

        // 12-Sana bir kod yolladık yazısını kontrol et
        Thread.sleep(3000);

        String actualMessage = driver.findElement(By.xpath("//span[text()='Sana bir kod gönderdik.']")).getText();
        String expectedMessage ="Sana bir kod yolladık";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualMessage.equals(expectedMessage));

        driver.close();
}
}
