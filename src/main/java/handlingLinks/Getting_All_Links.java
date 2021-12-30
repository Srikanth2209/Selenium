package handlingLinks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Getting_All_Links
{

    public static void main(String[] args)
    {
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ajio.com/shop/sale?gclid=Cj0KCQiA5aWOBhDMARIsAIXLlkefp7ufEf3Rajq7M7JFC2lpUOiynz7qcvELk3sn43nRzB9cceX6alEaAsCMEALw_wcB");

        List<String> atags = new ArrayList<>();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The count of links is: "+ links.size());
        for(WebElement link:links)
        {
            String LinksNames = link.getAttribute("href");
            if(!atags.contains(LinksNames))
            {
                atags.add(LinksNames);
            }
        }
        for(int j =0;j<atags.size();j++)
        {
            System.out.println(atags.get(j));
        }
    }
}
