import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    private static WebDriver webDriver;

    private static final String HELLO_URL = "http://localhost:4567/hello";

    @BeforeAll
    static void setupWebDriver() {
        System.out.println("ChromeDriver path: " + System.getProperty("webdriver.chrome.driver"));
        webDriver = new ChromeDriver();
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