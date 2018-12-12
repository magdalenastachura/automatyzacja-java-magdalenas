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

public class SeleniumTest2KrokPoKroku {


    private WebDriver driver;  //tylko deklaracja zmiennej żeby móc się tym posługiwać we wszystkich metodach
    // private - że to jest lokalne w tej klasie

    @BeforeEach         // to ma być zrobione przed testem
    public void startDriver() {// to startuje drivera
        driver = new ChromeDriver(); // to otwiera przeglądarkę
    }


    @Test
    public void verifyAuthorOfBlogNoteAboutTransformationsStepByStep() {
        driver.get("http://markowicz.pro/");

        List<WebElement> listOfNotes = driver.findElements(By.className("entry-title")); //wybieram listę wszystkich notek ktorych klasa jest entry -titles i przypisuje ją do listoof notes

        Stream<WebElement> streamOfNotes = listOfNotes.stream(); //z tego robimy stream

        Stream<WebElement> filteredStream = streamOfNotes
                .filter(n -> n.findElement(By.tagName("a")).getText().equals("O transformacjach")); // robimy wyszukania i jeśli jest to zapisujemy do stremu

        List<WebElement> filteredNotes = filteredStream.collect(Collectors.toList()); // stream zamieniamy na lisstę

        Assertions.assertEquals(1, filteredNotes.size(), "Only one matching note is found on main page");

    }

    @AfterEach // to ma być zrobione po teście
    public void closeDriver() {
        driver.quit();
    }
}

