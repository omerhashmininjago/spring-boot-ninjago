package com.lego.omer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LEGO_CHARACTER")
@Getter
@Setter
public class LegoCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @JoinColumn(name = "LEGO_TYPE", nullable = false)
    @OneToOne
    private LegoType legoType;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CHARACTER_OCCUPATION")
    private String characterOccupation;

    public LegoCharacter() {
    }

    @Override
    public String toString() {
        return "LegoCharacter{" +
                "id='" + id + '\'' +
                ", legoType=" + legoType +
                ", gender='" + gender + '\'' +
                ", characterOccupation='" + characterOccupation + '\'' +
                '}';
    }
}
