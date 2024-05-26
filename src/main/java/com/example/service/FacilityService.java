package com.example.service;

import com.example.dto.FacilityWithDataDto;
import com.example.entity.Facility;
import com.example.mapper.FacilityMapper;
import com.example.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository repository;

    @Autowired
    private FacilityMapper facilityMapper;

    public List<Facility> findAll() {
        return repository.findAll();
    }

    public Facility findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Facility save(Facility facility) {
        return repository.save(facility);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<FacilityWithDataDto> findFacilitiesWithData(LocalDateTime startDate, LocalDateTime endDate, String facilityName) {
        return facilityMapper.selectFacilitiesWithData(startDate, endDate, facilityName);
    }
}