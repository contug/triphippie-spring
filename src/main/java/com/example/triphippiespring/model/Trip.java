package com.example.triphippiespring.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "trip")
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    private String description;

    private Instant startDate;

    private Instant endDate;

    private String author;

    //latitude and logitude as numbers

    private double latitude;

    private double longitude;

    @ManyToMany
    @JoinTable(
        name = "trip_trip_tag",
        joinColumns = @JoinColumn(name = "trip_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TripTag> tags;
}
