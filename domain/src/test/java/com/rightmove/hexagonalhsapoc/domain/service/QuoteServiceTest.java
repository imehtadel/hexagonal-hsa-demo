package com.rightmove.hexagonalhsapoc.domain.service;

import com.rightmove.hexagonalhsapoc.domain.model.Quote;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class QuoteServiceTest {

    private final QuoteService quoteService = new QuoteService();

    @Test
    void addsTheAdminFeeToTheBasePremium() {
        Quote quote = quoteService.createQuote("Jane Doe", BigDecimal.valueOf(100));

        assertThat(quote.customerName()).isEqualTo("Jane Doe");
        assertThat(quote.premium()).isEqualByComparingTo(BigDecimal.valueOf(125));
    }
}
