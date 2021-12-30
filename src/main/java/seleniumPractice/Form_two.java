package seleniumPractice;
import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Form_two
    {
        public static String browserName = null;
        WebDriver driver;
        @BeforeTest
        public void BeforeTest() throws FileNotFoundException {
            PropertiesFile.getProperties();

            if(browserName.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

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
            WebElement DOB = driver.findElement(By.id("dateOfBirthInput"));
            DOB.click();
            new Select(driver.findElement(By.className("react-datepicker__month-select"))).selectByVisibleText("April");
            new Select(driver.findElement(By.className("react-datepicker__year-select"))).selectByVisibleText("1902");
            driver.findElement(By.xpath("//div[contains(text(),'17')]")).click();
            WebElement Subject = driver.findElement(By.id("subjectsInput"));
            Subject.sendKeys("we can do it");
            WebElement Hobbies = driver.findElement(By.cssSelector(".custom-checkbox:nth-child(3) > .custom-control-label"));
            Actions actions=new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(10000);
            Hobbies.click();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Hyderabad");
            driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]")).click();
            driver.findElement(By.id("react-select-3-option-2")).click();
            driver.findElement(By.id("submit")).click();
        }
        @AfterTest
        public void AfterTest() throws InterruptedException {
            driver.close();
        }
    }

