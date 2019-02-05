package com.lego.omer.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public final class LegoCharacterResponse<LegoCharacter> extends ResponseEntity<LegoCharacter> {

    public LegoCharacterResponse(int count, LegoCharacter legoCharacterList, HttpStatus status) {
        super(legoCharacterList, status);
        this.count = count;
    }

    private List<LegoCharacter> legoCharacterList;

    private int count;

    @Override
    public String toString() {
        return "LegoCharacterResponse{" +
                "legoCharacterList=" + legoCharacterList +
                ", count=" + count +
                '}';
    }
}
