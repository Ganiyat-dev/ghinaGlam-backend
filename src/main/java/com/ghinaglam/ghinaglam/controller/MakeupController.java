package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.model.BaseEntity;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import com.ghinaglam.ghinaglam.service.MakeupService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")

public class MakeupController extends BaseEntity {
    private final MakeupService makeupService;

    @GetMapping("/muas")
    public ResponseEntity<List<MakeUpDto>> getMakeupArtists() {
        return ResponseEntity.ok().body(makeupService.getMakeupArtists());
    }

    @GetMapping("/mua/{id}")
    public ResponseEntity<MakeUpDto> getMakeUpArtist(@PathVariable("id") String email) {
        return ResponseEntity.ok().body(makeupService.getMakeupArtist(id));
    }

    @PostMapping(value = "/mua")
    public ResponseEntity<MakeUpDto> saveMakeupArtist(@RequestBody MakeUpDto makeUpDto, @AuthenticationPrincipal AppUser currentUser) throws Exception {
        return ResponseEntity.ok().body(makeupService.saveMakeupArtist(makeUpDto, currentUser));
    }
//    @GetMapping("/license/download")
//    public ResponseEntity downloadFile(@RequestParam String fileName) throws Exception{
//        File file = new File(fileName);
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=" + file.getName())
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .contentLength(file.length())
//                .body(resource);
//    }

    @PutMapping(value = "/mua/{id}")
    public ResponseEntity<MakeUpDto> updateMakeupArtist(@PathVariable("id") Long id, @RequestBody MakeUpDto makeUpDto) {
        return ResponseEntity.ok().body(makeupService.updateMakeupArtist(id, makeUpDto));
    }

    @DeleteMapping("/mua/{id}")
    public ResponseEntity<String> deleteMakeupArtist(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(makeupService.deleteMakeupArtist(id));
    }
}
