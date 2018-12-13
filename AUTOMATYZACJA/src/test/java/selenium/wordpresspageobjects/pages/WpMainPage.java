package selenium.wordpresspageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WpMainPage {
    private final WebDriver driver;

    public WpMainPage(WebDriver driver) {

        this.driver = driver;
        // T o d o: where you open wordpress page
        driver.get("https://automatyzacja.benedykt.net/");
        //tutaj trzeba otworzyć stronę wordpressa
    }

    public WpNotePage openLatestNote() {
        // Todo: here you find and open latest note

        driver.findElement(By.className("entry-title")).findElement(By.tagName("a")).click();

        // tu trzeba znaleźć i otworzyć najnowszą notkę
        return new WpNotePage(driver);
    }
}
