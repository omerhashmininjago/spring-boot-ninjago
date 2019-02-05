package com.lego.omer.controller;

import com.google.common.collect.ImmutableList;
import com.lego.omer.domain.LegoType;
import com.lego.omer.error.LegoTypeNotFoundException;
import com.lego.omer.response.LegoTypeResponse;
import com.lego.omer.runner.NinjagoLoader;
import com.lego.omer.service.LegoTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/type")
public class LegoTypeController {

    private static final Logger LOG = LoggerFactory.getLogger(LegoTypeController.class);

    private final LegoTypeService legoTypeService;

    @Autowired
    public LegoTypeController(LegoTypeService legoTypeService) {
        this.legoTypeService = legoTypeService;
    }

    @GetMapping(value = "/{legoType}")
    public LegoTypeResponse<LegoType> getLegoTypes(@PathVariable("legoType") final String legoType) {

        LOG.info("getLegoTypes");
        if (validateLegoType(legoType)) {
            List<LegoType> list = ImmutableList.of(legoTypeService.getLegoType(legoType));
            return new LegoTypeResponse(list.size(), list, HttpStatus.OK);
        }
        throw new LegoTypeNotFoundException("Not a valid type of Lego");
    }

    @GetMapping(value = "/all")
    public LegoTypeResponse<LegoType> getAllLegoTypes() {
        LOG.info("getAllLegoTypes");
        List<LegoType> list = legoTypeService.getAllLegoTypes();
        return new LegoTypeResponse(list.size(), ImmutableList.copyOf(list), HttpStatus.OK);
    }

    private boolean validateLegoType(final String legoType) {
        return NinjagoLoader.getLegoTypes().contains(legoType);
    }

}
