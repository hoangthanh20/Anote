package anotepad_object;

public class LoginPageObjects {
    private final String REGISTER_EMAIL_INPUT_ID = "loginEmail";
    private final String REGISTER_PASSWORD_INPUT_XPATH = "//h1[text()=\"Login\"]/following-sibling::div[2]//input";
    private final String REGISTER_LOGIN_BTN_XPATH = "//h1[text()=\"Login\"]/following-sibling::div[4]//button";
    private final String ErrorMessageXPATH ="//*[contains(text(),'Email and password do not match')]";

    public String getREGISTER_EMAIL_INPUT_ID() {
        return REGISTER_EMAIL_INPUT_ID;
    }

    public String getREGISTER_PASSWORD_INPUT_XPATH() {
        return REGISTER_PASSWORD_INPUT_XPATH;
    }

    public String getREGISTER_LOGIN_BTN_XPATH() {
        return REGISTER_LOGIN_BTN_XPATH;
    }
    public String GetErrorMessageXPATH() {
        return ErrorMessageXPATH;
    }
    
}
