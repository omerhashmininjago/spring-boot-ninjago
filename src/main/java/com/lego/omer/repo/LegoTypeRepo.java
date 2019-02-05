package com.lego.omer.repo;

import com.lego.omer.domain.LegoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LegoTypeRepo extends JpaRepository<LegoType, String> {

    Optional<LegoType> findByLegoType(String legoType);
}
