package com.lego.omer.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public final class LegoTypeResponse<LegoType> extends ResponseEntity<LegoType> {

    public LegoTypeResponse(int count, LegoType legoTypeList, HttpStatus status) {
        super(legoTypeList, status);
        this.count = count;
    }

    private List<LegoType> legoTypeList;

    private int count;

    @Override
    public String toString() {
        return "LegoTypeResponse{" +
                "legoTypeList=" + legoTypeList +
                ", count=" + count +
                '}';
    }
}
