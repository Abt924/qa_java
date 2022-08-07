package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sexInput;
    private final boolean expectedHasMane;

    @Mock
    Feline feline;

    public LionTest(String sexInput, boolean expectedHasMane) {
        this.sexInput = sexInput;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Test data {0}, {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Mane", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void constructorLionTest() {
        // Feline feline = new Feline();
        try {
            Lion lion = new Lion(feline, sexInput);

            boolean actualHasMane = lion.doesHaveMane();
            assertEquals("Различается наличие гривы ", expectedHasMane, actualHasMane);

        } catch (Exception exception) {
            final String expectedMess = "Используйте допустимые значения пола животного - самей или самка";
            assertEquals("Expected exception", expectedMess, exception.getMessage());
        }
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);

        final int expected = 1;

        int actual = lion.getKittens();
        assertEquals("Ожидается количество = 1", expected, actual);

    }

    @Test
    public void getFoodTest() throws Exception {

        final List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        try {
            List<String> actualFood = lion.getFood();
            assertEquals("Ожидается количество = 1", expectedFood, actualFood);
        } catch (Exception exception) {
            fail("Получено исключение с сообшением" + exception.getMessage());
        }

    }


}
