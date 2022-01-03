package structuralCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Interactions extends Verifications
{
    public void script(){
        getPropertyFile();
        Launch_Browser(properties.getProperty("Page_Url"));
        WebElement email = driver.findElement(By.id(properties.getProperty("email")));
        WebElement password = driver.findElement(By.id(properties.getProperty("password")));
        WebElement login = driver.findElement(By.xpath(properties.getProperty("Login_Button")));
        email.clear();
        ValueInTextBox(email,properties.getProperty("Login_UserName"));
        password.clear();
        ValueInTextBox(password,properties.getProperty("Login_Password"));
        ClickButton(login);
        verifyPageTitle("Dashboard / nopCommerce administration");

    }

    public static void main(String[] args) {
        Interactions interaction = new Interactions();
        interaction.script();

    }

}
