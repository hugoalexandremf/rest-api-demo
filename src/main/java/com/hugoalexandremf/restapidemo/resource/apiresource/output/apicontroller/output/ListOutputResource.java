package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output;

import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.output.element.ListElement;

import java.util.List;

public class ListOutputResource {

    private final List<ListElement> list;

    public ListOutputResource(List<ListElement> list) {
        this.list = list;
    }

    public List<ListElement> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ListOutputResource{" +
                "list=" + list +
                '}';
    }
}
