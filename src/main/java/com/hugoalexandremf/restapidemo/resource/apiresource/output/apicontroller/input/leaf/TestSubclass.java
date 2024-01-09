package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.leaf;

import com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input.TestClass;

public class TestSubclass extends TestClass {

    private String subClassField;
    private String id;

    public TestSubclass() {
    }

    public String getSubClassField() {
        return subClassField;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setSubClassField(String subClassField) {
        this.subClassField = subClassField;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestSubclass{" +
                "subClassField='" + subClassField + '\'' +
                ", id='" + id + '\'' +
                "} " + super.toString();
    }
}
