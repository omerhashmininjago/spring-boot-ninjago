package com.lego.omer.service;

import com.lego.omer.domain.LegoCharacter;
import com.lego.omer.domain.LegoCharacterFilter;
import com.lego.omer.domain.LegoType;
import com.lego.omer.error.LegoCharacterNotFoundException;
import com.lego.omer.error.LegoTypeNotFoundException;
import com.lego.omer.repo.LegoCharacterRepo;
import com.lego.omer.runner.NinjagoLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lego.omer.domain.LegoCharacterConverter.LEGO_CHARACTER_CONVERTER;

@Service
public class LegoCharacterService {

    private final LegoCharacterRepo legoCharacterRepo;
    private final LegoTypeService legoTypeService;

    @Autowired
    public LegoCharacterService(LegoCharacterRepo legoCharacterRepo, LegoTypeService legoTypeService) {
        this.legoCharacterRepo = legoCharacterRepo;
        this.legoTypeService = legoTypeService;
    }

    public List<LegoCharacter> getLegoCharacters(final String gender, final String occupation, final String legoType) throws LegoTypeNotFoundException, LegoCharacterNotFoundException {

        LegoType legoTypeObj = validateLegoType(legoType);
        Optional<List<LegoCharacter>> resultSet = legoCharacterRepo.findLegoCharactersByCharacterOccupationAndAndGenderAndAndLegoType(occupation, gender, legoTypeObj);
        if (resultSet.isPresent()) {
            return resultSet.get().stream().collect(Collectors.toList());
        }
        throw new LegoCharacterNotFoundException("No Lego Characters found for the provided filter");
    }

    @Transactional
    public LegoCharacter addLegoCharacter(LegoCharacterFilter legoCharacterFilter) throws LegoTypeNotFoundException {

        LegoType legoType = validateLegoType(legoCharacterFilter.getLegoType());
        LegoCharacter legoCharacter = LEGO_CHARACTER_CONVERTER.convert(legoCharacterFilter, legoType);

        return legoCharacterRepo.save(legoCharacter);
    }

    private LegoType validateLegoType(String legoType) throws LegoTypeNotFoundException {
        if (!NinjagoLoader.getLegoTypes().contains(legoType)) {
            throw new LegoTypeNotFoundException("Not a valid type of Lego");
        }
        return legoTypeService.getLegoType(legoType);
    }
}
