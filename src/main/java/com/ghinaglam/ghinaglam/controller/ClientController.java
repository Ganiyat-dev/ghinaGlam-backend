package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.ClientDto;
import com.ghinaglam.ghinaglam.model.BaseEntity;
import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")

public class ClientController extends BaseEntity {
    private final ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @GetMapping("/client/{email}")
    public ResponseEntity<ClientDto> getClient(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok().body(clientService.getClient(email));
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok().body(clientService.saveClient(clientDto));
    }

    @PatchMapping(value = "/client/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> updateClient(@PathVariable("id") Long id, @RequestBody ClientDto client) {
        return ResponseEntity.ok().body(clientService.updateClient(id, client));
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(clientService.deleteClient(id));
    }
}
