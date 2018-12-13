package selenium.pagebjects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void startBrowser() { //przed każdym testem będziemy"
        driver = new ChromeDriver(); // uruchamiać drivera
        driver.manage().window().maximize();// maksymalizować okno
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wydłużać czekanie
    }

    @AfterEach
    public void quitBrowser() { // po skończonym teście będziemy:
        driver.quit(); //zamykać drivera (przeglądarkę)
    }
}