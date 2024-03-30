package br.com.fiapfood.production.infrastructure.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class OrderClient {

    @Value("${order.api.url}")
    private String getUrl;

    private final RestTemplate restTemplate;

    //private final WebClient webClient;


//    public Mono<String> makeAuthenticatedRequest(Long id) {
//        return webClient.get()
//                .uri(getUrl+id)
//                .retrieve()
//                .bodyToMono(String.class);
//    }
    public String getOrderById(Long id, String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

         var value = restTemplate.exchange(getUrl+id, HttpMethod.GET, requestEntity, String.class);

        //var value = makeAuthenticatedRequest(id);
        return value.getBody();
    }

}
