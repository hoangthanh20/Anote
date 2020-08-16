import common_action.ReadFileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        ReadFileHandler readFileHdl = new ReadFileHandler();
        Properties dataLogin = readFileHdl.readPropertiesFileFromDirectory("src\\main\\java\\test.properties");
        System.out.println(dataLogin.getProperty("user"));
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\drivers\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        // tries to open chercher.tech page

        driver.get("https://www.24h.com.vn");
    }
}
