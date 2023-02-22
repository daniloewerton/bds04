package com.devsuperior.bds04.resources;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

    @Autowired
    private EventService service;

    @PostMapping
    public ResponseEntity<EventDTO> insert(@Valid @RequestBody EventDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventDTO(service.insert(dto)));
    }

    @GetMapping
    public ResponseEntity<Page<EventDTO>> findAllPaged(Pageable pageable) {
        Page<EventDTO> page = service.findAllPaged(pageable).map(EventDTO::new);
        return ResponseEntity.ok().body(page);
    }
}
