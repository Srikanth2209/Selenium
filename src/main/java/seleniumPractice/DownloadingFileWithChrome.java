package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.HashMap;

public class DownloadingFileWithChrome
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();

        String filetype = "PPT, PPTX";

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("plugins.always_open_pdf_externally",true);
        prefs.put("download.default_directory","D:\\FileReaders");
        options.setExperimentalOption("prefs",prefs);

        driver = new ChromeDriver(options);

        driver.get("https://file-examples.com/index.php/sample-documents-download/");

        driver.findElement(By.xpath("//td[text()='"+filetype+"']/following-sibling::td[2]")).click();
        driver.findElement(By.xpath("//a[starts-with(text(),'Download sample')]")).click();





    }
}
