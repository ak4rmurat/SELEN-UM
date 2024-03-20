package day03_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_CssSelector {
    public static void main(String[] args) {
       // 1- bir class olusturun
        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // 2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
       // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
       // 4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
       // 5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String actualSayfaBasligi = driver.getTitle();
        String expectedSayfaBasligi = "Test Otomasyonu";
        if (actualSayfaBasligi.contains(expectedSayfaBasligi)){
            System.out.println("Sayfa basligi testi PASSED");
        }else {
            System.out.println("Sayfa basligi testi FAİLED");
        }
       // 6- Furniture linkine tiklayin
        WebElement fornitureButton = driver.findElement(By.xpath("//a[@href='https://www.testotomasyonu.com/category/8/products']"));
        fornitureButton.click();
       // 7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
       WebElement minPriceRange = driver.findElement(By.xpath("//input[@class='form-control minPrice']"));
       minPriceRange.sendKeys(Keys.DELETE + "40" + Keys.TAB + Keys.DELETE + "200");
       driver.findElement(By.xpath("//button[@class='price-range-button']")).click();
       // 8- filtreleme sonucunda urun bulunabildigini test edin
        String urunBilgisi = driver.findElement(By.xpath("//span[@class='product-count-text']")).getText();
        if (!urunBilgisi.equals("0 Products Found")){
            System.out.println("Urun bulunma testi PASSED");
        }else {
            System.out.println("Urun bulma testi FAİLED");
        }
       // 10-Ilk urunu tiklayin
        List<WebElement> chairs = driver.findElements(By.xpath("//div[@class='product-box mb-2 pb-1']"));
        chairs.get(0).click();
       // 11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        String fiyatBilgisi = driver.findElement(By.xpath("//span[@id='priceproduct']")).getText().replaceAll("\\D", "");
        double fiyat = Double.parseDouble(fiyatBilgisi)/100;
        if (40< fiyat && fiyat<200 ){
            System.out.println("Fiyat testi PASSED");
        }else {
            System.out.println("Fiyat testi FAİLED");
        }
       // 12-Sayfayi kapatin
        driver.quit();
    }
}
