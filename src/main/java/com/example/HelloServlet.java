package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.jupiter.api.Assertions.*;

public class HelloServletTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // WebDriverManager auto-downloads ChromeDriver — no manual setup needed
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");          // Run without UI (required in Jenkins)
        options.addArguments("--no-sandbox");        // Required in Linux/Jenkins
        options.addArguments("--disable-dev-shm-usage"); // Prevents crashes in containers

        driver = new ChromeDriver(options);
    }

    @Test
    public void testPageTitle() {
        driver.get("http://localhost:8080/java-web-app/hello");
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Hello"), "Page should contain 'Hello'");
    }

    @Test
    public void testPageLoads() {
        driver.get("http://localhost:8080/java-web-app/hello");
        assertNotNull(driver.getTitle(), "Page title should not be null");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
