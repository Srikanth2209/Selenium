package structuralCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
    public WebElement getElement(By locator){
        return driver.findElement(locator);
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
    public void getLinksCount(String element){
            List<WebElement> links = driver.findElements(By.tagName(String.valueOf(element)));
            System.out.println("The count of links is: " + links.size());
        }
    public void getLinkText(String element) {
        List<WebElement> links = driver.findElements(By.tagName(element));
        for (WebElement link : links) {
            String linkText = link.getText();
            System.out.println(linkText);
        }
    }
    public void getAllLinks(String element) {
        List<WebElement> links = driver.findElements(By.tagName(element));
        for (WebElement link : links) {
            String LinksNames = link.getAttribute("href");
            System.out.println(LinksNames);
        }
    }
    public void doSelectByVisibleText(WebElement element,String visibleText)
    {
        if(isElementsPresent(element)){
            new Select(element).selectByVisibleText(visibleText);
        }else{
            System.out.println("WebElement is not found ");
        }
    }
}
