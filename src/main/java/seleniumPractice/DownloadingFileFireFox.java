package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.awt.*;

import java.awt.event.KeyEvent;


public class DownloadingFileFireFox
{
    public static void main(String[] args) throws AWTException, InterruptedException {
    WebDriver driver;
        {
            WebDriverManager.firefoxdriver().setup();

            String filetype = "PPT, PPTX";

            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("pdfjs.disabled", true);
            profile.setPreference("browser.helperApps.neverAsk.saveTODisk","application/mspowerpoint,application/powerpoint,application/vnd.ms-powerpoint,application/x-mspowerpoint,application/vnd.openxmlformats-officedocument.presentationml.presentation");

            options.setProfile(profile);

            driver = new FirefoxDriver();
            Robot robot = new Robot();
            Thread.sleep(3000);

            driver.get("https://file-examples.com/index.php/sample-documents-download/");

            driver.findElement(By.xpath("//td[text()='" + filetype + "']/following-sibling::td[2]")).click();
            driver.findElement(By.xpath("//a[starts-with(text(),'Download sample')]")).click();


            robot.keyPress(KeyEvent.VK_DOWN);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_ENTER);




        }
    }
}