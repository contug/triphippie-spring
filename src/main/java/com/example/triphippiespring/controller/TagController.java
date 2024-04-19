package com.example.triphippiespring.controller;

import com.example.triphippiespring.dto.TripTagDto;
import com.example.triphippiespring.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/getAllTags")
    @ResponseBody
    public List<TripTagDto> getAllTags() {
        return tagService.getAllTags();
    }
}
