package com.rightmove.hexagonalhsapoc.web.controller;

import com.rightmove.hexagonalhsapoc.domain.port.in.GetPostcodeDetailsUseCase;
import com.rightmove.hexagonalhsapoc.web.dto.PostcodeDetailsResponseDto;
import com.rightmove.hexagonalhsapoc.web.mapper.PostcodeWebMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postcodes")
public class PostcodeController {

    private final GetPostcodeDetailsUseCase getPostcodeDetailsUseCase;
    private final PostcodeWebMapper mapper;

    public PostcodeController(GetPostcodeDetailsUseCase getPostcodeDetailsUseCase, PostcodeWebMapper mapper) {
        this.getPostcodeDetailsUseCase = getPostcodeDetailsUseCase;
        this.mapper = mapper;
    }

    @GetMapping("/{postcode}")
    public ResponseEntity<PostcodeDetailsResponseDto> getPostcodeDetails(@PathVariable String postcode) {
        return getPostcodeDetailsUseCase.getPostcodeDetails(postcode)
                .map(mapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
