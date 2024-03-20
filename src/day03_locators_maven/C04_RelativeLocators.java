package day03_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;



public class C04_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        /*
        1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli
        relative locator ile locate edip tiklayin
        3 ) Acilan urunun DSLR Camera oldugunu test edin.
         */
        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://testotomasyonu.com/relativeLocators/");

        WebElement victusGaming = driver.findElement(By.cssSelector("img[id='pic12_thumb']"));
        WebElement appleHandphone = driver.findElement(By.cssSelector("img[id='pic6_thumb']"));
        WebElement motorE13 = driver.findElement(By.cssSelector("img[id='pic8_thumb']"));

        WebElement dslr1 = driver.findElement(RelativeLocator.with(By.id("dslr-camera")).toRightOf(appleHandphone));
        WebElement dslr2 = driver.findElement(RelativeLocator.with(By.id("dslr-camera")).toLeftOf(motorE13));
        WebElement dslr3 = driver.findElement(RelativeLocator.with(By.id("dslr-camera")).above(victusGaming));

        dslr1.click();

        WebElement urunIsmiElementi = driver.findElement(By.cssSelector("div[class=' heading-sm mb-4']"));
        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsmiElementi.getText();
        if (actualUrunIsmi.equals(expectedUrunIsmi)){
            System.out.println("Urun ismi testi locator1 PASSED");
        }else {
            System.out.println("Urun ismi testi locator1 FAİLED");
        }


        driver.navigate().back();


        dslr2.click();
        urunIsmiElementi = driver.findElement(By.cssSelector("div[class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsmiElementi.getText();
        if (actualUrunIsmi.equals(expectedUrunIsmi)){
            System.out.println("Urun ismi testi locator2 PASSED");
        }else {
            System.out.println("Urun ismi testi locator2 FAİLED");
        }

        driver.navigate().back();



        dslr3.click();
        urunIsmiElementi = driver.findElement(By.cssSelector("div[class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsmiElementi.getText();
        if (actualUrunIsmi.equals(expectedUrunIsmi)){
            System.out.println("Urun ismi testi locator3 PASSED");
        }else {
            System.out.println("Urun ismi testi locator3 FAİLED");
        }


        driver.quit();




    }
}
