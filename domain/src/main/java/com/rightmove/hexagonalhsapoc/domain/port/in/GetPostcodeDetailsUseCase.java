package com.rightmove.hexagonalhsapoc.domain.port.in;

import com.rightmove.hexagonalhsapoc.domain.model.PostcodeDetails;

import java.util.Optional;

public interface GetPostcodeDetailsUseCase {

    Optional<PostcodeDetails> getPostcodeDetails(String postcode);
}
