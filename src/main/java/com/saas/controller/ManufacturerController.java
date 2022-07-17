package com.saas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saas.entity.Manufacturer;
import com.saas.repository.ManufacturerRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ManufacturerController {
	@Autowired
	ManufacturerRepository manufacturerRepository;
	@GetMapping("/manufacturers")
	public ResponseEntity<List<Manufacturer>> getAllManufacturers(@RequestParam(required = false) String title) {
		try {
			List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
			if (title == null)
				manufacturerRepository.findAll().forEach(manufacturers::add);
			else
				manufacturerRepository.findByTitleContaining(title).forEach(manufacturers::add);
			if (manufacturers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(manufacturers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/manufacturers/{id}")
	public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable("id") long id) {
		Optional<Manufacturer> manufacturerData = manufacturerRepository.findById(id);
		if (manufacturerData.isPresent()) {
			return new ResponseEntity<>(manufacturerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/manufacturers")
	public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
		try {
			Manufacturer _tutorial = manufacturerRepository
					.save(new Manufacturer(manufacturer.getManufacturerName(), manufacturer.getCapital(),
							manufacturer.getRate(), manufacturer.getReleaseDate()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/manufacturers/{id}")
	public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable("id") long id, @RequestBody Manufacturer manufacturer) {
		Optional<Manufacturer> manufacturerData = manufacturerRepository.findById(id);
		if (manufacturerData.isPresent()) {
			Manufacturer _manufacturer = manufacturerData.get();
			_manufacturer.setManufacturerName(manufacturer.getManufacturerName());
			_manufacturer.setCapital(manufacturer.getCapital());
			_manufacturer.setRate(manufacturer.getRate());
			_manufacturer.setReleaseDate(manufacturer.getReleaseDate());
			return new ResponseEntity<>(manufacturerRepository.save(_manufacturer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/manufacturers/{id}")
	public ResponseEntity<HttpStatus> deleteManufacturer(@PathVariable("id") long id) {
		try {
			manufacturerRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/manufacturers")
	public ResponseEntity<HttpStatus> deleteAllManufacturers() {
		try {
			manufacturerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/manufacturers/published")
	public ResponseEntity<List<Manufacturer>> findByPublished() {
		try {
			List<Manufacturer> manufacturers = manufacturerRepository.findByPublished(true);
			if (manufacturers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(manufacturers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
