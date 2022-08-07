package com.example.tests;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class FelineTest {

    @Spy
    Feline feline = new Feline();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void eatMeatTest() throws Exception {
        //Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        try {
            List<String> actualFood = feline.eatMeat();
            assertEquals("Не совпадает ожидаемый список пищи", expectedFood, actualFood);
        } catch (Exception exception) {
            fail("Не предполагается исключение для вызова без параметров \n однако брошено исключение: " + exception.getMessage());
        }
    }

    @Test
    public void getFamilyTest() {
        //Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();
        assertEquals("Не совпадает семейство", expectedFamily, actualFamily);
    }

    @Test
    public void getKittenParamTest() {
        //Feline feline = new Feline();
        int param = 3;
        int expected = param;

        int actual = feline.getKittens(param);
        assertEquals("Не совпадает количество", expected, actual);
    }

    @Test
    public void getKittenNoParamTest() {
        //Feline feline = new Feline();
        int expected = 1;
        Mockito.when(feline.getKittens(1)).thenReturn(1);

        int actual = feline.getKittens();
        assertEquals("Ожидается количество = 1", expected, actual);
    }


}

