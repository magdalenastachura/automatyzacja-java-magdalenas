package selenium.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {

    private static final String GOOGLE_PAGE_URL = "http://www.google.com"; //robię sobie stałą z adresu
    public static final By SEARCH_BOX_LOC = By.name("q");
    private final WebDriver gmpDriver;

    public GoogleMainPage(WebDriver driver) { // to jest konsturktor klasy, potrzebujemy webDrivera, nie możemy utworzyć nowego bo
                                                // otworzył by nam nowe okno przeglądarki
        gmpDriver = driver;             // przekazujemy drivera
        gmpDriver.get(GOOGLE_PAGE_URL); // otwiramy stronę googla <--- w tym momencie wracamy do testów
    }

    public selenium.pageobjects.pages.GoogleResultPage search(String searchQuery) { //SearchQuery jest tylko zmiennąlokalną

        WebElement searchBox = gmpDriver.findElement(SEARCH_BOX_LOC);
        searchBox.sendKeys(searchQuery);
        searchBox.submit();

        return new selenium.pageobjects.pages.GoogleResultPage(gmpDriver);
    }
}
