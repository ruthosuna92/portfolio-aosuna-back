package com.example.portfolioaosunaback.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final ApiQuotesService apiQuotesService;

    @Autowired
    public ApiController(ApiQuotesService apiQuotesService) {
        this.apiQuotesService = apiQuotesService;
    }

    @GetMapping("/quote")
    public List<Object> getQuote() {
        return apiQuotesService.getQuote();
    }
}
