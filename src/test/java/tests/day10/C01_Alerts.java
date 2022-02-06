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

public class C01_Alerts {

    //==> Bir class olusturun:Alerts
    //==> https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    WebDriver driver;
    WebElement sonucaYazisiElementi;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlertTesti(){
        //=======> Bir method olusturun : acceptAlert
        //==> -->1. butona tıklayin, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("(//button[text()='Click for JS Alert'])")).click();
        driver.switchTo().alert().accept();
        //==> "You succesfully clicked an alert" oldugunu test edin
        sonucaYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));

        String actualSonucYazisi=sonucaYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }

    @Test
    public void dismissAlertTesti() throws InterruptedException {
        //=======> Bir method olusturun: dismissAlert
        //==> -->2. butona tıklayin,uyaridaki Cancel butonuna tiklayin ve result mesajinin
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
        //          "succesfully" icerip icermedigini test edin
        sonucaYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucaYazisiElementi.getText();
        String istenmeyenKelime="succesfully";
        Thread.sleep(3000);

        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //=======> Bir method olusturun : sendKeysAlert
        //==> -->3. butona tıklayin, uyaridaki metin kutusuna isminizi yazin
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().sendKeys("yildiz");

        //          Ok butonuna tiklayin ve result mesajinda isminizin gorunlendigini dogrulayin

        driver.switchTo().alert().accept();
        sonucaYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucaYazisiElementi.getText();
        String yazdigimizIsim="yildiz";
        Thread.sleep(3000);

        Assert.assertTrue(actualSonucYazisi.contains(yazdigimizIsim));
    }




    @AfterClass
    public void teardown() {
        driver.close();
    }
    }


