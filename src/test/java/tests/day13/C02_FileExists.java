package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.home")); // C:\Users\User

        // masa ustundeki deneme kalsorunun Path'ini istesem
        // "C:\Users\User\Desktop\Deneme\selenium.xlsx"

        // Yani dinamik olarak masaustundeki Deneme klasorunun path ini yazmak istersem

        String path = System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";

        System.out.println(path);

        System.out.println("user.dir :"+System.getProperty("user.dir"));

        // Masaustunde Deneme kalsoru icerisinde slenium.xlsx isminde bir dosya oldugunu test edin
        // ******* masaustun de Deneme klasoru ve ıcınde selenium.xlsx olmazsa calısmaz
        // 1- Once bu dosyaya ualasmak icin gerekli dinamik path olusturulmali

        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        // projemizde pom.xml oldugunu test edin
        // C:\Users\User\eclipse-workspace\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir")); // projemizin yolunu verir
        // C:\Users\User\eclipse-workspace\com.TestNGBatch44

        String pomxmlPath=System.getProperty("user.dir") + "\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomxmlPath)));

    }
}
