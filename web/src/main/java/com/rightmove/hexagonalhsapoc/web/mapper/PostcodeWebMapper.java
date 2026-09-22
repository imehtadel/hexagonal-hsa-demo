package com.rightmove.hexagonalhsapoc.web.mapper;

import com.rightmove.hexagonalhsapoc.domain.model.PostcodeDetails;
import com.rightmove.hexagonalhsapoc.web.dto.PostcodeDetailsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PostcodeWebMapper {

    public PostcodeDetailsResponseDto toResponseDto(PostcodeDetails details) {
        return new PostcodeDetailsResponseDto(
                details.postcode(), details.region(), details.adminDistrict(), details.latitude(), details.longitude());
    }
}
