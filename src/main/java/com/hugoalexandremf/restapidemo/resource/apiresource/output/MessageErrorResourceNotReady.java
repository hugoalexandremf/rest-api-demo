package com.hugoalexandremf.restapidemo.resource.apiresource.output;

public class MessageErrorResourceNotReady extends MessageErrorResource {

     private final Integer retryAfter;

     public MessageErrorResourceNotReady(String errorCode, String error_description, Integer retryAfter) {
          super(errorCode, error_description);
          this.retryAfter = retryAfter;
     }

     public Integer getRetryAfter() {
          return retryAfter;
     }

     @Override
     public String toString() {
          return "MessageErrorResourceNotReady{" + "errorCode=" + this.getErrorCode() + ", error_description=" + this.getError_description() + ", retryAfter=" + retryAfter + '}';
     }

}
