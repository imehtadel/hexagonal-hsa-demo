package com.rightmove.hexagonalhsapoc.domain.model;

import java.util.UUID;

public record QuoteId(UUID value) {

    public static QuoteId generate() {
        return new QuoteId(UUID.randomUUID());
    }
}
