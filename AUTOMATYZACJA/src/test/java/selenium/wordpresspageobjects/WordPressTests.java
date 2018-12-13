package selenium.wordpresspageobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.wordpresspageobjects.pages.WpMainPage;
import selenium.wordpresspageobjects.pages.WpNotePage;

import java.util.UUID;

public class WordPressTests extends BaseTest { // extands że będzie dziedziczyła z BestTest


    @Test
    public void canAddCommentToFirstNote(){


        String comment = generateRandomText(); // ponieważ przy samym "String comment" nada pod spodem comment jest podkreślony, to inicjalizujemy zmienną poprzez dodanie jej jakiejśc wartości
        String author = "Magda" + generateRandomText(); // gdbyby sam wygenerowany tekst mi nie wystarczał to doklejam Magda
        String email = generateRandomEmail();


        // potrzebujemy otworzyć stronę wordpresa
        WpMainPage mainPage = new WpMainPage(driver); // obiekt kalsy i przekazać drivera, użyj drivera żeby otworzyć główną stronę tego bola i przkaż do zmiennnej MainPage
        WpNotePage latestNote = mainPage.openLatestNote(); // otwiera najnowszą notkę i przypisuje do zmiennej najnowszej notki WpNotePage
        WpNotePage latestNoteWithComment = latestNote.addComment(comment, author, email); // dodawanie koemntarza oraz autora i emaila
         // po opublikowaniu notki będę miała już inną stronę - przeładowaną - to już nie bedzie strona dodawania komentarza
        // trzy różne zmienne bo za każdym razem są to inne strony

        Assertions.assertTrue(latestNote.commentExists(comment, author)); // teraz robię assercję
    }

    private String generateRandomEmail() {
        return generateRandomText() + "@testdomain.com";
    }

    private String generateRandomText() {
        return UUID.randomUUID().toString(); // UUID to jest unikatowy identyfikator którym możemy się posługiwać jako obiektem, zamieniamy go na string
    }


}


/*--Scenariusz:
otworzyć stronę (open wordpress main page)
otworzyć pierwszą notatkę (open first note)
dodać komentarz (add comment to the note)
sprawdzić czy dodał się komentarz  (check that comment is added)*/