package lesson10.b_uploading_file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventHandler extends AbstractWebDriverEventListener{
    private static final Logger LOG = LogManager.getLogger(EventHandler.class);

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        LOG.info("Browser going to navigate to: " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.debug("Finding element by locator: " + by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOG.info("Going to click on: " + element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        LOG.info("Going to type value: " + keysToSend + " to element: " + element);
    }
}
