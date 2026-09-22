package com.rightmove.hexagonalhsapoc.domain.service;

import com.rightmove.hexagonalhsapoc.domain.model.Quote;
import com.rightmove.hexagonalhsapoc.domain.model.QuoteId;
import com.rightmove.hexagonalhsapoc.domain.port.in.CreateQuoteUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class QuoteService implements CreateQuoteUseCase {

    private static final BigDecimal ADMIN_FEE = BigDecimal.valueOf(25);

    @Override
    public Quote createQuote(String customerName, BigDecimal basePremium) {
        BigDecimal premium = basePremium.add(ADMIN_FEE);
        return new Quote(QuoteId.generate(), customerName, premium);
    }
}
