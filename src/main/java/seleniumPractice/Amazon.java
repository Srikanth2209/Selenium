package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon
{

        ChromeDriver driver;
        @BeforeTest
        public void beforeTest()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.com");
        }
        @Test
        public void test() throws InterruptedException {
            WebElement Search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
            Search.sendKeys("Watches");
            Thread.sleep(2000);

            WebElement SearchSubmit = driver.findElement(By.cssSelector("#nav-search-submit-button"));
            SearchSubmit.click();

            WebElement BrandOnePlus = driver.findElement(By.xpath("//*[@id=\"p_89/Fossil\"]/span/a/div/label/i"));
            BrandOnePlus.click();

            WebElement SelectingItem = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal'][1]"));
            SelectingItem.click();
            Thread.sleep(2000);

            WebElement Addon1 = driver.findElement(By.xpath("//*[@id=\"fbtCheck-1\"]"));
            Addon1.click();

            WebElement AddingToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
            AddingToCart.click();

            WebElement CheckingCart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
            CheckingCart.click();
            Thread.sleep(2000);
            WebElement GiftCheck = driver.findElement(By.xpath("//*[@id=\"sc-buy-box-gift-checkbox\"]"));
            GiftCheck.click();

            Thread.sleep(2000);
            WebElement CheckOut = driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"));
            CheckOut.click();




        }
        @AfterTest
        public void afterTest() throws InterruptedException {
            Thread.sleep(5000);
            driver.quit();
        }
}
