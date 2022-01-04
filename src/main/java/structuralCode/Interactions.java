package structuralCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Interactions extends Verifications
{
    public void login(){
        getPropertyFile();
        Launch_Browser(properties.getProperty("Page_Url"));
        WebElement email = getElement(By.id(properties.getProperty("email")));
        WebElement password = getElement(By.id(properties.getProperty("password")));
        WebElement login = getElement(By.xpath(properties.getProperty("Login_Button")));
        email.clear();
        ValueInTextBox(email,properties.getProperty("Login_UserName"));
        password.clear();
        ValueInTextBox(password,properties.getProperty("Login_Password"));
        ClickButton(login);
        verifyPageTitle("Dashboard / nopCommerce administration");
        getLinksCount(properties.getProperty("linksTagName"));

    }
    public static void main(String[] args) {
        Interactions interaction = new Interactions();
        interaction.login();
    }

}
