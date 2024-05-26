package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String facilityName;
    private int facilityStatus;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}