package genricDropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle
{
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        By Country = By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select");

        //doSelectByVisibleText(Country,"Angola");
        //Thread.sleep(5000);
        //doSelectByIndex(Country,2);
        //Thread.sleep(5000);
        //doSelectByValue(Country,"ASM");


        //by using switch case
        //selectDropDownValue(Country, "index", "5");
        //Thread.sleep(5000);
        //selectDropDownValue(Country, "value", "AIA");
        //Thread.sleep(5000);
        //selectDropDownValue(Country, "visibleText", "British Indian Ocean Territory");

        //using enum
        selectDropDownValue(Country, Dropdown.INDEX.toString(), "5");
        Thread.sleep(5000);
        selectDropDownValue(Country, Dropdown.VALUE.toString(), "AIA");
        Thread.sleep(5000);
        selectDropDownValue(Country, Dropdown.VISIBLETEXT.toString(), "British Indian Ocean Territory");

    }

    public static void selectDropDownValue(By locator, String type, String value)
    {
        Select select = new Select(getElement(locator));

        switch (type)
        {
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "visibleText":
                select.selectByVisibleText(value);
                break;
        }
    }
    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static void doSelectByVisibleText(By locator, String value)
    {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }

    public static void doSelectByIndex(By locator, int index)
    {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public static void doSelectByValue(By locator, String value)
    {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }
}
