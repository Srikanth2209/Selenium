package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Downloading_file
{
    WebDriver driver;
    @BeforeTest
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        HashMap<String,Object> prefs = new HashMap<>();
        prefs.put("Plugins.always_open_pdf_externally",true);
        prefs.put("download_default_directory","D:\\FileReaders\\TextDownload");

        options.setExperimentalOption("prefs",prefs);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://file-examples.com/");


    }
    @Test
    public void test()
    {
        WebElement Document = driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a"));
        Document.click();

        WebElement PdfButton = driver.findElement(By.xpath("//td[text()='PDF']/following-sibling::td[2]/a"));
        PdfButton.click();


    }
}
