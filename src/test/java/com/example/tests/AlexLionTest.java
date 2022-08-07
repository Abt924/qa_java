package com.example.tests;

import com.example.AlexLion;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    //@Mock
    //Feline feline;

    @Test
    public void getFriendsTest() throws Exception {
        final List<String> expectedFriends = List.of("Marty", "Gloria", "Melman");
        Feline feline = new Feline();
        AlexLion alex = new AlexLion(feline);

        List<String> actualFriends = alex.getFriends();
        assertEquals("Friends differance ", expectedFriends, actualFriends);
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        final String expected = "New-York Zoo";
        Feline feline = new Feline();
        AlexLion alex = new AlexLion(feline);

        String actual = alex.getPlaceOfLiving();
        assertEquals("PlaceOfLiving differance ", expected, actual);

    }

    @Test
    public void getKittensTest() throws Exception {
        final int expected = 0;
        Feline feline = new Feline();
        AlexLion alex = new AlexLion(feline);

        int actual = alex.getKittens();
        assertEquals("KittensCount differance ", expected, actual);

    }

}

