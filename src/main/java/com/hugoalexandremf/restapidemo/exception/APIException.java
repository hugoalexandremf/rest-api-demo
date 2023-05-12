package com.hugoalexandremf.restapidemo.exception;

import com.hugoalexandremf.restapidemo.resource.apiresource.output.MessageErrorResource;
import org.springframework.http.HttpStatus;

public class APIException extends Exception {


     private final MessageErrorResource messageErrorResource;
     private final HttpStatus httpStatus;


     public APIException(MessageErrorResource messageErrorResource, HttpStatus httpStatus, String msg, Exception e) {
          super(msg, e);
          this.messageErrorResource = messageErrorResource;
          this.httpStatus = httpStatus;
     }


     public MessageErrorResource getMessageErrorResource() {
          return messageErrorResource;
     }

     public HttpStatus getHttpStatus() {
          return httpStatus;
     }
}
