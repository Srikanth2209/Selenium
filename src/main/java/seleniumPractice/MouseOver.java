package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class MouseOver
{
    ChromeDriver driver;

    @BeforeTest
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/alertdemo.html");
    }
    @Test
    public void test() throws InterruptedException, IOException {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(By.xpath("//li[@class='parent'][3]")))
                .moveToElement(driver.findElement(By.xpath("//a[.='Window Handles']")))
                .click()
                .perform();

        Thread.sleep(2000);
        WebElement WindowsButton = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
        WindowsButton.click();

        Set<String> window=driver.getWindowHandles();
        Object obj[]=window.toArray();
        driver.switchTo().window(obj[1].toString());
        Thread.sleep(2000);
        WebElement FirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        FirstName.sendKeys("srikanth");
        Thread.sleep(2000);
        WebElement LastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        LastName.sendKeys("kareti");
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(obj[0].toString());

        WebElement TextWin1 = driver.findElement(By.xpath("//input[@id='name'][@class='whTextBox']"));
        TextWin1.sendKeys("jenkins");

        //Taking screenshot//
        File SourceFile = driver.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("D:\\FileReaders/Sc1.png");
        FileUtils.copyFile(SourceFile,DestFile);
        System.out.println("Screenshot Successful");
        Thread.sleep(2000);
        WebElement OpenTab = driver.findElement(By.xpath("//button[@id='newTabBtn'][@class='whButtons']"));
        OpenTab.click();

        //switching to tab//
        Set<String> Tab=driver.getWindowHandles();
        Object obj1[]=Tab.toArray();
        driver.switchTo().window(obj1[1].toString());
        Thread.sleep(2000);
        WebElement SimpleAlert = driver.findElement(By.xpath("//button[.='Click me']"));
        SimpleAlert.click();


        //Switching to simpleAlert//
        Alert SimpleAlert1 = driver.switchTo().alert();
        System.out.println(SimpleAlert1.getText());
        SimpleAlert1.accept();

        Thread.sleep(2000);
        WebElement ConformationAlert = driver.findElement(By.xpath("//button[.='Click me'][@id='confirmBox']"));
        ConformationAlert.click();


        //Switching to conformationAlert//

        Alert conformationAlert1 = driver.switchTo().alert();
        System.out.println(conformationAlert1.getText());
        Thread.sleep(2000);
        conformationAlert1.accept();

        WebElement promptAlert = driver.findElement(By.xpath("//button[@id='promptBox']"));
        promptAlert.click();
        Alert promptAlert1 = driver.switchTo().alert();
        System.out.println(promptAlert1.getText());
        Thread.sleep(2000);
        promptAlert1.sendKeys("RRR");
        promptAlert1.accept();


        driver.get("https://www.w3schools.com/html/");
        WebElement html = driver.findElement(By.xpath("//a[.='HTML Tables']"));
        html.click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
        System.out.println(rows.size());
        System.out.println(columns.size());
        for(int i=1;i< columns.size();i++)
        {
            for(int j=2;j< rows.size();j++)
            {
                System.out.println(driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + j+ "]/td[" + i + "]")).getText());
            }
        }


    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
