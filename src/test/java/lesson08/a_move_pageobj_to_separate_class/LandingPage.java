package lesson08.a_move_pageobj_to_separate_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LandingPage implements LandingPageLocators {

    private WebDriver wd;

    public LandingPage(WebDriver wd) {
        this.wd = wd;
    }

    void searchFor(String query){
        $(searchField).click();
        $(searchField).clear();
        $(searchField).sendKeys(query);
    }

    void visit(){
        wd.get("http://automationpractice.com/index.php");
    }

    WebElement $(By locator){
        return wd.findElement(locator);
    }
}
