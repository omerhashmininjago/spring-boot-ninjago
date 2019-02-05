package com.lego.omer.service;

import com.lego.omer.domain.LegoType;
import com.lego.omer.error.LegoTypeNotFoundException;
import com.lego.omer.repo.LegoTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegoTypeService {

    private final LegoTypeRepo legoTypeRepo;

    @Autowired
    public LegoTypeService(LegoTypeRepo legoTypeRepo) {
        this.legoTypeRepo = legoTypeRepo;
    }

    public LegoType getLegoType(String legoType) throws LegoTypeNotFoundException {
        Optional<LegoType> type = legoTypeRepo.findByLegoType(legoType);
        if (type.isPresent()) {
            return type.get();
        }
        throw new LegoTypeNotFoundException("Not a valid type of Lego");
    }

    public List<LegoType> getAllLegoTypes() {
        return legoTypeRepo.findAll();
    }

}
