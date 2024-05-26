package com.example.controller;

import com.example.dto.FacilityWithDataDto;
import com.example.entity.Facility;
import com.example.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {
    @Autowired
    private FacilityService service;

    @GetMapping
    public List<Facility> getAllFacilities() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return service.save(facility);
    }

    @PutMapping("/{id}")
    public Facility updateFacility(@PathVariable Long id, @RequestBody Facility facility) {
        facility.setId(id);
        return service.save(facility);
    }

    @DeleteMapping("/{id}")
    public void deleteFacility(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/search")
    public List<FacilityWithDataDto> searchFacilitiesWithData(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("facilityName") String facilityName) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return service.findFacilitiesWithData(start, end, facilityName);
    }
}