package com.example.triphippiespring.config;

import com.example.triphippiespring.dto.TripDto;
import com.example.triphippiespring.dto.TripTagDto;
import com.example.triphippiespring.model.Trip;
import com.example.triphippiespring.model.TripTag;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {

    /**
     * ModelMapper bean
     *
     * @return ModelMapper instance
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        /*Converter<List<TripTagDto>, List<TripTag>> tripTagToEntityConverter = new Converter<List<TripTagDto>, List<TripTag>>() {
            public List<TripTag> convert(MappingContext<List<TripTagDto>, List<TripTag>> context) {
                return context.getSource().stream()
                        .map(tripTagDto -> modelMapper.map(tripTagDto, TripTag.class)).collect(Collectors.toList());
            }
        };

        Converter<List<TripTag>, List<TripTagDto>> tripTagToDtoConverter = new Converter<List<TripTag>, List<TripTagDto>>() {
            public List<TripTagDto> convert(MappingContext<List<TripTag>, List<TripTagDto>> context) {
                return context.getSource().stream()
                        .map(tripTag -> modelMapper.map(tripTag, TripTagDto.class)).collect(Collectors.toList());
            }
        };

        modelMapper.typeMap(TripDto.class, Trip.class).addMappings(mapper -> mapper.using(tripTagToEntityConverter).map(TripDto::getTags, Trip::setTags));
        modelMapper.typeMap(Trip.class, TripDto.class).addMappings(mapper -> mapper.using(tripTagToDtoConverter).map(Trip::getTags, TripDto::setTags));
*/
        return modelMapper;

    }


}
