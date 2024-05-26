package com.example.dto;

import lombok.Data;

@Data
public class FacilityWithDataDto {
    private Long facilityId;
    private String facilityName;
    private int facilityStatus;
    private Long dataId;
    private double facilityValue;
}