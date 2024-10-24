/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class ExplicitWaitTest {
    
    @Test
    public void testSimple() throws Exception {
        // Configuramos el ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Familia\\Documents\\NetBeansProjects\\Selenium2\\chromedriver.exe");

        // Creamos una instancia de ChromeDriver.
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Abrimos una página.
        driver.get("https://demoqa.com/dynamic-properties");
        
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
            driver.findElement(By.id("visibleAfter")).click();
            System.out.println("Botón clickeado");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Close the browser
        driver.quit();
    }
    
}
