package com.lego.omer.controller;

import com.google.common.collect.ImmutableList;
import com.lego.omer.domain.LegoCharacter;
import com.lego.omer.domain.LegoCharacterFilter;
import com.lego.omer.response.LegoCharacterResponse;
import com.lego.omer.service.LegoCharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/character")
public class LegoCharacterController {

    private static final Logger LOG = LoggerFactory.getLogger(LegoCharacterController.class);

    private final LegoCharacterService legoCharacterService;

    @Autowired
    public LegoCharacterController(LegoCharacterService legoCharacterService) {
        this.legoCharacterService = legoCharacterService;
    }

    @PostMapping
    public LegoCharacterResponse<LegoCharacter> addCharacter(@RequestBody @NotNull @Valid LegoCharacterFilter filter) {

        LegoCharacter legoCharacter = legoCharacterService.addLegoCharacter(filter);
        List<LegoCharacter> responseList = ImmutableList.of(legoCharacter);
        LOG.info("Character added successfully");
        return new LegoCharacterResponse(responseList.size(), responseList, HttpStatus.OK);
    }

    @GetMapping
    public LegoCharacterResponse<LegoCharacter> getCharacter(@RequestParam(value = "gender", required = false) String gender,
                                                             @RequestParam(value = "occupation", required = false) String occupation,
                                                             @RequestParam(value = "legoType") String legoType) {

        List<LegoCharacter> list = legoCharacterService.getLegoCharacters(gender, occupation, legoType);
        return new LegoCharacterResponse(list.size(), ImmutableList.copyOf(list), HttpStatus.OK);
    }
}
