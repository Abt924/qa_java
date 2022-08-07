package com.example.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        String expectedSound = "Мяу";
        //Feline feline = new Feline();
        Cat cat = new Cat(feline);

        String actualSound = cat.getSound();
        assertEquals("Sounds difference", expectedSound, actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        //Feline feline = new Feline();
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals("Foods list difference", expectedFood, actualFood);
    }

}
