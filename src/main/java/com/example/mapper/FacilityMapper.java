package com.example.mapper;

import com.example.dto.FacilityWithDataDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface FacilityMapper {
    @Select("SELECT f.id AS facilityId, f.facility_name, f.facility_status, fd.id AS dataId, fd.facility_value, fd.create_date " +
            "FROM m_facility f JOIN t_facility_data fd ON f.id = fd.facility_id " +
            "WHERE fd.create_date BETWEEN #{startDate} AND #{endDate} " +
            "AND f.facility_name LIKE CONCAT('%', #{facilityName}, '%')")
    List<FacilityWithDataDto> selectFacilitiesWithData(@Param("startDate") LocalDateTime startDate,
                                                       @Param("endDate") LocalDateTime endDate,
                                                       @Param("facilityName") String facilityName);
}