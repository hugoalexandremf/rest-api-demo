package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.element;

public class ListElement {

    private final String id;

    public ListElement(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ListElement{" +
                "id='" + id + '\'' +
                '}';
    }
}
