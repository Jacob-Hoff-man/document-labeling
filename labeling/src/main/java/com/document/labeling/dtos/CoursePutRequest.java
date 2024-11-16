package com.document.labeling.dtos;

public class CoursePutRequest {
    private String name;
    private String description;

    public CoursePutRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CoursePutRequest [name=" + name + ", description=" + description + "]";
    }
}
