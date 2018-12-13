package selenium.wordpresspageobjects.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WpNotePage {
    private final WebDriver driver;

    private  String text;

    public WpNotePage(WebDriver driver) {
        this.driver = driver;
    }

    public WpNotePage addComment(String comment, String author, String email) {
       // tutaj musza być bebechy tej metody czyli wypełniania komentarza, autora i emaila



        driver.findElement(By.name("comment")).sendKeys(comment);

        driver.findElement(By.name("author")).sendKeys(author);

        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("submit")).click();


        return new WpNotePage(driver);
    }

    public boolean commentExists(String comment) {



        // T o do : here you check that comment is published
        Stream<WebElement> commentList = driver.findElements(By.className("comment-content"))
                .stream()
                .filter(c -> c.findElement(By.tagName("p")).getText().equals(comment));

        List<WebElement> collect = commentList.collect(Collectors.toList());

        return collect.size() > 0;
    }
}
