package com.rightmove.hexagonalhsapoc.domain.service;

import com.rightmove.hexagonalhsapoc.domain.model.PostcodeDetails;
import com.rightmove.hexagonalhsapoc.domain.port.in.GetPostcodeDetailsUseCase;
import com.rightmove.hexagonalhsapoc.domain.port.out.PostcodeLookupClient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostcodeService implements GetPostcodeDetailsUseCase {

    private final PostcodeLookupClient postcodeLookupClient;

    public PostcodeService(PostcodeLookupClient postcodeLookupClient) {
        this.postcodeLookupClient = postcodeLookupClient;
    }

    @Override
    public Optional<PostcodeDetails> getPostcodeDetails(String postcode) {
        return postcodeLookupClient.lookup(postcode);
    }
}
