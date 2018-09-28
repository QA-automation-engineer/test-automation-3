package lesson08.f_smart_element_finders_and_po_refactor;

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