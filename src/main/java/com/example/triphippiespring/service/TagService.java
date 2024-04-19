package com.example.triphippiespring.service;

import com.example.triphippiespring.dto.TripTagDto;
import com.example.triphippiespring.model.TripTag;
import com.example.triphippiespring.repository.TripTagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private TripTagRepository tripTagRepository;
    private ModelMapper modelMapper;

    public TagService(
            TripTagRepository tripTagRepository,
            ModelMapper modelMapper
    ) {
        this.tripTagRepository = tripTagRepository;
        this.modelMapper = modelMapper;
    }

    public List<TripTagDto> getAllTags() {
        return tripTagRepository.findAll().stream()
                .map(this::convertToDto)
                .toList();
    }

    private TripTagDto convertToDto(TripTag tripTag) {
        return modelMapper.map(tripTag, TripTagDto.class);
    }

    private TripTag convertToEntity(TripTagDto tripTagDto) {
        return modelMapper.map(tripTagDto, TripTag.class);
    }
}
