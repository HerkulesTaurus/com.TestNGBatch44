package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void test(){


        int a=20;
        int b=20;
        int c=30;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(a,b, "1. test basarisiz");        //failed
        softAssert.assertTrue(a>b,"2. test basarisiz" );  //failed
        softAssert.assertTrue(a<c,"3. test basarisiz" );  //passeD
        softAssert.assertTrue(c>b,"4. test basarisiz" );  //passeD
        softAssert.assertTrue(c<a,"5. test basarisiz" );  //failed

    //assertAll demezsek class calısır ve passed yazar, cunku aslında raporlama yapmaz sadece kodlar calısmıs olur
        softAssert.assertAll();
        System.out.println("eger softassert lerden fail olan varsa bu satır calısmaz");
    }
}
