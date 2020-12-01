import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHelloWorldTest extends HelloWorldTestBase {

    @BeforeAll
    static void setupWebDriver() {
        System.out.println("ChromeDriver path: " + System.getProperty("webdriver.chrome.driver"));
        ChromeOptions chromeOptions = new ChromeOptions();
        if(isCI()) {
            System.out.println("Running in CI");
            chromeOptions.addArguments(
                    "no-sandbox",
                    "headless",
                    "disable-dev-shm-usage"
            );

        }
        webDriver = new ChromeDriver(chromeOptions);
    }
}
