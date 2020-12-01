import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHelloWorldTest extends HelloWorldTestBase {

    @BeforeAll
    static void setupWebDriver() {
        System.out.println("ChromeDriver path: " + System.getProperty("webdriver.chrome.driver"));
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if(isCI()) {
            System.out.println("Running in CI");
            firefoxOptions.addArguments("--headless");
        }
        webDriver = new FirefoxDriver(firefoxOptions);
    }
}
