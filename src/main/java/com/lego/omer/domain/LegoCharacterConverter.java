package com.lego.omer.domain;

/*
Scope of this object could also been given to spring

But wanted to demonstrate how an Enum can be used as a Singleton
 */
public enum LegoCharacterConverter {

    LEGO_CHARACTER_CONVERTER;

    public LegoCharacter convert(LegoCharacterFilter legoCharacterFilter, LegoType legoType) {
        LegoCharacter legoCharacter = new LegoCharacter();
        legoCharacter.setGender(legoCharacterFilter.getGender());
        legoCharacter.setCharacterOccupation(legoCharacterFilter.getCharacterOccupation());
        legoCharacter.setLegoType(legoType);
        return legoCharacter;
    }
}
