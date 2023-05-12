package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output;

import java.net.URI;

public class InsertProductOutputResource {

     private final URI locationURI;


     public InsertProductOutputResource(URI locationURI) {
          this.locationURI = locationURI;
     }


     public URI getLocationURI() {
          return locationURI;
     }


     @Override
     public String toString() {
          return "InsertProductOutputResource{" +
                  "locationURI=" + locationURI +
                  '}';
     }
}
