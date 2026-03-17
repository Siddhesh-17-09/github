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
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testPageTitle() {
        driver.get("http://localhost:9090/java-web-app/hello");

        // ← CRITICAL DEBUG LINES
        System.out.println("%%% URL: " + driver.getCurrentUrl());
        System.out.println("%%% TITLE: " + driver.getTitle());
        System.out.println("%%% SOURCE: " + driver.getPageSource());

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Hello"), "Page should contain 'Hello'");
    }

    @Test
    public void testPageLoads() {
        driver.get("http://localhost:9090/java-web-app/hello");
        assertNotNull(driver.getTitle(), "Page title should not be null");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
