package anotepad_action;

import anotepad_object.HomePageObjects;
import selenium_utils.SUtils;

public class HomePageActs {
    private static HomePageObjects homepageObj = new HomePageObjects();

    public void navigateToAnotePadHomepage(String url){
        SUtils.openUrl(url);
    }

    public void userClickRegisterButtonAtHomepage(){
        SUtils.clickElementByXpath(homepageObj.getREGISTER_LOGIN_SPAN_XPATH());
    }

    public void closeHomepageBrowser(){
        SUtils.closeWebPage();
    }
}
