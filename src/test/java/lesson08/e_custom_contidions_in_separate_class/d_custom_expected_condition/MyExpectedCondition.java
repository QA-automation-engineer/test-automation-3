package lesson08.e_custom_contidions_in_separate_class.d_custom_expected_condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class MyExpectedCondition {

    static ExpectedCondition<Boolean> pageTitleContainsText(String expTitle){
        return new ExpectedCondition<Boolean>() {
            String actTitle;
            @Override
            public Boolean apply(WebDriver webDriver) {
                actTitle = webDriver.getTitle();
                return actTitle.contains(expTitle);
            }

            @Override
            public String toString() {
                return String.format("Expected title should contain: '%s', but actual was: '%s'",expTitle, actTitle);
            }
        };
    }

    static ExpectedCondition<List<WebElement>> firstListItemContainsTest(By locator, String expText){
        return new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver webDriver) {
                List<WebElement> list = webDriver.findElements(locator);
                if (list.get(0).getText().contains(expText))
                    return list;
                else
                    return null;
            }
        };
    }

}
