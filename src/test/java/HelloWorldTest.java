import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    private static WebDriver webDriver;

    private static final String HELLO_URL = "http://localhost:4567/hello";

    private static boolean isCI() {
        return Boolean.getBoolean("CI");
    }

    @BeforeAll
    static void setupWebDriver() {
        System.out.println("ChromeDriver path: " + System.getProperty("webdriver.chrome.driver"));
        ChromeOptions chromeOptions = new ChromeOptions();
        if(isCI()) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
        }
        try {
            webDriver = new ChromeDriver(chromeOptions);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.flush();
            throw e;
        }
    }

    @AfterAll
    static void closeWebDriver() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    void chromeTest() {
        webDriver.get(HELLO_URL);
        WebElement body = webDriver.findElement(By.tagName("body"));
        assertEquals("Hello World", body.getText());
    }

}