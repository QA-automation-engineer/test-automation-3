package lesson11;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.EventHandler;
import utils.SimpleAPI;

import java.io.File;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class BaseGUITest extends SimpleAPI {

    private static final Logger LOG = LogManager.getLogger(BaseGUITest.class);

    WebDriver webDriver;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            LOG.info(String.format("Test '%s' - was succeeded.", descriptionToReadableFormat(description)));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            LOG.info(String.format("Test '%s' - was failed.", descriptionToReadableFormat(description)));
            captureScreenshoot(description.getMethodName());
            super.failed(e, description);
        }

        @Override
        protected void starting(Description description) {
            LOG.info(String.format("Test '%s' - has been started.", descriptionToReadableFormat(description)));
            if (webDriver == null){
                EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());
                wd.register(new EventHandler());

                webDriver = wd;
                LOG.debug("WebDriver has been started.");
                webDriver.manage().timeouts().pageLoadTimeout(10, SECONDS);
                webDriver.manage().window().setSize(new Dimension(1920,1080));
            }
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            webDriver.quit();
            webDriver = null;
            LOG.debug("WebDriver has been shut down.");
            super.finished(description);
        }

        private void captureScreenshoot(String methodName) {
            File screenshot = ((TakesScreenshot)webDriver)
                    .getScreenshotAs(OutputType.FILE);
            String screenshotName = screenshot.getName().replace("screenshot", methodName + "_");
            String path = System.getProperty("report.path") + "/screenshots/" + screenshotName;
            try {
                FileUtils.copyFile(screenshot, new File(path));
                LOG.error("Screenshot was got: " + screenshotName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected WebDriver getWebDriver() {
        return webDriver;
    }

    private String descriptionToReadableFormat(Description description){
        return description.getMethodName().replace("_", " ");
    }
}
