package anotepad_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import anotepad_object.LoginPageObjects;
import selenium_utils.SUtils;

public class LoginActs {
    public static LoginPageObjects loginPageObj = new LoginPageObjects();

    private void userInputsEmailForLogin(String loginEmail) {
        SUtils.inputElementById(loginPageObj.getREGISTER_EMAIL_INPUT_ID(), loginEmail);
    }

    private void userInputsPasswordForLogin(String loginPwd) {
        SUtils.inputElementByXpath(loginPageObj.getREGISTER_PASSWORD_INPUT_XPATH(), loginPwd);
    }

    private void userClicksSubmitForLogin() {
        SUtils.scrollToCenterPage();
        SUtils.clickElementByXpath(loginPageObj.getREGISTER_LOGIN_BTN_XPATH());
        

    }
    
    public void loginAnotepadWithEmail(String email,String password) {
        System.out.println("User inputs email and password for login");
        userInputsEmailForLogin(email);
        userInputsPasswordForLogin(password);
        System.out.println("User clicks submit for login");
        userClicksSubmitForLogin();
    }
    
    public boolean checkErrorMessage(String ErrorMessage) {
   	    String ErrDisplayed = SUtils.GetTextElementByXpath(loginPageObj.GetErrorMessageXPATH());
    	boolean ERR = ErrDisplayed.equals(ErrorMessage);
    	System.out.println(ErrorMessage);
    	System.out.println(ErrDisplayed);
    	return ERR;
    }
}
