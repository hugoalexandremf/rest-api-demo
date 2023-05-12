package com.hugoalexandremf.restapidemo.exception.validationservice;

import com.hugoalexandremf.restapidemo.exception.APIException;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.MessageErrorResource;
import org.springframework.http.HttpStatus;

public class ValidationServiceException extends APIException {

     public ValidationServiceException(MessageErrorResource messageErrorResource, HttpStatus httpStatus, String msg, Exception e) {
          super(messageErrorResource, httpStatus, msg, e);
     }

}
