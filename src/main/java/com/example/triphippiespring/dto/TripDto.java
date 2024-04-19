package com.example.triphippiespring.dto;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link com.example.triphippiespring.model.Trip}
 */
@Data
@Setter
public class TripDto implements Serializable {
    Long id;
    String name;
    String description;
    Instant startDate;
    Instant endDate;
    String author;
    double latitude;
    double longitude;
    List<TripTagDto> tags;
}
