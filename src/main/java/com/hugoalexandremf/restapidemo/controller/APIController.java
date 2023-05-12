package com.hugoalexandremf.restapidemo.controller;

import com.hugoalexandremf.restapidemo.exception.APIException;
import com.hugoalexandremf.restapidemo.exception.validationservice.ResourceNotReadyException;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.ProductToAddInfoInputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.InsertProductOutputResource;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1")
public class APIController {


     private static final Logger LOG = LoggerFactory.getLogger(APIController.class);


     @RequestMapping(value = "/health", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public String health() {
          LOG.debug("/api/v1/health");

          String response = "{\"status\":\"ok\"}";

          LOG.debug("Return: " + response);
          return response;
     }

     @RequestMapping(value = "/sigFinalize", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public String sigFinalize() throws APIException {
          LOG.debug("/api/v1/sigFinalize");

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          throw new ResourceNotReadyException("", null, 10);
     }

     /**
      *
      * @param productToAddInfoInputResource
      * @return
      * @throws APIException
      */
     @RequestMapping(value = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<InsertProductOutputResource> products(@RequestBody @Valid ProductToAddInfoInputResource productToAddInfoInputResource) throws APIException {
          LOG.info("/api/v1/products");

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          InsertProductOutputResource insertProductOutputResource = new InsertProductOutputResource(URI.create("/products/123"));

          return ResponseEntity
                  .created(URI.create("/products/1"))
                  /*.status(HttpStatus.CREATED)
                  .header(HttpHeaders.LOCATION, uriOfCashCard.toASCIIString())*/
                  .build();
     }

     /**
      *
      * @param productToAddInfoInputResource
      * @return
      * @throws APIException
      */
     @RequestMapping(value = "/products/{productId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<InsertProductOutputResource> test(@RequestBody @Valid ProductToAddInfoInputResource productToAddInfoInputResource) throws APIException {
          LOG.info("/api/v1/products");

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          InsertProductOutputResource insertProductOutputResource = new InsertProductOutputResource(URI.create("/products/123"));

          return ResponseEntity
                  .created(URI.create("/products/1"))
                  /*.status(HttpStatus.CREATED)
                  .header(HttpHeaders.LOCATION, uriOfCashCard.toASCIIString())*/
                  .build();
     }

}
