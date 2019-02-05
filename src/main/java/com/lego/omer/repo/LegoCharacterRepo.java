package com.lego.omer.repo;

import com.lego.omer.domain.LegoCharacter;
import com.lego.omer.domain.LegoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LegoCharacterRepo extends JpaRepository<LegoCharacter, String> {

    Optional<List<LegoCharacter>> findLegoCharactersByCharacterOccupationAndAndGenderAndAndLegoType(final String occupation,
                                                                                                    final String gender,
                                                                                                    final LegoType legoType);
}
