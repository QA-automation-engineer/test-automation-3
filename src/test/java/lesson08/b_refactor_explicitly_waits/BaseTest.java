package lesson08.b_refactor_explicitly_waits;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class BaseTest {

    static WebDriver wd;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(
                    String.format("Test '%s' - was succeeded.", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(
                    String.format("Test '%s' - was failed.", description.getMethodName()));
            super.failed(e, description);
        }

        @Override
        protected void starting(Description description) {
            System.out.println(
                    String.format("Test '%s' - has been started.", description.getMethodName()));
            super.starting(description);
        }
    };

    @BeforeClass
    public static void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(10, SECONDS);
//        wd.manage().timeouts().implicitlyWait(10, SECONDS);

//        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterClass
    public static void tearDown(){
        wd.quit();
    }
}
