package day02_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_ByLinkText {
    public static void main(String[] args) throws InterruptedException {

       // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(1000);
       // 3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkListesi = driver.findElements(By.tagName("a"));
        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkListesi.size();
        if (expectedLinkSayisi == actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        }else {
            System.out.println("Link sayisi testi FAİLED");
        }
       // 4- Products linkine tiklayin
       driver.findElement(By.partialLinkText("Products")).click();
       // 5- special offer yazisinin gorundugunu test edin
        if (driver.findElement(By.id("sale_image")).isDisplayed()){
            System.out.println("Special yazisi testi PASSED");
        }else {
            System.out.println("Special yazisi testi FAİLED");
        }
       // 6- Sayfayi kapatin
        driver.quit();
    }
}
