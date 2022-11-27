package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.exception.ResourceNotFoundException;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import com.ghinaglam.ghinaglam.repository.MakeupRepository;
import com.ghinaglam.ghinaglam.service.MakeupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MakeupServiceImpl implements MakeupService {
    private final MakeupRepository makeupRepository;
    private final ModelMapper mapper = new ModelMapper();

//    @Override
//    public List<MakeupArtist> getMakeupArtists() {
//        return makeupRepository.findAll();
//    }
    @Override
    public List<MakeUpDto> getMakeupArtists() {
    return makeupRepository.findAll().stream().map(this::mapToDto).toList();
    }


    @Override
    public MakeUpDto getMakeupArtist(Long id) {
        return mapToDto(makeupRepository.findById(id).orElseThrow(()-> new IllegalStateException("MakeUp Artist with the id doest not exist")));

    }

    @Override
    public MakeUpDto saveMakeupArtist(MakeUpDto makeUpDto, AppUser currentUser) throws Exception {
//        upload(file, makeUpDto);
        //currentUser not clear
        MakeupArtist makeupArtist = mapToEntity(makeUpDto);
        makeupArtist.setAppUser(currentUser);
//        if (makeupRepository.existsByEmail(makeupArtist.getEmail())) {
//            throw new IllegalStateException("Email Already Exists");
//        }
        return mapToDto(makeupRepository.save(makeupArtist));

    }

    @Transactional
    public MakeUpDto updateMakeupArtist(Long id, MakeUpDto makeUpDto) {
        MakeupArtist makeupArtist = makeupRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Makeup Professional with the" + id + " does not exist"));
        makeupArtist.setSpecialization(makeUpDto.getSpecialization());
        makeupArtist.setYearsOfExperience(makeUpDto.getYearsOfExperience());

        return mapToDto(makeupRepository.save(makeupArtist));
    }

    @Override
    public String deleteMakeupArtist(Long id) {
        if (makeupRepository.existsById(id)) {
            makeupRepository.deleteById(id);
            return "Artist deleted!";
        }
        throw new IllegalStateException("Makeup Artist not found!");
    }

//    public void upload(MultipartFile file, MakeUpDto makeUpDto) throws Exception{
//        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//        try {
//            if (fileName.contains("..")){
//                throw new Exception("Filename contains invalid sequence " + fileName);
//            }
//            String path = ServletUriComponentsBuilder.fromCurrentContextPath()
//                    .path("/license/download/")
//                    .path(fileName)
//                    .toUriString();
//            makeUpDto.setLicensePath(path);
//            makeUpDto.setLicenseData(file.getBytes());
//        } catch (Exception e){
//            throw new Exception("Could not save file " + fileName);
//        }
//    }

    private MakeUpDto mapToDto(MakeupArtist makeupArtist) {
        return mapper.map(makeupArtist, MakeUpDto.class);
    }

    private MakeupArtist mapToEntity(MakeUpDto makeUpDto) {
        return mapper.map(makeUpDto, MakeupArtist.class);
    }
}
