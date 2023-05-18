package com.hugoalexandremf.restapidemo;

import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class APIControllerTests {

     private static final Logger LOG = LoggerFactory.getLogger(APIControllerTests.class);

     /*@Autowired
     TestRestTemplate testRestTemplate;*/

     private TestRestTemplate testRestTemplate;
     @LocalServerPort
     private int port;

     public APIControllerTests() {
          TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;

          SSLContext sslContext = null;

          try {
               sslContext = SSLContextBuilder
                       .create()
                       .loadTrustMaterial(null, acceptingTrustStrategy)
                       .build();

          } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
               LOG.info("E, sT: " + e, e);
          }

          /*SSLConnectionSocketFactory sslConnectionSocketFactory = null;
          try {
               //sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
               //noophostnameverifier
               sslConnectionSocketFactory = new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build(), NoopHostnameVerifier.INSTANCE);
          } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
               throw new RuntimeException(e);
          }

          HttpClientBuilder httpClientBuilder = HttpClients.custom();
          //PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
          Registry<ConnectionSocketFactory> registry = RegistryBuilder.
                  <ConnectionSocketFactory>create()
                  .register("http", new PlainConnectionSocketFactory())
                  .register("https", sslConnectionSocketFactory)
                  .build();*/

          //PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
          PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                  .setSSLSocketFactory(SSLConnectionSocketFactoryBuilder.create()
                          .setSslContext(sslContext)
                          .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                          .build())
                  .build();

          /*HttpClient httpClient = HttpClients.custom()
                  //.setSSLContext(sslContext)
                  .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                  .build();*/

          HttpClientBuilder httpClientBuilder = HttpClients.custom();
          httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);

          RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
                  .setConnectTimeout(Duration.ofSeconds(45))
                  //.setReadTimeout(Duration.ofSeconds(45))
                  .requestFactory(() -> new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build())));

          this.testRestTemplate = new TestRestTemplate(restTemplateBuilder);
     }

     @Test
     public void givenGetRequest_whenHealthIsRetrieved_then200IsReceived() {
          ResponseEntity<Void> responseEntity = testRestTemplate.getForEntity("https://localhost:" + port + "/api/v1/health", Void.class);

          assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
     }
}
