package com.example.triphippiespring.service;

import com.example.triphippiespring.dto.TripDto;
import com.example.triphippiespring.dto.TripTagDto;
import com.example.triphippiespring.model.Trip;
import com.example.triphippiespring.model.TripTag;
import com.example.triphippiespring.repository.TripRepository;
import com.example.triphippiespring.repository.TripTagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final ModelMapper modelMapper;
    private final TripTagRepository tripTagRepository;

    public TripService(
            TripRepository tripRepository,
            ModelMapper modelMapper,
            TripTagRepository tripTagRepository) {
        this.tripRepository = tripRepository;
        this.modelMapper = modelMapper;
        this.tripTagRepository = tripTagRepository;
    }

    public TripDto createTrip(TripDto tripDto) {
        Trip trip = convertToEntity(tripDto);
        Trip savedTrip = tripRepository.save(trip);
        return convertToDto(savedTrip);
    }

    public TripDto getTrip(Long id) {
        Trip trip = tripRepository.findById(id).orElse(null);
        return convertToDto(trip);
    }

    public TripDto updateTripTags(Long id, List<Long> tagIdList) throws IllegalArgumentException {
        Trip trip = tripRepository.findById(id).orElse(null);
        if (trip == null) {
            throw new IllegalArgumentException("Trip not found");
        }
        List<TripTag> tags = tripTagRepository.findAllById(tagIdList);
        if (tags.size() == tagIdList.size()) {
            trip.setTags(tags);
            tripRepository.save(trip);
            TripDto convertedTrip = convertToDto(trip);
            return convertToDto(trip);
        } else {
            throw new IllegalArgumentException("Some tags not found");
        }
    }


    /**
     * Convert entity to DTO
     *
     * @param trip Trip entity
     * @return TripDto
     */
    private TripDto convertToDto(Trip trip) {
        TripDto tripDto = modelMapper.map(trip, TripDto.class);
        tripDto.setTags(trip.getTags().stream()
                .map(tag -> {
                    TripTagDto tripTagDto = new TripTagDto();
                    tripTagDto.setId(tag.getId());
                    tripTagDto.setName(tag.getName());
                    // set other fields...
                    return tripTagDto;
                })
                .collect(Collectors.toList()));
        return tripDto;
    }

    /**
     * Convert DTO to entity
     *
     * @param tripDto TripDto
     * @return Trip entity
     */
    private Trip convertToEntity(TripDto tripDto) {
        return modelMapper.map(tripDto, Trip.class);
    }

}
