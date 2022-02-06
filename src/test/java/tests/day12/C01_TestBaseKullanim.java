package tests.day12;

import org.testng.annotations.Test;
import tests.day10.C01_Alerts;

public class C01_TestBaseKullanim {

    @Test
    public void test01(){
        // prohenız icerisindeki herhangi bir class dan obje olusturabılırz
        // ve o obje sayesınde aıt oldugu class daki tum variable ve methodlara
        // (access modifier izin verdigi surece) ulasabılirım
        C01_Alerts obj=new C01_Alerts();


        // eger proje kapsamında bır class dan obje olusturulmasını engellemek ıstersenız
        // 1- o class ın constructor ının prıvate yapabılırız
        // 2- class ın kendısını abstract yapabılırız
        // 1.method cok tercıh edılmez cunku OOP consept e uymaz(sınırlı sayıda kullanımı vardır)
        // 2.method u kullanabılırız boylece o class dakı abstract olmayan (concrete)
        // methodları override etmek mecburıyetı olmadan kullanabılırız
        // ama obje olusturmayaz

        // ornegın bır testBase class ını abstract yaptıgımızdan obje olusturamayız
        // ama chıld class lardan TestBase dekı setUp ve teardan method larını kullanabılırz
    }
}
