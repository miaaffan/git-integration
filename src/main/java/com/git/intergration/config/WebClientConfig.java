//package com.git.intergration.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.client.ExchangeStrategies;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Configuration
//public class WebClientConfig  {
//    @Bean
//    public WebClient webclient() {
//        final int size = 16 * 1024 * 1024;
//        final ExchangeStrategies strategies = ExchangeStrategies.builder()
//                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
//                .build();
//
//        WebClient webClient = WebClient
//                .builder()
//                .baseUrl("https://api.github.com/")
//                .defaultCookie("cookieKey", "cookieValue")
//                .exchangeStrategies(strategies)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        return webClient;
//    }
//
//}