package odevMerve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Q7 extends TestBase {

    @Test
    public void test(){
        // 1- "https://www.facebook.com/" sayfasına gıdın
        driver.get("https://www.facebook.com");

        // 2- yeni hesap olustur butonuna basın
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3- Dogum tarıhı bolumundekı gunlerın lıstesını alın
        WebElement day=driver.findElement(By.name("birthday_day"));
        print(day);

        // 4- Dogum tarıhı bolumundekı ayların lıstesını alın
        WebElement month=driver.findElement(By.name("birthday_month"));
        print(month);

        // 5- Dogum tarıohı bolumundeki yillarin listesini alın
        WebElement year=driver.findElement(By.name("birthday_year"));
        print(year);

    }

    private void print(WebElement day){
        Select select = new Select(day);
        List<WebElement> days = select.getOptions();
        System.out.println("");
        if (days.size()==12){
            System.out.println("months:");
        }else if (days.size()>12 && days.size()<32){
            System.out.println("Days :");
        }else {
            System.out.println("Years :");
        }
        for (WebElement each: days){
            System.out.println(each.getText() + " ");
        }

    }

}
