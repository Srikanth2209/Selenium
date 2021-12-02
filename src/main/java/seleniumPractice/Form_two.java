package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Form_two
    {
        WebDriver driver;
        @BeforeTest
        public void BeforeTest()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");
        }
        @Test
        public void Test() throws InterruptedException {
            WebElement FirstName = driver.findElement(By.id("firstName"));
            FirstName.sendKeys("Srikanth");

            WebElement LastName = driver.findElement(By.id("lastName"));
            LastName.sendKeys("Kareti");

            WebElement Email = driver.findElement(By.id("userEmail"));
            Email.sendKeys("Karetigmail.com");
            Thread.sleep(1000);

            WebElement male = driver.findElement(By.cssSelector(".custom-radio:nth-child(1) > .custom-control-label"));
            male.click();

            WebElement MobNum = driver.findElement(By.xpath("//input[@id='userNumber']"));
            MobNum.sendKeys("9654649944");

            WebElement Subject = driver.findElement(By.xpath("//#genterWrapper>div:nth-of-type(2)>div:nth-of-type(3)"));
            Subject.sendKeys("We can do it");

        }

        @AfterTest
        public void AfterTest() throws InterruptedException {
            Thread.sleep(5000);
            driver.close();
        }
    }

