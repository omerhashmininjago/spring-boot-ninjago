package com.lego.omer.service;

import com.lego.omer.domain.LegoType;
import com.lego.omer.error.LegoTypeNotFoundException;
import com.lego.omer.repo.LegoTypeRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LegoTypeServiceTest {

    @Mock
    private LegoTypeRepo legoTypeRepo;

    @InjectMocks
    private LegoTypeService legoTypeService;

    @Test
    public void testGetLegoTypeValid() {
        String legoType = "CLASSIC";
        LegoType expectedLegoType = new LegoType();

        when(legoTypeRepo.findByLegoType(legoType)).thenReturn(Optional.of(expectedLegoType));

        LegoType actualLegoType = legoTypeService.getLegoType(legoType);
        Assert.assertEquals(actualLegoType, expectedLegoType);
    }

    @Test(expected = LegoTypeNotFoundException.class)
    public void testGetLegoTypeInvalid() {
        String legoType = "RANDOM";

        when(legoTypeRepo.findByLegoType(legoType)).thenReturn(Optional.empty());
        legoTypeService.getLegoType(legoType);
    }

    @Test
    public void testGetAllLegoTypes() {
        legoTypeService.getAllLegoTypes();
        verify(legoTypeRepo, times(1)).findAll();
    }
}
