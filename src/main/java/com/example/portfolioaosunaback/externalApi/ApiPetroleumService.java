package com.example.portfolioaosunaback.externalApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ApiPetroleumService {

    private final RestTemplate restTemplate;
    private final String apiKeyEia;
    private final ObjectData objectData;


    @Autowired
    public ApiPetroleumService(RestTemplate restTemplate, @Value("${API_KEY_EIA}") String apiKeyEia, ObjectData objectData) {
        this.restTemplate = restTemplate;
        this.apiKeyEia = apiKeyEia;
        this.objectData = objectData;
    }


    public List<ObjectData> reqPetroleumApi(List<String> products) {
        StringBuilder apiUrlBuilder = new StringBuilder("https://api.eia.gov/v2/petroleum/pri/land3/data/?api_key=" + apiKeyEia + "&frequency=annual&data[0]=value&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=5000");

        for (String product : products) {
            apiUrlBuilder.append("&facets[product][]=").append(product);
        }

        String stringApiUrl = apiUrlBuilder.toString();
        try {
            Object response = restTemplate.getForObject(stringApiUrl, Object.class);

            if (response == null ) {
                // Log the issue using a logging framework
                System.out.println("Nothing to see here");
            }

            ObjectMapper objectMapper = new ObjectMapper();

// Assuming 'response' is a LinkedHashMap
            LinkedHashMap<String, Object> responseMap = (LinkedHashMap<String, Object>) response;

// Convert LinkedHashMap to JsonNode
            JsonNode root = objectMapper.valueToTree(responseMap);
            JsonNode nestedObject = root.path("response");
            ArrayNode dataArray = (ArrayNode) nestedObject.path("data");

            List<ObjectData> objectDataList = new ArrayList<>();
            for (JsonNode objectNode : dataArray) {
                ObjectData data = new ObjectData();
                data.setPeriod(objectNode.path("period").asInt());
                data.setProduct(objectNode.path("product").asText());
                data.setValue(objectNode.path("value").asDouble());
                data.setProductName(objectNode.path("product-name").asText());
                data.setSeriesDescription(objectNode.path("series-description").asText());
                data.setUnits(objectNode.path("units").asText());

                objectDataList.add(data);
//                System.out.println("Period: " + objectNode.path("period").asInt());
//                System.out.println("Product " + objectNode.path("product").asText());
//                System.out.println("Value " + objectNode.path("value").asDouble());
            }


            return objectDataList;
        } catch (Exception e) {
            // Log the exception using a logging framework
            e.printStackTrace();
            return null;
        }
    }
}
