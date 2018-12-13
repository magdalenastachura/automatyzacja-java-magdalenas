package selenium.wordpresspageobjects.pages;

import org.openqa.selenium.WebDriver;

public class WpMainPage {
    private final WebDriver driver;

    public WpMainPage(WebDriver driver) {

        this.driver = driver;
        // Todo: where you open wordpress page

        //tutaj trzeba otworzyć stronę wordpressa
    }

    public WpNotePage openLatestNote() {
        // Todo: here you find and open latest note
        // tu trzeba znaleźć i otworzyć najnowszą notkę
        return new WpNotePage(driver);
    }
}
