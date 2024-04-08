package com.example.triphippiespring.controller;

import com.example.triphippiespring.dto.TripDto;
import com.example.triphippiespring.dto.TripTagDto;
import com.example.triphippiespring.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;

    public TripController(
            TripService tripService
    ) {
        this.tripService = tripService;
    }

    @GetMapping
    @ResponseBody
    public TripDto getTrip(@RequestParam Long id) {
        return tripService.getTrip(id);
    }

    @PostMapping
    @ResponseBody
    public TripDto postTrip(@RequestBody TripDto tripDto) {
        return tripService.createTrip(tripDto);
    }

    @PutMapping("/{id}/tags")
    @ResponseBody
    public TripDto updateTripTags(@PathVariable Long id, @RequestBody List<Long> tagIdList) {
        return tripService.updateTripTags(id, tagIdList);
    }

}
