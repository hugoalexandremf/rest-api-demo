package com.hugoalexandremf.restapidemo.controller;

import com.hugoalexandremf.restapidemo.exception.APIException;
import com.hugoalexandremf.restapidemo.exception.validationservice.ResourceNotReadyException;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.MessageErrorResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.ProductToAddInfoInputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.UpdateProductFieldsInputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.UpdateProductInputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.leaf.TestSubclass;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.InsertProductOutputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.ListOutputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.ProductInfoOutputResource;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.element.ListElement;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1")
public class APIController {


     private static final Logger logger = LoggerFactory.getLogger(APIController.class);


     @RequestMapping(value = "/health", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public String health() {
          logger.debug("/api/v1/health");

          String response = "{\"status\":\"ok\"}";

          logger.debug("Return: " + response);
          return response;
     }

     @RequestMapping(value = "/sigFinalize", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public String sigFinalize() throws APIException {
          logger.debug("/api/v1/sigFinalize");

          /*try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }*/

          throw new ResourceNotReadyException("", null, 10);
     }

     /**
      * @param productToAddInfoInputResource
      * @return
      * @throws APIException
      */
     @RequestMapping(value = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductToAddInfoInputResource productToAddInfoInputResource) throws APIException {
          logger.info(RequestMethod.POST + " /api/v1/products");

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
      * @param productId
      * @return
      * @throws APIException
      */
     @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<ProductInfoOutputResource> getProduct(@PathVariable String productId) throws APIException {
          logger.info(RequestMethod.GET + " /api/v1/products/" + productId);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          ProductInfoOutputResource productInfoOutputResource = new ProductInfoOutputResource("1", "test", Double.parseDouble("1.00"));
          logger.info(productInfoOutputResource.toString());

          return new ResponseEntity<>(productInfoOutputResource, HttpStatus.OK);
     }

     /**
      * @param updateProductInputResource
      * @return
      * @throws APIException
      */
     @RequestMapping(value = "/products", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> updateProduct(@RequestBody @Valid UpdateProductInputResource updateProductInputResource) throws APIException {
          logger.info(RequestMethod.PUT + " /api/v1/products/" + updateProductInputResource.getId());
          logger.info("UpdateProductInputResource:" + updateProductInputResource);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          return ResponseEntity
                  .ok()
                  .build();
     }

     /**
      * @param updateProductFieldsInputResource
      * @return
      * @throws APIException
      */
     @RequestMapping(value = "/products", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> updateProductFields(@RequestBody @Valid UpdateProductFieldsInputResource updateProductFieldsInputResource) throws APIException {
          logger.info(RequestMethod.PUT + " /api/v1/products/" + updateProductFieldsInputResource.getId());
          logger.info("UpdateProductFieldsInputResource:" + updateProductFieldsInputResource);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          return ResponseEntity
                  .ok()
                  .build();
     }

     /**
      * @param productId
      * @return
      * @throws APIException
      */
     @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Void> deleteProduct(@PathVariable String productId) throws APIException {
          logger.info(RequestMethod.DELETE + " /api/v1/products/" + productId);

          try {
               TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
               throw new RuntimeException(e);
          }

          return ResponseEntity
                  .noContent()
                  .build();
     }

     @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public List<ListElement> getList() throws APIException {
          logger.info(RequestMethod.GET + " /list");

          ListOutputResource listOutputResource = new ListOutputResource(List.of(new ListElement("1"), new ListElement("2")));

          return listOutputResource.getList();
     }

     @RequestMapping(value = "/populateClassSubClass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public void populateClassSubClass(@RequestBody TestSubclass testSubclass) throws APIException {
          logger.info("{} - /populateClassSubClass", RequestMethod.GET);
          logger.info(testSubclass.toString());

          ListOutputResource listOutputResource = new ListOutputResource(List.of(new ListElement("1"), new ListElement("2")));
     }

     /**/

     @ApiResponses({
             @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                     schema = @Schema(implementation = MessageErrorResource.class))})})
     @RequestMapping(value = "/nop", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public void nop() {
          logger.info(" - /nop");

          //NOP
          logger.info(" - Return: " + "void");
     }

}
