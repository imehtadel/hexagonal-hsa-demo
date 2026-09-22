package com.rightmove.hexagonalhsapoc.domain.port.in;

import com.rightmove.hexagonalhsapoc.domain.model.Quote;

import java.math.BigDecimal;

public interface CreateQuoteUseCase {

    Quote createQuote(String customerName, BigDecimal basePremium);
}
