package com.hugoalexandremf.restapidemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class APIControllerTests {

     @Autowired
     TestRestTemplate testRestTemplate;

     @Test
     public void givenGetRequest_whenHealthIsRetrieved_then200IsReceived() {
          ResponseEntity<Void> responseEntity = testRestTemplate.getForEntity("/api/v1/health", Void.class);

          assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
     }
}
