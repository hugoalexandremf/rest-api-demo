package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateProductInputResource {


     @NotNull
     @NotEmpty
     private String id;
     @NotNull
     @NotEmpty
     private String name;


     public UpdateProductInputResource() {
     }


     public String getId() {
          return id;
     }

     public String getName() {
          return name;
     }


     public void setId(String id) {
          this.id = id;
     }

     public void setName(String name) {
          this.name = name;
     }


     @Override
     public String toString() {
          return "UpdateProductInputResource{" +
                  "id='" + id + '\'' +
                  ", name='" + name + '\'' +
                  '}';
     }
}
