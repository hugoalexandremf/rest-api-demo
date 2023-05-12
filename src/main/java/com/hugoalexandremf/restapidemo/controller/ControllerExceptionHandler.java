package com.hugoalexandremf.restapidemo.controller;

import com.hugoalexandremf.restapidemo.exception.validationservice.ResourceNotReadyException;
import com.hugoalexandremf.restapidemo.resource.apiresource.output.MessageErrorResourceNotReady;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {


     private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);


     @ExceptionHandler(ResourceNotReadyException.class)
     public ResponseEntity<MessageErrorResourceNotReady> resourceNotReadyException(ResourceNotReadyException e) {

          LOG.info("resourceNotReadyException:" + e);
          ResponseEntity<MessageErrorResourceNotReady> rE = new ResponseEntity<>(new MessageErrorResourceNotReady(e.getMessageErrorResource().getErrorCode(), e.getMessageErrorResource().getError_description(), e.getRetryAfter()), e.getHttpStatus());
          LOG.info("rE: " + rE);

          return rE;
     }
}
