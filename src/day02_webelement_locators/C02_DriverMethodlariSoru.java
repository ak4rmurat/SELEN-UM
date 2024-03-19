package day02_webelement_locators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverMethodlariSoru {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1.Yeni bir class olusturalim (Homework)
        // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        // (title) “facebook” oldugunu test edin, degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        // “actual” URL’i yazdirin.
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Facebook Test PASSED");
        }else {
            System.out.println("Facebook Test FAİLED");
            System.out.println("Sayfa basligi : " + actualTitle);
        }
        Thread.sleep(2000);
        // 4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitle1 = "Walmart.com";
        String actualTitle1 = driver.getTitle();
        if (actualTitle1.contains(expectedTitle1)){
            System.out.println("Walmart Test PASSED");
        }else {
            System.out.println("Walmart Test FAİLED");
            System.out.println("Sayfa basligi : " + actualTitle1);
        }
        Thread.sleep(2000);
        // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(2000);
        // 7. Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);
        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // 9.Browser’i kapatin
        driver.quit();
    }
}
