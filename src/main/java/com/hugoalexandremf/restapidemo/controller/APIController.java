package com.hugoalexandremf.restapidemo.controller;

import com.hugoalexandremf.restapidemo.exception.APIException;
import com.hugoalexandremf.restapidemo.exception.validationservice.ResourceNotReadyException;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.MessageErrorResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.ProductToAddInfoInputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.UpdateProductFieldsInputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.UpdateProductInputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.InsertProductOutputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.ProductInfoOutputResource;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     public ResponseEntity<Void> post_products(@RequestBody @Valid ProductToAddInfoInputResource productToAddInfoInputResource) throws APIException {
          LOG.info(RequestMethod.POST + " /api/v1/products");

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
      * @param productId
      * @throws APIException
      */
     @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<ProductInfoOutputResource> get_products_productid(@PathVariable String productId) throws APIException {
          LOG.info(RequestMethod.GET + " /api/v1/products/" + productId);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          return new ResponseEntity<>(new ProductInfoOutputResource("1", "test", Double.parseDouble("1.00")), HttpStatus.OK);
     }


     @RequestMapping(value = "/products", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> put_products_productid(@RequestBody @Valid UpdateProductInputResource updateProductInputResource) throws APIException {
          LOG.info(RequestMethod.PUT + " /api/v1/products/" + updateProductInputResource.getId());
          LOG.info("UpdateProductInputResource:" + updateProductInputResource);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          return ResponseEntity
                  .ok()
                  .build();
     }

     @RequestMapping(value = "/products", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> put_products_productid(@RequestBody @Valid UpdateProductFieldsInputResource updateProductFieldsInputResource) throws APIException {
          LOG.info(RequestMethod.PUT + " /api/v1/products/" + updateProductFieldsInputResource.getId());
          LOG.info("UpdateProductFieldsInputResource:" + updateProductFieldsInputResource);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          return ResponseEntity
                  .ok()
                  .build();
     }

     @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> delete_products_productid(@PathVariable String productId) throws APIException {
          LOG.info(RequestMethod.DELETE + " /api/v1/products/" + productId);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          return ResponseEntity
                  .noContent()
                  .build();
     }

     /**/

     @ApiResponses({
             @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                     schema = @Schema(implementation = MessageErrorResource.class))})})
     @RequestMapping(value = "/nop", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public void nop() {
          LOG.info(" - /nop");

          //NOP
          LOG.info(" - Return: " + "void");
     }

}
