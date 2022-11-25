package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.model.BaseEntity;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import com.ghinaglam.ghinaglam.service.MakeupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")

public class MakeupController extends BaseEntity {
    private final MakeupService makeupService;

    @GetMapping("/muas")
    public ResponseEntity<List<MakeupArtist>> getMakeupArtists() {
        return ResponseEntity.ok().body(makeupService.getMakeupArtists());
    }

    @GetMapping("/mua/{email}")
    public ResponseEntity<MakeUpDto> getMakeUpArtist(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(makeupService.getMakeupArtist(email));
    }

    @PostMapping("/mua")
    public ResponseEntity<MakeUpDto> saveMakeupArtist(@RequestParam("license") MultipartFile file, @ModelAttribute("makeUpDto")
                                                      MakeUpDto makeUpDto, BindingResult result) throws Exception {
        return ResponseEntity.ok().body(makeupService.saveMakeupArtist(file, makeUpDto));
    }
//    @PostMapping("/vet")
//    public ResponseEntity<VetDto> saveVet(@RequestParam("coverImage") MultipartFile coverImage,
//                                          @RequestParam("logo") MultipartFile logo,
//                                          @RequestParam("document") MultipartFile document,
//                                          @ModelAttribute("vetDto") VetDto vetDto, BindingResult result) throws Exception {
//        return ResponseEntity.ok().body(vetService.saveVet(vetDto, coverImage, logo, document));
//    }
//    @GetMapping("/download/{attachName}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable("attachName") String attachName) throws Exception{
//        Attach attach = attachService.getImage(attachName);
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(attach.getType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attach.getName()
//                        + "\"")
//                .body(new ByteArrayResource(attach.getData()));
//    }

    @PatchMapping(value = "/mua/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MakeUpDto> updateMakeupArtist(@PathVariable("id") Long id, @RequestBody MakeUpDto makeUpArtist) {
        return ResponseEntity.ok().body(makeupService.updateMakeupArtist(id, makeUpArtist));
    }

    @DeleteMapping("/mua/{id}")
    public ResponseEntity<String> deleteMakeupArtist(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(makeupService.deleteMakeupArtist(id));
    }
}
