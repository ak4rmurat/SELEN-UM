package day01_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethodlari {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.testotomasyonu.com");

        driver.findElement(By.xpath("//li[contains(@class,'has-sub')]//a[contains(text(),'Grocery')]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));


        // sayfanin acilmasi
        // veya sayfada aradigimiz webelementleri bulmak icin
        // belirlenen maximum bekleme suresidir


    }
}
