package day02_webelement_locators;

public class C06_Xpath {
    public static void main(String[] args) {

        /*
            Xpath en guclu locater'dir.
            Xpath her turlu Webelement'i locate edebilir.

            2 cesit Xpath vardir.

            1 - Absolute Xpath ( Cok kullanilmaz - Kullanmaniz tavsite edilmez )

            /html/body/header/div/div/div/div[2]/div/ul/li[3]/a
            //header//li[3]/a

            / ve // arasindaki fark :
            / kullandığımızda sadece child html kodlara bakar.
            // kullandığımızda aşağı doğru tüm sülaleye bakar.


            2 - Relative Xpath

            Çok güçlüdür ve her zaman kullanılabilir.

            //i[@class='fa fa-home']

            //tagName[@attributeName='attributeValue']

            Temel fikir her WebElement'de mutlaka bulunan Tag, Attribute ve Attribute Value'yu
            birleştirerek unique locate'e ulaşmaktır.

         */
    }
}
