package com.hugoalexandremf.restapidemo.resource.apiresource.output.apicontroller.input;

public class TestClass {

    private String superClassField;
    private String id;

    public TestClass() {
    }

    public String getSuperClassField() {
        return superClassField;
    }

    public String getId() {
        return id;
    }

    public void setSuperClassField(String superClassField) {
        this.superClassField = superClassField;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "superClassField='" + superClassField + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
