package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataDrivenTests
{
    WebDriver driver;
    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test(dataProvider = "LoginData")
    public void loginTest(String user, String pwd, String exp)
    {
        driver.get("https://admin-demo.nopcommerce.com/login");
        WebElement Email = driver.findElement(By.id("Email"));
        Email.clear();
        Email.sendKeys(user);

        WebElement Password = driver.findElement(By.id("Password"));
        Password.clear();
        Password.sendKeys(pwd);

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        String exp_title = "Dashboard / nopCommerce administration";
        String act_title = driver.getTitle();
        System.out.println(act_title);

        if(exp.equals("Valid"))
        {
            if(exp_title.equals(act_title))
            {
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }
        else if(exp.equals("Invalid"))
        {
            if(exp_title.equals(act_title))
            {
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }


    }


    @DataProvider(name="LoginData")
    public Object[][] getData() throws IOException {
        /*String loginData[][]={
                {"admin@yourstore.com","admin","Valid"},
                {"admin@yourstore.com","adm","Invalid"},
                {"adm@yourstore.com","admin","Invalid"},
                {"admin@yourstore.com","adm","Invalid"}
        };*/


        String path = "D:\\FileReaders\\LoginTestData.xls";
        XLUtility xlutil = new XLUtility(path);

        int totalrows = xlutil.getRowCount("sheet1");
        int totalcols = xlutil.getCellCount("sheet1",1);

        String loginData[][] = new String[totalrows][totalcols];

        for(int i=1;i<=totalrows;i++)
        {
            for(int j=0;j<totalcols;j++)
            {
                loginData[i-1][j] = xlutil.getCellData("sheet1",i,j);
            }
        }

        return loginData;

    }

}

