package config;

import seleniumPractice.FormOne;
import seleniumPractice.Form_two;
import java.io.*;
import java.util.Properties;

public class PropertiesFile
{
    static Properties prop = new Properties();
    static String propertiesPath = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        getProperties();
        setProperties();

    }

    public static void getProperties() throws FileNotFoundException {
        try{

            InputStream input = new FileInputStream(propertiesPath+"/src/main/java/config/config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println(browser);
            FormOne.browserName=browser;
            Form_two.browserName=browser;
            Form_Two.browserName=browser;
        }catch(Exception exp){
            exp.printStackTrace();
        }

    }

    public static void setProperties() throws IOException {
        try{
            OutputStream output = new FileOutputStream(propertiesPath+"/src/main/java/config/config.properties");
            prop.setProperty("browser","chrome");
            prop.store(output,null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
