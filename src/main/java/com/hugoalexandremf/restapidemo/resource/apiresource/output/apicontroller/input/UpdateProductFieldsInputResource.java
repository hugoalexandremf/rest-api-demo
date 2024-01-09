package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input;

import jakarta.validation.constraints.NotNull;

public class UpdateProductFieldsInputResource {


    @NotNull
     private String id;
    @NotNull
     private String name;


     public UpdateProductFieldsInputResource() {
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
          return "UpdateProductFieldsInputResource{" +
                  "id='" + id + '\'' +
                  ", name='" + name + '\'' +
                  '}';
     }
}
