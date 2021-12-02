package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class FormOne

    {
        WebDriver driver;

        @BeforeTest
        public void BeforeTest()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.google.com");

        }

        @Test
        public void Test() throws InterruptedException {
            WebElement googleSearch = driver.findElement(By.name("q"));
            googleSearch.sendKeys("rahulshetty academy.com/automationpractise");

            WebElement SearchButton = driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]"));
            SearchButton.click();

            WebElement DesireLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3"));
            DesireLink.click();

            List<WebElement> RadioButtons = driver.findElements(By.name("radioButton"));
            RadioButtons.get(0).click();
            Thread.sleep(2000);
            RadioButtons.get(1).click();
            Thread.sleep(2000);
            RadioButtons.get(2).click();
            Thread.sleep(2000);

            WebElement Country = driver.findElement(By.id("autocomplete"));
            Country.sendKeys("india");
            Thread.sleep(2000);

            WebElement DropDown = driver.findElement(By.id("dropdown-class-example"));
            DropDown.click();
            WebElement DropOption = driver.findElement(By.xpath("//*[@id=\"dropdown-class-example\"]/option[4]"));
            DropOption.click();
            Thread.sleep(2000);

            WebElement CheckBox = driver.findElement(By.id("checkBoxOption2"));
            CheckBox.click();
            Thread.sleep(2000);
            WebElement Window = driver.findElement(By.id("openwindow"));
            Window.click();

            Thread.sleep(5000);

            Set<String> window=driver.getWindowHandles();
            Object obj[]=window.toArray();
            driver.switchTo().window(obj[1].toString());

            WebElement Home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
            Home.click();
            driver.close();
            driver.switchTo().window(obj[0].toString());

            WebElement NewTab = driver.findElement(By.id("opentab"));
            NewTab.click();
            driver.findElement(By.tagName("Mentorship")).click();


        }

        @AfterTest
        public void AfterTest()
        {
            driver.quit();
        }
    }

