package com.rightmove.hexagonalhsapoc.web.controller;

import com.rightmove.hexagonalhsapoc.domain.model.Quote;
import com.rightmove.hexagonalhsapoc.domain.port.in.CreateQuoteUseCase;
import com.rightmove.hexagonalhsapoc.web.dto.CreateQuoteRequestDto;
import com.rightmove.hexagonalhsapoc.web.dto.QuoteResponseDto;
import com.rightmove.hexagonalhsapoc.web.mapper.QuoteWebMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final CreateQuoteUseCase createQuoteUseCase;
    private final QuoteWebMapper mapper;

    public QuoteController(CreateQuoteUseCase createQuoteUseCase, QuoteWebMapper mapper) {
        this.createQuoteUseCase = createQuoteUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public QuoteResponseDto createQuote(@Valid @RequestBody CreateQuoteRequestDto request) {
        Quote quote = createQuoteUseCase.createQuote(request.customerName(), request.basePremium());
        return mapper.toResponseDto(quote);
    }
}
