package com.rightmove.hexagonalhsapoc.web.mapper;

import com.rightmove.hexagonalhsapoc.domain.model.Quote;
import com.rightmove.hexagonalhsapoc.web.dto.QuoteResponseDto;
import org.springframework.stereotype.Component;

@Component
public class QuoteWebMapper {

    public QuoteResponseDto toResponseDto(Quote quote) {
        return new QuoteResponseDto(quote.id().value(), quote.customerName(), quote.premium());
    }
}
