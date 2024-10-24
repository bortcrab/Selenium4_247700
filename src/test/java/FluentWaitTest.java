/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */

import com.google.common.base.Function;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class FluentWaitTest {

    @Test
    public void testSimple() throws Exception {
        // Configuramos el ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Familia\\Documents\\NetBeansProjects\\Selenium2\\chromedriver.exe");

        // Creamos una instancia de ChromeDriver.
        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        // Abrimos una página.
        driver.get("https://demoqa.com/dynamic-properties");

        try {
            WebElement button = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id("visiblyAfter"));
                }
            });

            button.click();
            System.out.println("Botón clickeado.");
        } catch (Exception e) {
            System.out.println(e);
        }

        //Close the browser
        driver.quit();
    }

}
