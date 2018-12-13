package selenium.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageobjects.pages.GoogleMainPage;
import selenium.pageobjects.pages.GoogleResultPage;

public class GoogleTests extends selenium.pagebjects.BaseTest {

    @Test
    public void canFindScrumOrgOnGoogle() {
        String pageUrl = "https://www.scrum.org/";
        String pageTitle = "Scrum.org: Homepage";

        // Open Google Main Page
        GoogleMainPage googlePage = new GoogleMainPage(driver);

        // Search For Scrum.org
        GoogleResultPage resultPage = googlePage.search("Scrum.org");

        // Assert Scrum.org page is found
        Assertions.assertTrue(resultPage.contains(pageUrl));
        Assertions.assertTrue(resultPage.containsResultWithTitle(pageUrl, pageTitle), // metoda zawiera resultat
                "Scrum.org page has correct title");
    }

    @Test
    public void canFindCodeSprinters(){
        String pageUrl = "http://agileszkolenia.pl/"; //strona o url i poniższym tytule - to ma google znaleźć
        String pageTitle = "Code Sprinters - Agile Experts -";

        GoogleMainPage googlePage = new GoogleMainPage(driver); //musze sobie gdzieś to zapisać GoogleMainPage jest zmienną
        GoogleResultPage resultPage = googlePage.search("Code Sprinters"); // na stronie głównej chcę wyszukać "code sprinters"
                                                        //po wyszukaniu to już będzie strona rezultatów googla (nie strona główna)
        Assertions.assertTrue(resultPage.contains(pageUrl)); // sprawdzam że strona rezultatów zawiera taki url jak chcę
        Assertions.assertTrue(resultPage.containsResultWithTitle(pageUrl, pageTitle)); // sprawdzam że strona rezultatów zawiera taki url i taki tytuł jak chcę
    }                                       // instrukcja niżej powtarza to co wyżej ale ta wyższa sprawdza mniej- jest lżejsza

}
// mogę też w importach napisać "import static org.junit.jupiter.api.Assertions.*;" w tedy na samym dole wystarczy że napiszę
//  "assertTrue(resultPage.contains(pageUrl)); " (bez  Assertions )

//ad dwóch ostatnich linijek - assercji - napjpierw sprawdzamy czy jest przynajmniej jeden, a potem jeśli jest już jeden to sprawdzamy czy jest ten konkretny