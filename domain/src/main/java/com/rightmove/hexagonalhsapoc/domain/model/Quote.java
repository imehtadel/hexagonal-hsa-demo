package com.rightmove.hexagonalhsapoc.domain.model;

import java.math.BigDecimal;

public record Quote(QuoteId id, String customerName, BigDecimal premium) {

    public Quote {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("customerName must not be blank");
        }
        if (premium == null || premium.signum() < 0) {
            throw new IllegalArgumentException("premium must not be negative");
        }
    }
}
