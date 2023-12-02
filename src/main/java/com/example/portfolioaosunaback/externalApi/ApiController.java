package com.example.portfolioaosunaback.externalApi;

import com.example.portfolioaosunaback.externalApi.graphs.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class ApiController {

    private final ApiQuotesService apiQuotesService;
    private final ApiPetroleumService apiPetroleumService;
    @Autowired
    public ApiController(ApiQuotesService apiQuotesService, ApiPetroleumService apiPetroleumService) {
        this.apiQuotesService = apiQuotesService;
        this.apiPetroleumService = apiPetroleumService;
    }

    @GetMapping("/quote")
    public List<Object> getQuote(@RequestParam String category) {
        return apiQuotesService.getQuote(category);
    }

    @GetMapping("/valuesOfPetroleum")
    public List<Line> getPetroleumResponse(@RequestParam(name = "oil") List<String> products) {
        return apiPetroleumService.reqPetroleumApi(products);
    }
}
