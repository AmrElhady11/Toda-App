package com.TodaApp.service;


import com.TodaApp.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@RequiredArgsConstructor
@Service
public class JwtService {
    private final RestTemplate restTemplate;

    public UserInfoResponse checkToken(String jwt) {
        final String url = "http://localhost:8080/api/v1/auth/checkToken?token=" + jwt;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwt);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<UserInfoResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                UserInfoResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new IllegalStateException("Token validation failed: " + response.getStatusCode());
        }
    }



}
