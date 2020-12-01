import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class HelloWorldTestBase {

    protected static WebDriver webDriver;

    private static final String HELLO_URL = "http://localhost:4567/hello";

    protected static boolean isCI() {
        return System.getenv("CI") != null;
    }

    @BeforeAll
    static void waitForServerToStart() throws Exception {
        URL url = new URL(HELLO_URL);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(30_000); // Wait for upto 30 sec
        urlConnection.connect();
    }

    @AfterAll
    static void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    void testBodyContainsHelloWorld() {
        webDriver.get(HELLO_URL);
        WebElement body = webDriver.findElement(By.tagName("body"));
        assertEquals("Hello World", body.getText());
    }

}