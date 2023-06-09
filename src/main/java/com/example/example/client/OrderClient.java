package com.example.example.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrderClient {


    private final WebClient webClient;

    public OrderClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://order-service:" + Optional.ofNullable(System.getenv("SERVER_HTTP_PORT")).orElse("8081"))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    public long filter(UUID postamatId, String status) {
        var value = Objects.requireNonNull(this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/")
                        .queryParam("status", status)
                        .queryParam("postamatId", postamatId)
                        .queryParam("page", 0)
                        .queryParam("size", 1)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<Object, Object>>() {
                })
                .block());
        return Long.parseLong(String.valueOf(value.get("totalElements")));
    }
}
