package lesson09.c_creds_manager;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

class LandingPage extends BasePage implements LandingPageLocators {

    public LandingPage(WebDriver wd) {
        super(wd);
    }

    void searchFor(String query){
        $(elementToBeClickable(searchField)).click();
        $(searchField).clear();
        $(searchField).sendKeys(query);
    }

    void visit(){
        navigateTo("http://automationpractice.com/index.php");
    }

    void verifyFirstAdviceContainsText(String expAdvice){
        assertThat(textToBePresentInElementLocated(firstAdvice, expAdvice));
    }

}