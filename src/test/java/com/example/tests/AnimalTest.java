package com.example.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.example.Animal;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> expectedFood;

    public AnimalTest(String animalKind, List<String> expectedFood){
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name = "Тест данные")
    public static Object [][] getAnimalKindData(){
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения") },
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Всеядное", List.of()}
        };
    }

    @Test
    public void getFamilyTest(){
        final Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actual = animal.getFamily();

        assertEquals("Не совпадает список семейств", expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        final Animal animal = new Animal();
        try {
            List<String> actualFood = animal.getFood(animalKind);
            assertEquals("Не совпадает список пищи ",expectedFood, actualFood);
        } catch ( Exception exception){
            final String expectedExceptionMess =
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник";
            assertEquals("Ожидается исключение с сообщением", expectedExceptionMess, exception.getMessage());

        }
    }

}
