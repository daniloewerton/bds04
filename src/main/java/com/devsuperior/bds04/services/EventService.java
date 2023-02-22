package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private CityRepository cityRepository;

    public Event insert(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setDate(dto.getDate());
        event.setName(dto.getName());
        event.setUrl(dto.getUrl());
        event.setCity(cityRepository.findById(dto.getCityId()).get());
        return repository.save(event);
    }

    public Page<Event> findAllPaged(Pageable pageable) {
        Page<Event> page = repository.findAll(pageable);
        return page;
    }
}
