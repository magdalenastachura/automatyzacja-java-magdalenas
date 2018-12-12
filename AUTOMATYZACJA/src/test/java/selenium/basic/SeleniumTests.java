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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeleniumTests {

    private WebDriver driver;  //tylko deklaracja zmiennej żeby móc się tym posługiwać we wszystkich metodach
                                    // private - że to jest lokalne w tej klasie

    @BeforeEach         // to ma być zrobione przed testem
    public void startDriver() {// to startuje drivera
        driver = new ChromeDriver(); // to otwiera przeglądarkę
    }

    @Test
    public void canFindCodeSprintersOnGoogle() {

        driver.get("https://www.google.com"); // otwieram stronę webową googla

        WebElement searchBox = driver.findElement(By.name("q"));  // znajduję element searchBox (okienko wyszukiwania)
                                    //i do tej zmiennej przypiszę co znajdzie mi
        searchBox.sendKeys("code sprinters"); //wpisuję tekst
        searchBox.submit(); // tak jakbym kliknęła enter

        //znjadź mi pierwszy element w którym
        Stream<WebElement> searchResults = driver.findElements(By.cssSelector("div.rc")).stream();
        Stream<WebElement> resultFiltered = searchResults
                .filter(r -> r.findElement(By.cssSelector("div.r > a")).getAttribute("href").equals("http://agileszkolenia.pl/"));
        List<WebElement> resultsList = resultFiltered.collect(Collectors.toList());

        Assertions.assertEquals(2, resultsList.size());

        WebElement result = resultsList.get(0);
        Assertions.assertEquals("agileszkolenia.pl/", result.findElement(By.tagName("cite")).getText());

    }

    @AfterEach // to ma być zrobione po teście
    public void closeDriver() {
        driver.quit();
    }
}
