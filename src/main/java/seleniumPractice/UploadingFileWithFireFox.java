package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadingFileWithFireFox
{

    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver driver;
        {
           // WebDriverManager.firefoxdriver().setup();
            WebDriverManager.chromedriver().setup();
            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
            Robot robot = new Robot();

            driver.get("http://demo.automationtesting.in/Register.html");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"imagesrc\"]")).click();

            StringSelection stringselection = new StringSelection("D:\\FileReaders\\studentdata");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }

    }
}
