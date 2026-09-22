package com.rightmove.hexagonalhsapoc.domain.port.out;

import com.rightmove.hexagonalhsapoc.domain.model.PostcodeDetails;

import java.util.Optional;

public interface PostcodeLookupClient {

    Optional<PostcodeDetails> lookup(String postcode);
}
