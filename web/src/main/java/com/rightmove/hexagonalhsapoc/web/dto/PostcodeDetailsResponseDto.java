package com.rightmove.hexagonalhsapoc.web.dto;

public record PostcodeDetailsResponseDto(String postcode, String region, String adminDistrict, double latitude, double longitude) {
}
