package com.hugoalexandremf.restapidemo.resource.apiresource.output;

public class MessageErrorResource {


     private final String errorCode;
     private final String error_description;


     public MessageErrorResource(String errorCode, String error_description) {
          this.errorCode = errorCode;
          this.error_description = error_description;
     }


     public String getErrorCode() {
          return errorCode;
     }

     public String getError_description() {
          return error_description;
     }


     @Override
     public String toString() {
          return "MessageErrorResource{" +
                  "errorCode='" + errorCode + '\'' +
                  ", error_description='" + error_description + '\'' +
                  '}';
     }
}
