package com.rightmove.hexagonalhsapoc.postcode;

import com.rightmove.hexagonalhsapoc.domain.model.PostcodeDetails;
import com.rightmove.hexagonalhsapoc.domain.port.out.PostcodeLookupClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.util.Map;
import java.util.Optional;

/**
 * Outbound adapter calling the free, public postcodes.io API (https://postcodes.io) to resolve
 * a UK postcode into its region/district/coordinates.
 */
@Component
public class PostcodesIoLookupClient implements PostcodeLookupClient {

    private final RestClient restClient;

    public PostcodesIoLookupClient() {
        this.restClient = RestClient.create("https://api.postcodes.io");
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<PostcodeDetails> lookup(String postcode) {
        try {
            Map<String, Object> body = restClient.get()
                    .uri("/postcodes/{postcode}", postcode)
                    .retrieve()
                    .body(Map.class);

            Map<String, Object> result = (Map<String, Object>) body.get("result");

            return Optional.of(new PostcodeDetails(
                    (String) result.get("postcode"),
                    (String) result.get("region"),
                    (String) result.get("admin_district"),
                    ((Number) result.get("latitude")).doubleValue(),
                    ((Number) result.get("longitude")).doubleValue()));
        } catch (RestClientResponseException e) {
            if (e.getStatusCode().value() == 404) {
                return Optional.empty();
            }
            throw e;
        }
    }
}
