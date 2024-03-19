package day02_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_Xpath {
    public static void main(String[] args) {



    // gerekli ayaları yapın
        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    // testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com/");
    // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='search-input']"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
    // bulunan sonuç yazısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        System.out.println(sonucYazisi.getText());
    // bulunan sonuçların 2'den fazla olduğunu test edin
        int expectedMinSonuc = 2;
        int actualSonucSayisi = Integer.parseInt(sonucYazisi.getText().replaceAll("\\D", ""));

        if (actualSonucSayisi > expectedMinSonuc){
              System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAİLED");
        }
        // bulunan ürünlerden ikincisine tıklayın
        List<WebElement> bulunanUrunElementListe = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        bulunanUrunElementListe.get(1).click();
        // açılan urun sayfasında, urun isminde
        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        // case sensitive olmadan phone geçtiğini test edin
        String expectedIsim = "phone";
        String actualIsim = urunIsimElementi.getText().toLowerCase();
        if (actualIsim.contains(expectedIsim)){
            System.out.println("Phone yazi testi PASSED");
        }else {
            System.out.println("Phone yazi testi FAİLED");
        }
        // sayfayı kapatın
        driver.quit();
    }
}
