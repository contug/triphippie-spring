package com.example.triphippiespring.repository;

import com.example.triphippiespring.model.Trip;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {

    @EntityGraph(attributePaths = {"tags"})
    Optional<Trip> findTripWithTagsById(Long id);

    Optional<Trip> findTripById(Long id);
}
