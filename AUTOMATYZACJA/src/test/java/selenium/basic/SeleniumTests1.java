package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeleniumTests1 {
    private WebDriver driver;  //tylko deklaracja zmiennej żeby móc się tym posługiwać we wszystkich metodach
    // private - że to jest lokalne w tej klasie

    @BeforeEach         // to ma być zrobione przed testem
    public void startDriver() {// to startuje drivera
        driver = new ChromeDriver(); // to otwiera przeglądarkę

        driver.manage().window().maximize(); //żeby driver odpalał się pełnoekranowo = maksymalizuj okno przeglądarki
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //zabezpieczenie jeśli coś za długo się ładuje
                                                                                // będzie czekał do 5 sekund czy coś się załaduje
                                                                            //dotyczy wszystkich operacji którą będę robić w selenium
    }


    @Test
    public void verifyAuthorOfBlogNoteAboutTransformations() {
        driver.get("http://markowicz.pro/");
        Stream<WebElement> listOfNotes = driver.findElements(By.className("entry-title"))
                .stream()
                .filter(n -> n.findElement(By.tagName("a")).getText().equals("O transformacjach"));

        List<WebElement> filteredNotes = listOfNotes.collect(Collectors.toList());

        Assertions.assertEquals(1, filteredNotes.size(), "Only one matching note is found on main page");

        driver.findElement(By.cssSelector("#eu-cookie-law input")).submit();// zamknięcie zgody na pliki cooki


        filteredNotes.get(0).click();

        WebElement author = driver.findElement(By.cssSelector(".author > a"));

        Assertions.assertEquals("Rafał", author.getText(), "Proper author name is displayed");
        Assertions.assertEquals("http://markowicz.pro/author/rafal-markowicz/",
                author.getAttribute("href"),
                "Valid author URL is displayed");

    }

    @AfterEach // to ma być zrobione po teście
    public void closeDriver() {
        driver.quit();
    }
}
