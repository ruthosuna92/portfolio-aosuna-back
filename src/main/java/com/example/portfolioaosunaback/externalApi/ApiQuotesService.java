package com.example.portfolioaosunaback.externalApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ApiQuotesService {

    private final RestTemplate restTemplate;

    private final String apiKeyQuotes;

    @Autowired
    public ApiQuotesService(RestTemplate restTemplate, @Value("${API_KEY_QUOTES}") String apiKeyQuotes) {
        this.restTemplate = restTemplate;
        this.apiKeyQuotes = apiKeyQuotes;
    }

    public List<Object> getQuote(String category) {
        try {
            String apiQuoteUrl = "https://api.api-ninjas.com/v1/quotes?category=" + category;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Api-Key", apiKeyQuotes);

            HttpEntity<?> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<Object[]> responseEntity = restTemplate.exchange(apiQuoteUrl, HttpMethod.GET, requestEntity, Object[].class);
            if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {
                return Arrays.asList(responseEntity.getBody());
            } else {
                return Collections.singletonList("Error al obtener citas de la API. Respuesta nula o no exitosa.");
            }

        } catch (HttpClientErrorException e) {
            // Captura específicamente excepciones relacionadas con códigos de estado HTTP
            // Puedes acceder a la información detallada, por ejemplo, e.getRawStatusCode()
            HttpStatus statusCode = (HttpStatus) e.getStatusCode();
            return Collections.singletonList("Error HTTP al obtener citas de la API. Código de estado: " + statusCode.value());
        } catch (RestClientException e) {
            // Captura otras excepciones de RestTemplate
            return Collections.singletonList("Error al obtener citas de la API: " + e.getMessage());
        }
    }
}
