package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MakeupService {
    List<MakeupArtist> getMakeupArtists();

    MakeUpDto getMakeupArtist(String email);

//    MakeUpDto saveMakeupArtist(MakeUpDto makeUpDto);

    MakeUpDto saveMakeupArtist(MultipartFile file, MakeUpDto makeUpDto) throws Exception;

    MakeUpDto updateMakeupArtist(Long id, MakeUpDto makeUpDto);

    String deleteMakeupArtist(Long id);
}
