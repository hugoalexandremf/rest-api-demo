package com.hugoalexandremf.restapidemo.exception.validationservice;

import com.hugoalexandremf.restapidemo.resource.apiresource.output.MessageErrorResource;
import org.springframework.http.HttpStatus;

public class ResourceNotReadyException extends ValidationServiceException {


     private final Integer retryAfter;


     public ResourceNotReadyException(String msgC, Exception eC, Integer retryAfter) {
          super(new MessageErrorResource("028001", "Resource not ready."), HttpStatus.INTERNAL_SERVER_ERROR, msgC, eC);
          this.retryAfter = retryAfter;
     }


     public Integer getRetryAfter() {
          return retryAfter;
     }
}
