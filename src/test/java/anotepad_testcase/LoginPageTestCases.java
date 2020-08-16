package anotepad_testcase;

import anotepad_action.HomePageActs;
import anotepad_action.LoginActs;
import common_action.ReadFileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTestCases {
	 static WebDriver driver;

    private static String navigationPageDir = "src//test//resources//url_navigation.properties";
    private static String loginDataTestcaseDir = "src//test//resources//anotepad_login_data//user_login.properties";
    private static Properties loginDataTestcase = null;
    private static Properties urlsNavigation = null;
    private static LoginActs loginActs = new LoginActs();
    private static HomePageActs homepageActs = new HomePageActs();
    @BeforeTest
    public void init(){
        ReadFileHandler readFileHld = new ReadFileHandler();
        urlsNavigation =readFileHld.readPropertiesFileFromDirectory(navigationPageDir);
        loginDataTestcase = readFileHld.readPropertiesFileFromDirectory(loginDataTestcaseDir);
    }

    @Test
    public void loginAnotePadWithJombieAcount(){
        System.out.println("Step 1: User navigates to Anotepad homepage");
        homepageActs.navigateToAnotePadHomepage(urlsNavigation.getProperty("homepage"));
        System.out.println("Step 2: User clicks on Register/Login button at the top right home page");
        homepageActs.userClickRegisterButtonAtHomepage();
        System.out.println("Step 3: User inputs email and password for login");
        loginActs.loginAnotepadWithEmail(loginDataTestcase.getProperty("email"),loginDataTestcase.getProperty("email_password"));
        Boolean Ass = loginActs.checkErrorMessage(loginDataTestcase.getProperty("ErrorMessage"));
        System.out.println(Ass);
        Assert.assertTrue(Ass);
        
    }

    @AfterTest
    public void closeWebpage(){
        homepageActs.closeHomepageBrowser();
    }
}
