package com.nachiket.consume3rdpartyapi.Upstream;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class upstream {

    @Value("${anchor.baseurl}")
    private String baseUrl;

    @Value("${anchor.refresh.token}")
    private String refreshToken;

    private String getAccessToken() {
        // TODO get Access token from refresh token
        // auth API that gives us the access token
        return "JWT TOKEN WILL BE HERE";
    }

    public boolean addInvoice(ObjectNode invoice) {

        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("Accept", "application/vnd.anchor_dashboard.com; version=1");
        header.add("Content-Type", "application/json");
        header.add("Authorization", getAccessToken());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "HEADER");
        headers.set("Content-Type", "HEADER");
        headers.set("Authorization", getAccessToken());

        HttpEntity<?> request = new HttpEntity<>(invoice, headers);

        String url = baseUrl + "/path";
        ResponseEntity<String> responseEntity =
                new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return true;
        }
        return false;
    }


}
