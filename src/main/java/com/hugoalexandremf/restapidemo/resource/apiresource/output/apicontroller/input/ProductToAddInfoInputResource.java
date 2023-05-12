package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductToAddInfoInputResource {

     @NotNull
     @NotEmpty
     private String name;
     @NotNull
     @NotEmpty
     private String value;


     public ProductToAddInfoInputResource() {
     }


     public String getName() {
          return name;
     }

     public String getValue() {
          return value;
     }


     @Override
     public String toString() {
          return "ProductToAddInfo{" +
                  "name='" + name + '\'' +
                  ", value='" + value + '\'' +
                  '}';
     }
}
