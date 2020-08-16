package selenium_utils;

import common_action.ReadFileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SUtils {

    private static WebDriver seleniumDriver = null;
    private static JavascriptExecutor js = null;
    private static final String SYSTEM_CONF_FILE = "src\\main\\resources\\system_conf.properties";
    private static final String SELENIUM_CONF_FILE = "src\\main\\resources\\selenium_conf.properties";

    static void init() {
        ReadFileHandler readFileHdl = new ReadFileHandler();
        Properties sysConfInfo = readFileHdl.readPropertiesFileFromDirectory(SYSTEM_CONF_FILE);
        Properties seleniumConfInfo = readFileHdl.readPropertiesFileFromDirectory(SELENIUM_CONF_FILE);
        String browser = sysConfInfo.getProperty("browser");
        switch (browser) {
            case "firefox":
                System.out.println("the browser is firefox");
                System.setProperty("webdriver.gecko.driver", sysConfInfo.getProperty("gecko_dir"));
                seleniumDriver = new FirefoxDriver();
                break;
            case "chrome":
                System.out.println("the browser is chrome");
                seleniumDriver = new ChromeDriver();
                break;
            default:
                System.out.println("the browser is not found");
        }
        seleniumDriver.manage().timeouts().implicitlyWait(Integer.parseInt(seleniumConfInfo.getProperty("ele_timeout")),
                TimeUnit.SECONDS);
        seleniumDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(seleniumConfInfo.getProperty("pageload_timeout")),
                TimeUnit.SECONDS);
        js = (JavascriptExecutor) seleniumDriver;
    }

    public static void openUrl(String url){
        if(seleniumDriver==null){
            init();
        }
        seleniumDriver.get(url);
    }

    public static void closeWebPage(){
        seleniumDriver.close();
    }

    public static void clickElementById(String id) {
        WebElement ele = seleniumDriver.findElement(By.id(id));
        ele.click();
    }

    public static void clickElementByXpath(String xpath) {
        WebElement ele = seleniumDriver.findElement(By.xpath(xpath));
        ele.click();
    }

    public static void inputElementById(String id, String value) {
        WebElement ele = seleniumDriver.findElement(By.id(id));
        ele.sendKeys(value);
    }

    public static void scrollToBottomPage(){
        js.executeScript("window.scrollBy(0,1000)");
    }

    public static void scrollToCenterPage(){
        js.executeScript("window.scrollBy(0,500)");
    }

    public static void inputElementByXpath(String xpath, String value) {
        WebElement ele = seleniumDriver.findElement(By.xpath(xpath));
        ele.sendKeys(value);
    }
    public static String GetTextElementByXpath(String xpath) {
    	
    	WebElement ele = seleniumDriver.findElement(By.xpath(xpath));
    	String Err = ele.getText();
    	return Err;
    	
    }
}
