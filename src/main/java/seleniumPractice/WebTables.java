package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

    }

    @Test
    public void test() {
        //First Task

        List<WebElement> StructureColumn = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
        int act_StrucColSize = StructureColumn.size();

        WebElement footer = driver.findElement(By.xpath("//td[.='4 buildings']"));
        String footer_text = footer.getText();
        String num = String.valueOf(footer_text.charAt(0));
        int expected_StrucColSize = Integer.parseInt(num);
        if (act_StrucColSize == expected_StrucColSize) {
            Assert.assertTrue(true);
            System.out.println("Structure column has 4 values");
        }else {
            Assert.assertTrue(false);
        }

        System.out.println(("=======================SecondTask====================="));

        //task 2

        List<WebElement> Row = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
        for (WebElement ele : Row) {
            String Row_wise_data = ele.getText() + "  ";
            System.out.println(Row_wise_data);
        }

        System.out.println(("=======================ThirdTask====================="));

        //task 3

        List<WebElement> Burj_khalifa_Row = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]"));
        for (WebElement ele : Burj_khalifa_Row) {
            String Burj_height = ele.getText();
            if (Burj_height.contains("829m")) {
                System.out.println("Expected Burj_khalifa_Height and Actual Burj_khalifa_Height are same");
            } else {
                System.out.println("Expected Burj_khalifa_Height and Actual Burj_khalifa_Height are not same");
            }
        }

        System.out.println("=========================FourthTask========================");

        //task 4

        List<WebElement> footerhead = driver.findElements(By.xpath("//table/tfoot/tr/th"));
        List<WebElement> footercells = driver.findElements(By.xpath("//table/tfoot/tr/td"));
        int act_sixthrowColumnCount = footerhead.size() + footercells.size();
        int exp_sixthrowColumnCount = 2;
        if(act_sixthrowColumnCount == exp_sixthrowColumnCount)
        {
            Assert.assertTrue(true);
            System.out.println("Sixth row has 2 columns");
        }
        else{
            Assert.assertTrue(false);
        }
    }
}










