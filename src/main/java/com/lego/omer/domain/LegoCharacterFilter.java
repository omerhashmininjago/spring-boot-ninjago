package com.lego.omer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LegoCharacterFilter {

    @NotNull
    private String gender;

    @NotNull
    private String legoType;

    @NotNull
    private String characterOccupation;
}

