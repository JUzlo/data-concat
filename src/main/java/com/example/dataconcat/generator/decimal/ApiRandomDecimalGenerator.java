package com.example.dataconcat.generator.decimal;

import com.example.dataconcat.config.ApiRandomGeneratorConfig;
import com.example.dataconcat.generator.decimal.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiRandomDecimalGenerator implements DecimalValueGenerator {
    private static final String BASE_URL = "https://www.random.org/integers/";
    private static final Logger logger = LoggerFactory.getLogger(SimpleJavaRandomDecimalGenerator.class);

    private final ApiRandomGeneratorConfig apiRandomGeneratorConfig;

    public ApiRandomDecimalGenerator(ApiRandomGeneratorConfig apiRandomGeneratorConfig) {
        this.apiRandomGeneratorConfig = apiRandomGeneratorConfig;
    }

    @Override
    public BigDecimal generate() {
        var client = getHttpClient();
        var request = buildHttpRequest();
        HttpResponse<String> response = getStringHttpResponse(client, request);

        String body = response.body();
        BigDecimal randomDecimal = new BigDecimal(body.trim());

        logger.info("API Generated value {}", randomDecimal);
        return randomDecimal;
    }

    private HttpClient getHttpClient() {
        return HttpClient.newHttpClient();
    }

    private HttpRequest buildHttpRequest() {
        var builder = UriBuilder.fromUri(BASE_URL);
        apiRandomGeneratorConfig.getParameters().forEach(builder::queryParam);

        return HttpRequest.newBuilder().GET()
                .uri(builder.build())
                .build();
    }

    private HttpResponse<String> getStringHttpResponse(HttpClient client, HttpRequest request) {
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ApiException("Unexpected API exception");
        }
        return response;
    }

}
