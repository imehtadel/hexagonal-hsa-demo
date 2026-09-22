package com.rightmove.hexagonalhsapoc.domain.service;

import com.rightmove.hexagonalhsapoc.domain.model.PostcodeDetails;
import com.rightmove.hexagonalhsapoc.domain.port.out.PostcodeLookupClient;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PostcodeServiceTest {

    @Test
    void returnsDetailsFromTheOutboundPort() {
        PostcodeDetails details = new PostcodeDetails("SW1A 1AA", "London", "Westminster", 51.5, -0.14);
        PostcodeService postcodeService = new PostcodeService(postcode -> Optional.of(details));

        assertThat(postcodeService.getPostcodeDetails("SW1A1AA")).contains(details);
    }

    @Test
    void returnsEmptyWhenTheOutboundPortFindsNothing() {
        PostcodeLookupClient alwaysEmpty = postcode -> Optional.empty();
        PostcodeService postcodeService = new PostcodeService(alwaysEmpty);

        assertThat(postcodeService.getPostcodeDetails("ZZ99 9ZZ")).isEmpty();
    }
}
