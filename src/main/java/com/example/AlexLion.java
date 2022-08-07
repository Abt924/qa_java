package com.example;

import java.util.List;

public class AlexLion extends Lion {

    public AlexLion(Feline feline) throws Exception {
        super(feline, "Самец");
    }

    public List<String> getFriends() {
        return List.of("Marty", "Gloria", "Melman");
    }

    public String getPlaceOfLiving() {
        return "New-York Zoo";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
