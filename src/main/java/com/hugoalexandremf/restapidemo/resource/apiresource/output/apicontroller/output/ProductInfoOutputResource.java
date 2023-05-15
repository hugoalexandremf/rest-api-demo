package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output;

public class ProductInfoOutputResource {


     private final String id;
     private final String name;
     private final Double value;


     public ProductInfoOutputResource(String id, String name, Double value) {
          this.id = id;
          this.name = name;
          this.value = value;
     }


     public String getId() {
          return id;
     }

     public String getName() {
          return name;
     }

     public Double getValue() {
          return value;
     }


     @Override
     public String toString() {
          return "ProductInfoOutputResource{" +
                  "id='" + id + '\'' +
                  ", name='" + name + '\'' +
                  ", value=" + value +
                  '}';
     }
}
