package selenium.wordpresspageobjects.pages;

import org.openqa.selenium.WebDriver;

public class WpNotePage {
    private final WebDriver driver;

    public WpNotePage(WebDriver driver) {
        this.driver = driver;
    }

    public WpNotePage addComment(String comment, String author, String email) {
       // tutaj musza być bebechy tej metody czyli wypełniania komentarza, autora i emaila

        return new WpNotePage(driver);
    }

    public boolean commentExists(String comment, String author) {

        // Todo: here you check that comment is published
        return false;
    }
}
