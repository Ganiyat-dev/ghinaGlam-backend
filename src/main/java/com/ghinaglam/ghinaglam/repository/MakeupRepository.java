package com.ghinaglam.ghinaglam.repository;

import com.ghinaglam.ghinaglam.model.MakeupArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MakeupRepository extends JpaRepository<MakeupArtist, Long> {
//    MakeupArtist findByEmail(String email);
//
//    void deleteById(Long id);
//
//    boolean existsByEmail(String email);
//
//    boolean existsById(Long id);
}
