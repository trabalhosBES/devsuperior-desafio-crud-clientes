package br.com.study.devsuperiordesafiocrudclientes.controllers;

import br.com.study.devsuperiordesafiocrudclientes.dto.entities.ClientDTO;
import br.com.study.devsuperiordesafiocrudclientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable UUID id){
        ClientDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<ClientDTO> create (@Valid @RequestBody ClientDTO dto, UriComponentsBuilder uriComponentsBuilder){
        dto = service.create(dto);
        URI uri = uriComponentsBuilder.path("/clients/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(@PageableDefault(sort = "name", size = 7) Pageable pageable){
        Page<ClientDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable UUID id, @Valid @RequestBody ClientDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
