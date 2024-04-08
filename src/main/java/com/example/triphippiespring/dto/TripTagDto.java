package com.example.triphippiespring.dto;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.triphippiespring.model.TripTag}
 */
@Data
@Setter
public class TripTagDto implements Serializable {
    Long id;
    String name;

}
