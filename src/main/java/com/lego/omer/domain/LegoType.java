package com.lego.omer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LEGO_TYPE")
@Getter
@Setter
public class LegoType {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "TYPE")
    private String legoType;

    public LegoType() {
    }

    @Override
    public String toString() {
        return "LegoType{" +
                "id='" + id + '\'' +
                ", legoType='" + legoType + '\'' +
                '}';
    }
}
