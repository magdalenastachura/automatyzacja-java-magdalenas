package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorAppTest {

    @Test
    //@DisplayName("Kot")
    public void add() {

        //arrange
        CalculatorApp calc = new CalculatorApp();

        //act
        int suma = calc.add(1, 2);


        //asert
        Assertions.assertEquals(3, suma, "Sprawdź, że dodawanie liczb całkowitych działa");


    }


    @Test
    public void addd() {
        //arrange
        CalculatorApp calc = new CalculatorApp();

        //act

        double suma = calc.add(1.3, 2.1);

        //asert

        Assertions.assertEquals(3.4, suma, 0.001, "Sprawdź, że dodawanie liczb zmiennoprzecinkowych działa");
    }

    @Test
    public void ddzielenie() {

        CalculatorApp calc = new CalculatorApp();

        double dzielenie = calc.dzielenie(10, 4);

        Assertions.assertEquals(2.5, dzielenie, 0.001, "Sprwadzam poprowaność dzielenia");
    }
}