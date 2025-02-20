package com.devsuperior.bds04.entities;

import com.devsuperior.bds04.dto.CityDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_city")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "city")
	private List<Event> events = new ArrayList<>();
	
	public City() {
	}

	public City(CityDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
	}

	public City(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return events;
	}
}
