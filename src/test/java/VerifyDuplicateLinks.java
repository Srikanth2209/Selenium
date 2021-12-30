import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class VerifyDuplicateLinks
    {
        WebDriver driver;
        Set uniqueLinkTexts = new HashSet();
        List<String> duplicateLink = new ArrayList<String>();

        @BeforeTest
        public void invoke() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.ajio.com/shop/sale?gclid=Cj0KCQiA5aWOBhDMARIsAIXLlkefp7ufEf3Rajq7M7JFC2lpUOiynz7qcvELk3sn43nRzB9cceX6alEaAsCMEALw_wcB");
        }
        @Test(priority = 0)
        public void test1() throws IOException {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println(links.size());
            List<String> linkTexts = new ArrayList<String>();
            for (WebElement link : links) {

                linkTexts.add(link.getAttribute("href"));
            }

            boolean isUnique;

            int duplicate = 0;
            for (String link : linkTexts) {
                // Set.add method returns false if the element is already present in the set
                if (link != null) {
                    isUnique = uniqueLinkTexts.add(link);

                    if (!isUnique) {
                        duplicateLink.add(link);
                        //System.out.println("Duplicate found. Link: " + link);
                        duplicate++;
                    }
                }
            }
            System.out.println(duplicateLink.size());
            System.out.println(duplicateLink);
            System.out.println(uniqueLinkTexts.size());
            System.out.println(uniqueLinkTexts);
        }
        @AfterTest
        public void close() {
            driver.quit();
        }
    }

