package Kalkulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorAppTest {

    @Test
    @DisplayName("Kot")
    public void add() {

        //arrange
        KalkulatorApp kalkulatorek = new KalkulatorApp();

        //act
        int suma = kalkulatorek.add(1, 2);


        //asert
        Assertions.assertEquals(3, suma, "Sprawdź, że dodawanie liczb całkowitych działa");


    }


    @Test
    public void addd() {
        //arrange
        KalkulatorApp kalkulatorek = new KalkulatorApp();

        //act

        double suma = kalkulatorek.add(1.3, 2.1);

        //asert

        Assertions.assertEquals(3.4, suma, 0.001, "Sprawdź, że dodawanie liczb zmiennoprzecinkowych działa");
    }

    @Test
    public void ddzielenie() {

        KalkulatorApp kalkulatorek = new KalkulatorApp();

        double dzielenie = kalkulatorek.dzielenie(10, 4);

        Assertions.assertEquals(2.5, dzielenie, 0.001, "Sprwadzam poprowaność dzielenia");
    }
}