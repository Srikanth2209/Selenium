package structuralCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Actions
{
    public static WebDriver driver;
    public static Properties properties;
    public boolean isElementsPresent( WebElement element){

        if(element.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    public  String getPageTitle(){

        return driver.getTitle();
    }
    public void ValueInTextBox(WebElement element, String textValue){

        if(isElementsPresent(element)){
            element.sendKeys(textValue);
        }else {
            System.out.println("WebElement is not found ");
        }

    }
    public void ClickButton(WebElement element){
        if(isElementsPresent(element)){
            element.click();
        }else {
            System.out.println("WebElement is not found ");
        }
    }
    public void Launch_Browser(String url){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);

    }
    public void getPropertyFile(){

        properties= new Properties();
        String propertiesPath = System.getProperty("user.dir");
        try {
            properties.load(new FileInputStream(propertiesPath+"/src/main/java/structuralCode/Locators.properties"));
        } catch (IOException e) {
            System.out.println("File is not found in the given path");
        }
    }
}//propertiesPath+"/src/main/java/config/config.properties");
