package kz.hackathon.meeting.dto.mappers;

import kz.hackathon.meeting.dto.response.OfficeDto;
import kz.hackathon.meeting.models.Office;

public class OfficeMapper {
    public static OfficeDto toResponseDto(Office office){
        return OfficeDto.builder()
                .id(office.getId())
                .title(office.getTitle())
                .city(office.getCity())
                .address(office.getAddress())
                .build();
    }
}
