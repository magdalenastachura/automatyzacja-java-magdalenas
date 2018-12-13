package selenium.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class GoogleResultPage {
    private final WebDriver grpDriver;
    public static final By RESULT_LOC = By.cssSelector("#search .rc .r");

    public GoogleResultPage(WebDriver driver) {
        grpDriver = driver;
    }

    public boolean contains(String resutlUrl) {  //tej metody używam w pierwszym teście GoogleTest

        Stream<WebElement> results = getResultsByUrl(resutlUrl); // stream ze wszystkimi elementami które zawierają powyższy url

        if (results.count() > 0) { // jeśli jest przynajmniej jeden taki url to prawda, jeśli nie to fałsz
                                    // można to zapisać żeby zwróciło po prostu prawdę czyli "return result.count()>0:"
            return true;
        } else {
            return false;
        }
    }

    public boolean containsResultWithTitle(String pageUrl, String pageTitle) {
        Stream<WebElement> results = getResultsByUrl(pageUrl) // na streamie mogę zrobić filter
                .filter(r -> r.findElement(By.tagName("h3")).getText().equals(pageTitle));

        if (results.count() > 0) { // to mozna zapisać jako return
            return true;
        } else {
            return false;
        }
    }

    private Stream<WebElement> getResultsByUrl(String resutlUrl) { // filtruje resultaty po url
        return grpDriver.findElements(RESULT_LOC)
                .stream()
                .filter(r -> r.findElement(By.tagName("a")).getAttribute("href").equals(resutlUrl));
    }                                                   // metoda zwraca stream jakiego url szukamy
}
                                // wewnątrz każdego rezultau szukam taga ancor zamineiam listę na streama wcześniej