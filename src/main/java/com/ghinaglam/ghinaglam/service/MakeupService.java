package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MakeupService {
    List<MakeUpDto> getMakeupArtists();

    MakeUpDto getMakeupArtist(Long id);

    MakeUpDto saveMakeupArtist(MakeUpDto makeUpDto, AppUser currentUser) throws Exception;

    MakeUpDto updateMakeupArtist(Long id, MakeUpDto makeUpDto);

    String deleteMakeupArtist(Long id);


}
