package lesson08.d_custom_expected_condition;

import org.openqa.selenium.WebDriver;

class LandingPage extends BasePage implements LandingPageLocators {

    public LandingPage(WebDriver wd) {
        super(wd);
    }

    void searchFor(String query){
        $(searchField).click();
        $(searchField).clear();
        $(searchField).sendKeys(query);
    }

    void visit(){
        navigateTo("http://automationpractice.com/index.php");
    }

}